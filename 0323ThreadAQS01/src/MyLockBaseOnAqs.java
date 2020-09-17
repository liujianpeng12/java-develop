import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * https://www.cnblogs.com/tong-yuan/p/AQS.html
 * 
 * AQS的全称是AbstractQueuedSynchronizer，它的定位是为Java中几乎所有的锁和同步器提供一个基础框架
 * 
 * AQS是基于FIFO的队列实现的，并且内部维护了一个状态变量state，通过原子更新这个状态变量state即可以实现加锁解锁操作
 * 
 * （1）AQS是Java中几乎所有锁和同步器的一个基础框架，这里说的是“几乎”，因为有极个别确实没有通过AQS来实现；
 * （2）AQS中维护了一个队列，这个队列使用双链表实现，用于保存等待锁排队的线程；
 * （3）AQS中维护了一个状态变量，控制这个状态变量就可以实现加锁解锁操作了；
 * （4）基于AQS自己动手写一个锁非常简单，只需要实现AQS的几个方法即可。
 *
 */
public class MyLockBaseOnAqs {

	//定义一个同步器,实现AQS类
	private static class Sync extends AbstractQueuedSynchronizer {
		
		// 实现tryAcquire(acquires)方法
		@Override
		public boolean tryAcquire(int acquires) {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return true;
			}
			return false;
		}
		
		// 实现tryRelease(releases)方法
		@Override
		protected boolean tryRelease(int arg) {
			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}
	}
	
	//声明同步器
	private static Sync sync = new Sync();
	
	//加锁
	public void lock() {
		sync.acquire(1);
	}
	
	//解锁
	public void unlock() {
		sync.release(1);
	}
	
	//测试
	static int count = 0;
	
	public static void main(String[] args) throws InterruptedException {
		MyLockBaseOnAqs lock = new MyLockBaseOnAqs();
		
		int num = 1000;
		CountDownLatch latch = new CountDownLatch(num);
		
		for (int i = 0; i < num; i++) {
			new Thread(new Runnable(){

				@Override
				public void run() {
					lock.lock();
					
					for (int j = 0; j < 1000; j++) {
						count++;
					}
					
					lock.unlock();
					latch.countDown();
					
				}
			}).start();
		}
		
		latch.await();
		System.out.println(count);
	}
}
