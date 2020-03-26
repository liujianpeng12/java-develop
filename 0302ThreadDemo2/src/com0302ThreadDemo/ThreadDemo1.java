package com0302ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多个线程访问的是两个不同实例的同一个同步方法: 不同实例不共享数据
 *
 */
public class ThreadDemo1 {
	
	public static void main(String[] args) {
		PrivateNum2 p1 = new PrivateNum2();
		PrivateNum2 p2 = new PrivateNum2();
		MyThread7 t1 =  new MyThread7(p1);
		MyThread7 t2 =  new MyThread7(p2);
		t1.start();
		t2.start();
	}		
}

class MyThread7 extends Thread {
	PrivateNum2 p = null;
	public MyThread7(PrivateNum2 p){
		this.p = p;
	}
	
	@Override
	public void run() {
		p.test();
	}
}

class PrivateNum2{
	int pubNum = 10;//成员变量, 多线路共享该数据
	public void test(){
		int num = 10;//局部变量, 多线程不共享该数据
		while(num > 0){
			System.out.println(Thread.currentThread().getName() + ":局部变量=" + num + ",成员变量=" + pubNum);
			num--;
			pubNum--;
		}
	}
}
