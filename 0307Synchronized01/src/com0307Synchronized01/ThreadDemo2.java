package com0307Synchronized01;

/**
 * synchronized 是可重入锁: 一个获得的锁的线程没执行完可以继续获得锁
 * 线程占用锁的时候，如果执行的同步出现异常，会将锁让出
 * @author Administrator
 *
 */
public class ThreadDemo2 {

	public static void main(String[] args) {
		Service s = new Service();
		MyThread6 t =  new MyThread6(s);
		t.start();
	}
	
}

class MyThread6 extends Thread{
	Service s;
	public MyThread6(Service s){
		this.s = s;
	}
	
	@Override
	public void run() {
		s.service1();
	}
}

class Service{
	public synchronized void service1(){
		System.out.println("方法1");
		service2();
	}
	
	public synchronized void service2(){
		System.out.println("方法2");
		service3();
	}
	
	public synchronized void service3(){
		System.out.println("方法3");
	}
}
