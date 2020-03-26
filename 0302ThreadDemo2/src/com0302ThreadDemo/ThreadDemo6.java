package com0302ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 局部变量并不共享数据
 * 成员变量共享数据
 * @author Administrator
 *
 */
public class ThreadDemo6 {
	
	public static void main(String[] args) {
		PrivateNum p = new PrivateNum();
		MyThread6 t1 =  new MyThread6(p);
		MyThread6 t2 =  new MyThread6(p);
		t1.start();
		t2.start();
	}		
}

class MyThread6 extends Thread {
	PrivateNum p = null;
	public MyThread6(PrivateNum p){
		this.p = p;
	}
	
	@Override
	public void run() {
		p.test();
	}
}

class PrivateNum{
	int pubNum = 10;//成员变量, 多线程共享该数据
	public void test(){
		int num = 10;//局部变量, 多线程不共享该数据
		while(num > 0){
			System.out.println(Thread.currentThread().getName() + ":局部变量=" + num + ",成员变量=" + pubNum);
			num--;
			pubNum--;
		}
	}
}
