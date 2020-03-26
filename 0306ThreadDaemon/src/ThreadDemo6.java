
/**
 * 线程分类: 
 * 1.用户线程:默认情况下创建的线程都为用户线程;当程序中存在用户线程,那么该程序必须等待用户线程执行完毕后程序才会终止
 * 2.守护线程:当用户线程执行完成后,守护线程也退出
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Thread t = new Thread(new MyThread());
		t.setDaemon(true);// 设置为守护线程
		t.start();
		
		Thread t2=new Thread(new MyThread2());
		t2.start();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main-" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {// 注意运行20次,但是用户线程在10次后结束,守护线程也将结束
			System.out.println("MyThread-" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class MyThread2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {// 注意运行20次,但是用户线程在10次后结束,守护线程也将结束
			System.out.println("MyThread2-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
