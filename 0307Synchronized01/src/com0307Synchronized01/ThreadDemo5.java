package com0307Synchronized01;

public class ThreadDemo5 {

    public static final Object lock = new Object();

    // 锁的是ThreadDemo5.class对象
    public static synchronized void sync1() {

    }

    public static void sync2() {
        // 锁的是SynchronizedTest.class对象
        synchronized (ThreadDemo5.class) {

        }
    }

    // 锁的是当前实例this
    public synchronized void sync3() {

    }

    public void sync4() {
        // 锁的是当前实例this
        synchronized (this) {

        }
    }

    public void sync5() {
        // 锁的是指定对象lock
        synchronized (lock) {

        }
    }
}
