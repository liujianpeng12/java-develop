package com.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {

	static ArrayBlockingQueue<Apple> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args){
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}

class Apple {

}

class Producer implements Runnable {
	ArrayBlockingQueue<Apple> queue;

	public Producer(ArrayBlockingQueue<Apple> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Apple apple = new Apple();
				//将元素插入此队列的尾部，如果该队列已满，则一直阻塞
				queue.put(apple);
				System.out.println("生产apple" + apple);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	ArrayBlockingQueue<Apple> queue;

	public Consumer(ArrayBlockingQueue<Apple> queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		while(true){
			try {
				TimeUnit.MICROSECONDS.sleep(1000);
				//获取并移除此队列头元素，若没有元素则一直阻塞
				Apple apple = queue.take();
				System.out.println("消费Apple:" + apple);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
