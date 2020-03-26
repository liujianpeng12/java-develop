import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * 实现多个线程开始执行任务的最大并行性。注意是并行性，不是并发，强调的是多个线程在某一时刻同时开始执行。
 * 类似于赛跑，将多个线程放到起点，等待发令枪响，然后同时开跑。
 * 做法是初始化一个共享的 CountDownLatch 对象，将其计数器初始化为 1 ：new CountDownLatch(1) ，
 * 多个线程在开始执行任务前首先 coundownlatch.await()，当主线程调用 countDown() 时，计数器变为0，多个线程同时被唤醒。
 * 
 * @author Administrator
 *
 */
public class CountDownLatch2 {

	static int num = 30;
	static CountDownLatch latch = new CountDownLatch(1);

	public static void main(String[] args) {
		for (int i = 1; i <= num; i++) {
			new Thread(new Runnable() {
				public void run() {
					try {
						latch.await();

						System.out.println(Thread.currentThread().getName() + "号选手开始起跑.");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}

		System.out.println("所有选手准备就绪, 开始起跑!!!");
		latch.countDown();
	}
}
