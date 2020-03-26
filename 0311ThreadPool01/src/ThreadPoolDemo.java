import java.util.concurrent.*;


public class ThreadPoolDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个单线程的线程池
		//ExecutorService se=Executors.newSingleThreadExecutor();
		
		//创建一个固定大小的线程池
		//ExecutorService se=Executors.newFixedThreadPool(2);
		
		//创建一个可缓存的线程池
		//ExecutorService se=Executors.newCachedThreadPool();
		
		//创建一个大小无限制的线程池
		ExecutorService se=Executors.newScheduledThreadPool(2);
		MyThread my=new MyThread();
		MyThread my2=new MyThread();
		se.execute(my);
		se.execute(my2);
	}

}

class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName() + "-" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}