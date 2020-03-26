package com0302ThreadDemo;
public class ThreadDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MyThread my=new MyThread();
		Thread t1=new Thread(my);
		Thread t2=new Thread(my);
		t1.start();
		t2.start();
		
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
