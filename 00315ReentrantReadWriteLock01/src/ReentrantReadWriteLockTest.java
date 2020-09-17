import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁: 读写锁是一种特殊的锁，它把对共享资源的访问分为读访问和写访问，多个线程可以同时对共享资源进行读访问，但是同一时间只能有一个线程对共享资源进行写访问，使用读写锁可以极大地提高并发量。
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
