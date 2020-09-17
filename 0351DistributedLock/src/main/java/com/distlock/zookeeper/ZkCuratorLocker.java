package com.distlock.zookeeper;

import com.distlock.Locker;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import javax.annotation.PostConstruct;

/**
 * @author liujp
 * @create 2020-09-17 16:10
 */
@Slf4j
public class ZkCuratorLocker implements Locker {

    public static final String CONNADDR = "127.0.0.1:2181";
    public static final int TIMEOUT = 60000;
    public static final String LOCKER_ROOT = "/locker";

    private CuratorFramework cf;

    //@PostConstruct
    public ZkCuratorLocker() {
        this.cf = CuratorFrameworkFactory.builder()
                .connectString(CONNADDR)
                .connectionTimeoutMs(TIMEOUT)
                .retryPolicy(new ExponentialBackoffRetry(100, 3))
                .build();
        this.cf.start();
    }


    @Override
    public void lock(String key, Runnable command) {
        String path = LOCKER_ROOT + "/" + key;
        InterProcessLock lock = new InterProcessMutex(cf, path);
        try {
            lock.acquire();
            command.run();
        } catch (Exception e) {
            log.error("get lock error", e);
            throw new RuntimeException("get lock error");
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                log.error("release lock error", e);
                throw new RuntimeException("release error");
            }
        }
    }
}
