package com.abq;

public class MyBlockingQueueTest {
    static MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.endequeue(finalI);
                }
            }).start();
        }

        for(int i = 0; i < 100; i++) {
            new Thread(()->{
                queue.dequeue();
            }).start();
        }
    }
}
