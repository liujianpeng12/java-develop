package com0307Synchronized01;
/**
 * 在多线程的操作中,多个线程有可能同时处理同一个资源,这就是多线程的共享数据
 * 线程同步:
 * 1.线程不安全:多线程共享一个数据时,将导致数据值的错误结果
 * 2.使用同步方法解决线程不安全的问题
 * 	1)同步代码块
 * 	2)同步方法
 * 3.同步代码应尽量简洁,把安全性没有根据代码移出同步块
 * 4.同步方法同步的是当前对象,那么当同步方法被调用时,该对象的其他同步方法都将等待对象锁
 * 5.同步代码会带来性能降低问题,同步越多性能越低,还可能造成死锁
 * 6.同步代码是以牺牲性能换来数据安全
 */
public class ThreadDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//method1();
		method2();
	}

	private static void method1() {
		MyThread my = new MyThread();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		t1.start();
		t2.start();
	}

	private static void method2() {
		MyThread2 my = new MyThread2();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		t1.start();
		t2.start();
	}
}

class MyThread implements Runnable {
	int num = 10;//成员变量, 多线程对同一实例共享成员变量
	Object obj = new Object();

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			// 同步代码块
			synchronized (obj) {
				if (num > 0) {
					System.out.println(Thread.currentThread().getName() + "--" + num);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					num--;
				}
			}
		}
	}
}

class MyThread2 implements Runnable {

	int num = 10;

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			method();
		}
	}

	/**
	 * 同步方法
	 */
	public synchronized void method() {
		if (num > 0) {
			System.out.println(Thread.currentThread().getName() + "--" + num);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			num--;
		}
	}
}
