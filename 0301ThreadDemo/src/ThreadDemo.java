import java.util.Date;

/**
 * 进程: 一个独立运行的程序,每一个进程有一个独立的内存空间
 * 线程:线程是程序中执行线程,JAVA虚拟机允许程序中并发的运行多个线程,进程中的多个线程共享内存空间
 *
 * 要实现多线程操作,有两种方式:
 * 1.继承Thread类,重写run方法
 * 2.实现Runnable接口,实现run方法(推荐使用)
 *
 * 线程的三个状态：
 * 1、在调用了start方法后，线程进入 就绪状态
 * 2、CPU分配执行时间并且该线程被调度，那么线程进入运行状态
 * 3、线程在运行过程中，导致线程阻塞，那么线程进入阻塞状态，
 * 		阻塞时间结束后，重新进入就绪状态
 *
 * @author Administrator
 *
 */
public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread1 t1=new MyThread1();
		t1.start();
		MyThread2 t2=new MyThread2();
		t2.start();

		MyRunnable myRunnable=new MyRunnable();
		Thread t3=new Thread(myRunnable);
		t3.start();
	}

}

class MyThread1 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("MyThread1 "+i + "-" + new Date().toString());
		}
	}
}

class MyThread2 extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName()+i + "-" + new Date().toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 推荐实现方式
 * @author Administrator
 *
 */
class MyRunnable implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("MyRunnable "+i + "-" + new Date().toString());
		}
	}

}
