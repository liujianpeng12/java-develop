package com0302ThreadDemo;

/**
 * 使用synchronized同步线程数据共享
 * @author Administrator
 *
 */
public class ThreadDemo5 {
	
	public static void main(String[] args) {
		MyThread4 t = new MyThread4();
		
		Thread a = new Thread(t, "A");
		Thread b = new Thread(t, "B");
		Thread c = new Thread(t, "C");
		a.start();
		b.start();
		c.start();
	}
}

class MyThread4 extends Thread {
	
	private int count = 5;
	Object obj = new Object ();

	@Override
	public void run() {
		while(count > 1) {//注意这里需要是1
			synchronized(obj){
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
}