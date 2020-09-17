package com.distlock.zookeeper;

import com.distlock.Locker;

/**
 * @author liujp
 * @create 2020-09-17 11:49
 */
public class ZkLockerTest {

    public static void main(String[] args){
        Locker locker = new ZkLocker();

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
            }).start();
        }
    }
}
