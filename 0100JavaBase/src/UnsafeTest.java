import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * 使用Unsafe几乎可以操作一切：
 * （1）实例化一个类；
 * （2）修改私有字段的值；
 * （3）抛出checked异常；
 * （4）使用堆外内存；
 * （5）CAS操作；
 * （6）阻塞/唤醒线程；
 */
public class UnsafeTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InterruptedException {

        //获取Unsafe的实例
        //(1)
        //Unsafe unsafe = Unsafe.getUnsafe();//抛出异常

        //(2)
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe1 = (Unsafe) field.get(null);


        //使用Unsafe实例化一个类
        User1 user1 = new User1();
        System.out.println(user1.age);//10

        User1 user2 = (User1) unsafe1.allocateInstance(User1.class);
        System.out.println(user2.age);//0 因为 Unsafe.allocateInstance()只会给对象分配内存，并不会调用构造方法，所以这里只会返回int类型的默认值0。


        //修改私有字段的值. 使用Unsafe的putXXX()方法，我们可以修改任意私有字段的值。
        User1 user3 = new User1();
        Field age = user3.getClass().getDeclaredField("age");
        unsafe1.putInt(user3, unsafe1.objectFieldOffset(age), 20);
        System.out.println(user3.age);//20


        //抛出checked异常


        //使用堆外内存


        //CompareAndSwap操作
        //JUC下面大量使用了CAS操作，它们的底层是调用的Unsafe的CompareAndSwapXXX()方法。这种方式广泛运用于无锁算法，与java中标准的悲观锁机制相比，它可以利用CAS处理器指令提供极大的加速。
        CounterTest();


        //park/unpark
        //JVM在上下文切换的时候使用了Unsafe中的两个非常牛逼的方法park()和unpark()。
        //当一个线程正在等待某个操作时，JVM调用Unsafe的park()方法来阻塞此线程。
        //当阻塞中的线程需要再次运行时，JVM调用Unsafe的unpark()方法来唤醒此线程。

    }

    private static void CounterTest() throws InterruptedException {
        Counter counter = new Counter();
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        // 起100个线程，每个线程自增10000次
        IntStream.range(0, 100).forEach(i-> threadPool.submit(()->IntStream.range(0,10000).forEach(j->counter.increment())));
        threadPool.shutdown();

        Thread.sleep(2000);

        System.out.println(counter.getCount());//1000000
    }
}

class User1 {
    int age;

    public User1() {
        this.age = 10;
    }
}

class Counter {
    private volatile int count = 0;

    private static Unsafe unsafe;
    private static long offset;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            offset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("count"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void increment() {
        int before = count;
        // 失败了就重试直到成功为止
        //通过调用Unsafe的compareAndSwapInt()方法来尝试更新之前获取到的count的值，如果它没有被其它线程更新过，则更新成功，否则不断重试直到成功为止。
        while(!unsafe.compareAndSwapInt(this, offset,before,before + 1)) {
            before = count;
        }
    }

    public int getCount() {
        return count;
    }
}
