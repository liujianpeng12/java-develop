package com.distlock.zookeeper;

import com.distlock.Locker;

/**
 * curator实现zookeeper锁
 */
public class ZkLockerTest2 {

    public static void main(String[] args){
        Locker locker = new ZkCuratorLocker();

        for(int i=0; i<1000; i++) {
            new Thread(() -> {
                locker.lock("user_1", () -> {
                    System.out.println(String.format("user_1 time: %d, threadname: %s", System.currentTimeMillis(), Thread.currentThread().getName()));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }, "Thread-" + i).start();
        }

        for(int i=0; i<1000; i++) {
            new Thread(() -> {
                locker.lock("user_2", () -> {
                    System.out.println(String.format("user_2 time: %d, threadname: %s", System.currentTimeMillis(), Thread.currentThread().getName()));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }, "Thread-" + i).start();
        }
    }
}
