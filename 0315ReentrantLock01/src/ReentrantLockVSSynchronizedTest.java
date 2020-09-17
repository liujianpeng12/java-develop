import java.text.Normalizer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 功能更丰富, 如扶持公平锁、超时锁、支持多个条件锁，Synchronized只支持一个条件
 *
 * Synchronized 是java原来提供的在多线程环境下保证同步的关键字,底层通过修改对象头变量来实现
 * ReentrantLock 是java语言层面提供的在多线程环境保证同步的类,底层通过原子更新状态变量state来实现
 *
 * Synchronized 在不断优化, 测试发现在大并发环境下性能比 ReentrantLock 要高
 *
 */
public class ReentrantLockVSSynchronizedTest {
    static AtomicInteger atomicInteger = new AtomicInteger();
    static LongAdder longAdder = new LongAdder();
    static ReentrantLock fairLock = new ReentrantLock(true);
    static ReentrantLock unfairLock = new ReentrantLock(true);
    static int a = 0;
    static int b = 0;
    static int c = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("-------------------------------");
        testAll(1, 100000);
        System.out.println("-------------------------------");
        testAll(2, 100000);
        System.out.println("-------------------------------");
        testAll(4, 100000);
        System.out.println("-------------------------------");
        testAll(6, 100000);
        System.out.println("-------------------------------");
        testAll(8, 100000);
        System.out.println("-------------------------------");
        testAll(10, 100000);
        System.out.println("-------------------------------");
        testAll(50, 100000);
        System.out.println("-------------------------------");
        testAll(100, 100000);
        System.out.println("-------------------------------");
        testAll(200, 100000);
        System.out.println("-------------------------------");
        testAll(500, 100000);
        System.out.println("-------------------------------");
        testAll(500, 10000);
        System.out.println("-------------------------------");
        testAll(500, 1000);
        System.out.println("-------------------------------");
        testAll(500, 100);
        System.out.println("-------------------------------");
        testAll(500, 10);
        System.out.println("-------------------------------");
        testAll(500, 1);
    }

    private static void testAll(int threadCount, int loopCount) throws InterruptedException {
        testAtomicInteger(threadCount, loopCount);
        textLongAdder(threadCount, loopCount);
        testReentrantLockFair(threadCount, loopCount);
        testReentrantLockUnfair(threadCount, loopCount);
        testSynchronized(threadCount, loopCount);
    }

    private static void testAtomicInteger(int threadCount, int loopCount) throws InterruptedException {
        long start = System.currentTimeMillis();

        CountDownLatch countdownlatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                for (int j = 0; j < loopCount; j++) {
                    atomicInteger.incrementAndGet();
                }
                countdownlatch.countDown();
            }).start();
        }

        countdownlatch.await();
        System.out.println("AtomicInteger: result=" + atomicInteger.get() + ",threadCount=" + threadCount + ",loopCount=" + loopCount + ",耗时=" + (System.currentTimeMillis() - start));
    }

    private static void textLongAdder(int threadCount, int loopCount) throws InterruptedException {
        long start = System.currentTimeMillis();

        CountDownLatch countdownlatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                for (int j = 0; j < loopCount; j++) {
                    longAdder.increment();
            }
                countdownlatch.countDown();
            }).start();
        }

        countdownlatch.await();
        System.out.println("LongAdder: result=" + longAdder.sum() + ",threadCount=" + threadCount + ",loopCount=" + loopCount + ",耗时=" + (System.currentTimeMillis() - start));
    }

    private static void testReentrantLockFair(int threadCount, int loopCount) throws InterruptedException {
        long start = System.currentTimeMillis();

        CountDownLatch countdownlatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                for (int j = 0; j < loopCount; j++) {
                    unfairLock.lock();
                    a++;
                    unfairLock.unlock();
                }
                countdownlatch.countDown();
            }).start();
        }

        countdownlatch.await();
        System.out.println("ReentrantLockFair: result=" + a + ",threadCount=" + threadCount + ",loopCount=" + loopCount + ",耗时=" + (System.currentTimeMillis() - start));
    }

    private static void testReentrantLockUnfair(int threadCount, int loopCount) throws InterruptedException {
        long start = System.currentTimeMillis();

        CountDownLatch countdownlatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{
                for (int j = 0; j < loopCount; j++) {
                    unfairLock.lock();
                    b++;
                    unfairLock.unlock();
                }
                countdownlatch.countDown();
            }).start();
        }

        countdownlatch.await();
        System.out.println("ReentrantLockUnfair: result=" + b + ",threadCount=" + threadCount + ",loopCount=" + loopCount + ",耗时=" + (System.currentTimeMillis() - start));
    }

    private static void testSynchronized(int threadCount, int loopCount) throws InterruptedException {
        long start  = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++){
            new Thread(()->{
                for (int j = 0; j < loopCount; j++) {
                    synchronized (ReentrantLockVSSynchronizedTest.class) {
                        c++;
                    }
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("synchronized: result=" + c + ",threadCount=" + threadCount + ",loopCount=" + loopCount + ",耗时=" + (System.currentTimeMillis() - start));
    }
}
