package com0307Synchronized01;

/**
 * 两个线程访问同一个对象的两个同步代码块(synchronized方法或synchronized(同一对象))，这两个代码块是同步执行的
 *
 */
public class ThreadDemo3 {

	public static void main(String[] args) {
		Service2 s = new Service2();
		MyThread3 t1 =  new MyThread3(s);
		MyThread4 t2 =  new MyThread4(s);
		t1.start();
		t2.start();
	}

}

class MyThread3 extends Thread{
	Service2 s;
	public MyThread3(Service2 s){
		this.s = s;
	}

	@Override
	public void run() {
		s.service1();
	}
}

class MyThread4 extends Thread{
	Service2 s;
	public MyThread4(Service2 s){
		this.s = s;
	}

	@Override
	public void run() {
		s.service2();
	}
}

class Service2{
	public synchronized void service1(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public synchronized void service2(){
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
