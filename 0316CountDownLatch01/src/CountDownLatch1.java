import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * 某一线程在开始运行前等待n个线程执行完毕。将 CountDownLatch 的计数器初始化为n ：new CountDownLatch(n)
 * ，每当一个任务线程执行完毕，就将计数器减1 countdownlatch.countDown()，当计数器的值变为0时，在CountDownLatch上
 * await() 的线程就会被唤醒。一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。
 * 
 * @author Administrator
 *
 */
public class CountDownLatch1 {

	static int num = 30;
	static CountDownLatch latch = new CountDownLatch(num);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 1; i <= num; i++) {
			new Thread(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "号选手到达终点.");
					latch.countDown();
				}
			}).start();
		}

		latch.await();
		System.out.println("所有选手都到达终点, 比赛结束!!!");
	}
}
