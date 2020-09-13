/**
 * 伪共享
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247483887&idx=1&sn=eac830409917a8c31840c687b4a4154b&scene=21#wechat_redirect
 *
 * 当多线程修改互相独立的变量时，如果这些变量共享同一个缓存行，就会无意中影响彼此的性能，这就是伪共享。
 *
 * 使用 @sun.misc.Contended 注解（java8）来避免伪共享问题, 需要在JVM启动参数加上 -XX:-RestrictContended才会生效
 * 运行这段程序输出的时间为 900ms
 *
 * （1）CPU具有多级缓存，越接近CPU的缓存越小也越快；
 * （2）CPU缓存中的数据是以缓存行为单位处理的；
 * （3）CPU缓存行能带来免费加载数据的好处，所以处理数组性能非常高；
 * （4）CPU缓存行也带来了弊端，多线程处理不相干的变量时会相互影响，也就是伪共享；
 * （5）避免伪共享的主要思路就是让不相干的变量不要出现在同一个缓存行中；
 * （6）一是每两个变量之间加七个 long 类型；
 * （7）二是创建自己的 long 类型，而不是用原生的；
 * （8）三是使用 java8 提供的注解；
 */
public class FalseSharingTest2 {

    public static void main(String[] args) throws InterruptedException {
        testPointer();
    }

    private static void testPointer() throws InterruptedException {
        long start = System.currentTimeMillis();

        Pointer2 pointer = new Pointer2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.x.value ++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.y.value ++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(System.currentTimeMillis() - start);
        System.out.println(pointer);
    }
}

class Pointer2 {
    MyLong x = new MyLong();
    MyLong y = new MyLong();
}

@sun.misc.Contended
class MyLong {
    volatile int value;
}
