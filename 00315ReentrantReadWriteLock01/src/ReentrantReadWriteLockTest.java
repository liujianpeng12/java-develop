import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁: 读写锁是一种特殊的锁，它把对共享资源的访问分为读访问和写访问，多个线程可以同时对共享资源进行读访问，但是同一时间只能有一个线程对共享资源进行写访问，使用读写锁可以极大地提高并发量。
 * 读写锁除了读读不互斥，读写、写读、写写都是互斥的
 *
 * （1）ReentrantReadWriteLock采用读写锁的思想，能提高并发的吞吐量；
 * （2）读锁使用的是共享锁，多个读锁可以一起获取锁，互相不会影响，即读读不互斥；
 * （3）读写、写读和写写是会互斥的，前者占有着锁，后者需要进入AQS队列中排队；
 * （4）多个连续的读线程是一个接着一个被唤醒的，而不是一次性唤醒所有读线程；
 * （5）只有多个读锁都完全释放了才会唤醒下一个写线程；
 * （6）只有写锁完全释放了才会唤醒下一个等待者，这个等待者有可能是读线程，也可能是写线程；
 */
public class ReentrantReadWriteLockTest {
}

/**
 * 安全的TreeMap
 */
class SafeTreeMap {
    Map<String, String> treeMap = new TreeMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public String get(String key) {
        readLock.lock();
        try {
            return treeMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public String put(String key, String v) {
        writeLock.lock();
        try {
            return treeMap.put(key, v);
        } finally {
            writeLock.unlock();
        }
    }
}
