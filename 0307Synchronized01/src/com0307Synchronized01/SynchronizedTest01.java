package com0307Synchronized01;

/**
 * 运行结果说明 synchronized是一个非公平锁
 */
public class SynchronizedTest01 {

    public static void main(String[] args) throws InterruptedException{
        new Thread(()->{sync("线程1");}).start();
        //Thread.sleep(100);
        new Thread(()->{sync("线程2");}).start();
        //Thread.sleep(100);
        new Thread(()->{sync("线程3");}).start();
        //Thread.sleep(100);
        new Thread(()->{sync("线程4");}).start();
    }

    private static void sync(String tips) {
        synchronized ( SynchronizedTest01.class) {
            System.out.println(tips);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
