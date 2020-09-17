package com.distlock.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * zookeeper锁,利用了zookeeper的3个特性:
 * 1.同一个节点只能创建一次，加锁时检测节点是否存在，不存在则创建之
 * 2.事件监听,监听节点的删除等操作
 * 3.节点的临时性: 为了规避客户端获取锁后突然断线的风险，使用临时有序节点
 *
 * 原理参见: https://www.cnblogs.com/tong-yuan/p/11619006.html
 *
 * （1）zookeeper中的节点有四种类型：持久、持久有序、临时、临时有序；
 * （2）zookeeper提供了一种非常重要的特性——监听机制，它可以用来监听节点的变化；
 * （3）zookeeper分布式锁是基于 临时有序节点 + 监听机制 实现的；
 * （4）zookeeper分布式锁加锁时在锁路径下创建临时有序节点；
 * （5）如果自己是第一个节点，则获得锁；
 * （6）如果自己不是第一个节点，则监听前一个节点，并阻塞当前线程；
 * （7）当监听到前一个节点的删除事件时，唤醒当前节点的线程，并再次检查自己是不是第一个节点；
 * （8）使用临时有序节点而不是持久有序节点是为了让客户端无故断线时能够自动释放锁；
 */
@Slf4j
public class ZkLockerWatcher implements Watcher {
    public static final String CONNADDR = "127.0.0.1:2181";
    public static final int TIMEOUT = 60000;
    public static final String LOCKER_ROOT = "/locker";

    static ZooKeeper zookeeper;
    String parentLockPath;
    String childLockPath;
    static Thread thread;

    public static ZkLockerWatcher conn(String key) {
        ZkLockerWatcher watcher = new ZkLockerWatcher();

        try {
            ZooKeeper zooKeeper = watcher.zookeeper = new ZooKeeper(CONNADDR, TIMEOUT, watcher);
            thread = Thread.currentThread();
            //阻塞等待连接建立完毕
            //LockSupport.park();

            //根节点如果不存在,就创建一个(并发问题，如果两个线程同时检测不存在，两个同时去创建必须有一个会失败)
            if(zookeeper.exists(LOCKER_ROOT, false) == null) {
                try {
                    zookeeper.create(LOCKER_ROOT, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                } catch(KeeperException e) {
                    // 如果节点已存在，则创建失败，这里捕获异常，并不阻挡程序正常运行
                    log.info("创建节点{}失败", LOCKER_ROOT);
                }
            }

            //当前加锁的节点是否存在,
            watcher.parentLockPath = LOCKER_ROOT + "/" + key;
            if(zookeeper.exists(watcher.parentLockPath, false) == null) {
                try {
                    zookeeper.create(watcher.parentLockPath, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                } catch(KeeperException e) {
                    // 如果节点已存在，则创建失败，这里捕获异常，并不阻挡程序正常运行
                    log.info("创建节点{}失败", watcher.parentLockPath);
                }
            }

        } catch (Exception e) {
            log.error("conn to zk error", e);
            throw new RuntimeException("conn to zk error");
        }

        return watcher;
    }

    public boolean getLock() {
        // 创建子节点
        try {
            this.childLockPath = zookeeper.create(parentLockPath + "/", "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
            // 检查自己是不是最小的节点，是则获取成功，不是则监听上一个节点
            return getLockOrWatcherLast();
        } catch (Exception e) {
            log.error("get lock error", e);
            throw new RuntimeException("get lock error");
        }
    }

    public void releaseLock() {
        try {
            if(childLockPath != null) {
                zookeeper.delete(childLockPath, -1);
            }

            // 最后一个释放的删除锁节点
            List<String> children = zookeeper.getChildren(parentLockPath, false);
            if(children.isEmpty()) {
                try {
                    zookeeper.delete(parentLockPath, -1);
                } catch(KeeperException e) {
                    // 如果删除之前又新加了一个子节点，会删除失败
                    log.info("删除节点{}失败", parentLockPath);
                }
            }

            // 关闭zk连接
            if(zookeeper != null) {
                zookeeper.close();
            }
        } catch (Exception e) {
            log.error("release lock error", e);
            throw new RuntimeException("release error");
        }
    }

    private boolean getLockOrWatcherLast() throws KeeperException, InterruptedException {
        List<String> children = zookeeper.getChildren(parentLockPath, false);
        // 必须要排序一下，这里取出来的顺序可能是乱的
        Collections.sort(children);

        // 如果当前节点是第一个子节点，则获取锁成功
        if((parentLockPath + "/" + children.get(0)).equalsIgnoreCase(childLockPath)) {
            return true;
        }

        // 如果不是第一个子节点，就监听前一个节点
        String last = "";
        for(String child : children) {
            if((parentLockPath + "/" + child).equalsIgnoreCase(childLockPath)) {
                break;
            }
            last = child;
        }
        if(zookeeper.exists(parentLockPath + "/" + last, true) != null) {
            this.thread = Thread.currentThread();
            //阻塞当前线程
            LockSupport.park();


            // 唤醒之后重新检测自己是不是最小的节点，因为有可能上一个节点断线了
            return getLockOrWatcherLast();
        } else {
            // 如果上一个节点不存在，说明还没来得及监听就释放了，重新检查一次
            return getLockOrWatcherLast();
        }
    }

    public void process(WatchedEvent watchedEvent) {
        if(this.thread != null) {
            // 唤醒阻塞的线程（这是在监听线程，跟获取锁的线程不是同一个线程）
            LockSupport.unpark(this.thread);
            this.thread =  null;
        }
    }
}
