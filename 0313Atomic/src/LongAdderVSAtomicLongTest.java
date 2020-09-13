import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * LongAdder
 * LongAdder的原理是，在最初无竞争时，只更新base的值，当有多线程竞争时通过分段的思想，让不同的线程更新不同的段，
 * 最后把这些段相加就得到了完整的LongAdder存储的值。
 *
 * （1）LongAdder通过base和cells数组来存储值；
 * （2）不同的线程会hash到不同的cell上去更新，减少了竞争；
 * （3）LongAdder的性能非常高，最终会达到一种无竞争的状态；
 */
public class LongAdderVSAtomicLongTest {

    public static void main(String[] args) throws InterruptedException {
        testAtomicLongVSLongAdder(1, 1000000);
        testAtomicLongVSLongAdder(10, 1000000);
        testAtomicLongVSLongAdder(20, 1000000);
        testAtomicLongVSLongAdder(40, 1000000);
        testAtomicLongVSLongAdder(80, 1000000);
    }

    private static void testAtomicLongVSLongAdder(int threadCount, int times) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("线程数:" + threadCount + " ,次数:" + times);
        testLongAdder(threadCount, times);
        System.out.println("LongAdder 耗时: " + (System.currentTimeMillis() - start) + "ms");

        long start2 = System.currentTimeMillis();
        testAtomicLong(threadCount, times);
        System.out.println("AtomicLong 耗时: " + (System.currentTimeMillis() - start2) + "ms");
    }

    private static void testAtomicLong(int threadCount, int times) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        AtomicLong atomicLong = new AtomicLong();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    atomicLong.incrementAndGet();
                }
            }));
        }

        for (Thread t : list) {
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }
    }

    private static void testLongAdder(int threadCount, int times) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        LongAdder longAdder = new LongAdder();
        for (int i = 0; i < threadCount; i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    longAdder.add(1);
                }
            }));
        }

        for (Thread t : list) {
            t.start();
        }

        for (Thread t : list) {
            t.join();
        }
    }
}
