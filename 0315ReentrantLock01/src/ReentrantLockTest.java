import java.util.concurrent.locks.ReentrantLock;

/**
 * 上面的代码通过lock()方法先获取锁三次，然后通过unlock()方法释放锁3次，程序可以正常退出。从上面的例子可以看出,
 * ReentrantLock是可以重入的锁,当一个线程获取锁时,还可以接着重复获取多次。在加上ReentrantLock的的独占性，
 * 我们可以得出以下ReentrantLock和synchronized的相同点
 * 
 * @author Administrator
 *
 */
public class ReentrantLockTest {

	public static void main(String[] args) {
		ReentrantLock rlock = new ReentrantLock();

		for (int i = 0; i <= 3; i++) {
			rlock.lock();
		}

		for (int i = 0; i <= 3; i++) {
			try {

			} finally {
				rlock.unlock();
			}

		}
	}
}
