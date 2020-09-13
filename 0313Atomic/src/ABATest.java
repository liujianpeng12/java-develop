import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * ABA问题发生在多线程环境中，当某线程连续读取同一块内存地址两次，两次得到的值一样，它简单地认为“此内存地址的值并没有被修改过”，
 * 然而，同时可能存在另一个线程在这两次读取之间把这个内存地址的值从A修改成了B又修改回了A，这时还简单地认为“没有修改过”显然是错误的。
 */
public class ABATest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        new Thread(()->{
            int value = atomicInteger.get();
            System.out.println("线程 1 的value为:" + value);

            //阻塞1s
            LockSupport.parkNanos(1000000000L);

            value = atomicInteger.get();
            if(atomicInteger.compareAndSet(value, 3)) {
                System.out.println("线程 1 更新value从" + value + " 为 3");
            } else {
                System.out.println("线程 1 更新失败");
            }
        }).start();

        new Thread(()->{
            int value = atomicInteger.get();
            System.out.println("线程 2 的value为:" + value);
            if(atomicInteger.compareAndSet(value, 2)){
                System.out.println("线程 2 更新value从" + value + " 为 2");

                //do th

                value = atomicInteger.get();
                System.out.println("线程 2 的value为:" + value);
                if(atomicInteger.compareAndSet(value, 1)) {
                    System.out.println("线程 2 更新value从" + value + " 为 1");
                }
            }
        }).start();
    }
}
