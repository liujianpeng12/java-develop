import java.util.concurrent.CountDownLatch;

/**
 * 司机和工人，工人必须等到司机来了才能装货上车，司机必须得等到所有工人把货物装上车了之后才能把车开走。
 *
 * @author Administrator
 *
 */
public class CountDownLatch3 {

	static int workerNum = 30;
	static CountDownLatch driverLatch = new CountDownLatch(1);
	static CountDownLatch workerLatch =  new CountDownLatch(workerNum);

	public static void main(String[] args) throws InterruptedException{
		for (int i = 0; i < workerNum; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						driverLatch.await();//工人等司机
						System.out.println(Thread.currentThread().getName() + "工作开始干活...");
						workerLatch.countDown();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}

		System.out.println("司机来了...");
		driverLatch.countDown();

		System.out.println("工人开始干活...");

		workerLatch.await();
		System.out.println("所有工人干完活了...司机把车开走");
	}
}
