/**
 * 伪共享
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247483887&idx=1&sn=eac830409917a8c31840c687b4a4154b&scene=21#wechat_redirect
 *
 * 当多线程修改互相独立的变量时，如果这些变量共享同一个缓存行，就会无意中影响彼此的性能，这就是伪共享。
 *
 * 运行这段程序输出的时间为 2400ms
 */
public class FalseSharingTest {

    public static void main(String[] args) throws InterruptedException {
        testPointer();
    }

    private static void testPointer() throws InterruptedException {
        long start = System.currentTimeMillis();

        Pointer pointer = new Pointer();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.x ++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000000; i++) {
                pointer.y ++;
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

class Pointer {
    volatile int x;
    volatile int y;
}
