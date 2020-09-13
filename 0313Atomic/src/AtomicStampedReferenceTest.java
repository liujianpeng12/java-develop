import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

/**
 * AtomicStampedReference是java并发包下提供的一个原子类，它能解决其它原子类无法解决的ABA问题。
 * AtomicStampedReference将元素值和版本号绑定在一起，存储在Pair的reference和stamp（邮票、戳的意思）中。
 * AtomicStampedReference解决ABA问题的思路:
 * (1)使用版本号控制；
 * (2)不重复使用节点（Pair）的引用，每次都新建一个新的Pair来作为CAS比较的对象，而不是复用旧的；
 * (3)外部传入元素值及版本号，而不是节点（Pair）的引用。
 *
 * （1）在多线程环境下使用无锁结构要注意ABA问题；
 * （2）ABA的解决一般使用版本号来控制，并保证数据结构使用元素值来传递，且每次添加元素都新建节点承载元素值；
 * （3）AtomicStampedReference内部使用Pair来存储元素值及其版本号；
 *
 * 可以看到线程1最后更新1到3时失败了，因为这时版本号也变了，成功解决了ABA的问题。
 */
public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        testStamp();
    }

    private static void testStamp(){
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);

        new Thread(()->{
            int[] stampHolder = new int[1];
            int value = atomicStampedReference.get(stampHolder);
            int stamp = stampHolder[0];
            System.out.println("线程1读取value:" + value + ", stamp:" + stamp);

            //阻塞1s
            LockSupport.parkNanos(1000000000L);

            if(atomicStampedReference.compareAndSet(value, 3, stamp, stamp + 1)) {
                System.out.println("线程1更新value 从" + value + "到 3");
            } else {
                System.out.println("线程1更新value失败");
            }

        }).start();

        new Thread(()->{
            int[] stampHolder = new int[1];
            int value = atomicStampedReference.get(stampHolder);
            int stamp = stampHolder[0];
            System.out.println("线程2读取value:" + value + ", stamp:" + stamp);
            if(atomicStampedReference.compareAndSet(value, 2, stamp, stamp + 1)) {
                System.out.println("线程2更新value 从" + value + "到 2");

                // do sth

                value = atomicStampedReference.get(stampHolder);
                stamp = stampHolder[0];
                System.out.println("线程2读取value:" + value + ", stamp:" + stamp);
                if(atomicStampedReference.compareAndSet(value, 1, stamp, stamp + 1)) {
                    System.out.println("线程2更新value 从" + value + "到 1");
                }
            }

        }).start();
    }
}
