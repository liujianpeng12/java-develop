import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 信号量
 * Semaphore，信号量，它保存了一系列的许可（permits），每次调用acquire()都将消耗一个许可，每次调用release()都将归还一个许可。
 * 特性: Semaphore通常用于限制同一时间对共享资源的访问次数上，也就是常说的限流。
 *
 * （1）Semaphore，也叫信号量，通常用于控制同一时刻对共享资源的访问上，也就是限流场景；
 * （2）Semaphore的内部实现是基于AQS的共享锁来实现的；
 * （3）Semaphore初始化的时候需要指定许可的次数，许可的次数是存储在state中；
 * （4）获取一个许可时，则state值减1；
 * （5）释放一个许可时，则state值加1；
 * （6）可以动态减少n个许可；
 * （7）可以动态增加n个许可吗？
 *
 */
public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(100);//秒杀商品数量
    static AtomicInteger successCount = new AtomicInteger(0);
    static AtomicInteger failCount = new AtomicInteger(0);

    public static void main(String[] args){
        for (int i = 0; i < 1000; i++) {
            new Thread(()->seckill()).start();
        }
    }


    private static boolean seckill() {
        if(!semaphore.tryAcquire()) {
            System.out.println("没有许可了, 秒杀失败数=" + failCount.incrementAndGet());
            return false;
        }

        //有许可
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        System.out.println("秒杀成功数=" + successCount.incrementAndGet());
        return true;
    }
}
