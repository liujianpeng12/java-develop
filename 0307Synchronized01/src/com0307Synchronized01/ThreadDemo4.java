package com0307Synchronized01;

/**
 * 两个线程访问同一个对象的两个同步代码块synchronized(不同对象)时，这两个代码块是异步执行的
 *
 */
public class ThreadDemo4 {

	public static void main(String[] args) {
		Service3 s = new Service3();
		MyThread7 t1 = new MyThread7(s);
		MyThread8 t2 = new MyThread8(s);
		t1.start();
		t2.start();
	}

}

class MyThread7 extends Thread {
	Service3 s;

	public MyThread7(Service3 s) {
		this.s = s;
	}

	@Override
	public void run() {
		s.service1();
	}
}

class MyThread8 extends Thread {
	Service3 s;

	public MyThread8(Service3 s) {
		this.s = s;
	}

	@Override
	public void run() {
		s.service2();
	}
}

class Service3 {
	Object obj1 = new Object();
	Object obj2 = new Object();

	public void service1() {
		synchronized (obj1) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}

	public void service2() {
		synchronized (obj2) {
			for (int i = 0; i < 5; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}
}
