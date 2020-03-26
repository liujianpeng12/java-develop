

/**
 *  线程的优先级: 线程的优先级不可靠
 * 1、优先级从1－10个级别
 * 2、优先级高的线程会优先抢占CPU的执行资源
 *
 */
public class ThreadDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread my=new MyThread();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t2.start();
		t1.start();
		
	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}		
	}	
}



