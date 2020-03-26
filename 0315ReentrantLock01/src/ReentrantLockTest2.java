import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock公平锁 (貌似达不到效果)
 * @author Administrator
 *
 */
public class ReentrantLockTest2 {

	static ReentrantLock lock =  new ReentrantLock(true);
	
	public static void main(String[] args) throws InterruptedException{
		for (int i = 0; i < 5; i++) {
			//Thread.sleep(1);//测试加上休眠才能达到效果
			new Thread(new FairLock(i)).start();
			
		}
	}
	
	static class FairLock implements Runnable {
		
		int id;
		
		public FairLock(int id){
			this.id = id;
		}

		@Override
		public void run() {
			for (int i = 0; i < 2; i++) {
				lock.lock();
				System.out.println("锁id:" + id);
				lock.unlock();
			}

		}
		
	}
}
