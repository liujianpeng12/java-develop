import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 基本数据类型原子类的优势
 * 
 * AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免
 * synchronized 的高开销，执行效率大为提升。
 * 
 * CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。
 * 
 * @author Administrator
 *
 */
public class AtomicTest2 {

	public static void main(String[] args) {
		print1();
		print2();
	}

	private static void print1() {
		Test1 test1 = new Test1();
		System.out.println("synchronized方式的初始值:" + test1.getCount());
		for (int i = 0; i < 10; i++) {
			new Thread(new Thread1(test1)).start();
		}
		System.out.println("synchronized方式的多线程后的值:" + test1.getCount());
	}

	private static void print2() {
		Test2 test2 = new Test2();
		System.out.println("atomic方式的初始值:" + test2.getCount());
		for (int i = 0; i < 10; i++) {
			new Thread(new Thread2(test2)).start();
		}
		System.out.println("atomic方式的多线程后的值:" + test2.getCount());
	}

}

class Thread1 implements Runnable {
	Test1 test1;

	public Thread1(Test1 test1) {
		this.test1 = test1;
	}

	@Override
	public void run() {
		test1.increment();
	}
}

class Thread2 implements Runnable {
	Test2 test2;

	public Thread2(Test2 test2) {
		this.test2 = test2;
	}

	@Override
	public void run() {
		test2.increment();
	}
}

class Test1 {
	private volatile int count = 0;

	// 若要线程安全执行执行count++，需要加锁
	public synchronized void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}

class Test2 {
	private AtomicInteger count = new AtomicInteger(0);
	AtomicIntegerArray s = new AtomicIntegerArray(new int[]{1,2,3});
	// 使用AtomicInteger之后，不需要加锁，也可以实现线程安全。
	public void increment() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}
}