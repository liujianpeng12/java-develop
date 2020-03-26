package com0302ThreadDemo;

/**
 * 线程数据共享: 同一实例共享数据
 * @author Administrator
 *
 */
public class ThreadDemo4 {
	
	public static void main(String[] args) {
		MyThread3 t = new MyThread3();
		
		Thread a = new Thread(t, "A");
		Thread b = new Thread(t, "B");
		Thread c = new Thread(t, "C");
		a.start();
		b.start();
		c.start();
	}
}

class MyThread3 extends Thread {
	
	private int count = 5;

	@Override
	public void run() {
		while(count > 0) {
			System.out.println(Thread.currentThread().getName() + ":" + count);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}
	}
}