import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程生命周期
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247484033&idx=1&sn=120be33ad39d8e52389e0d40ce498aac&scene=21#wechat_redirect
 */
public class ThreadLifeTest {

    static Object obj = new Object();
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args){
        new Thread(()->{
            synchronized (obj) {
                try {
                    System.out.println("thread1 waiting");
                    obj.wait();//释放锁了?
                    //obj.wait(5000);
                    System.out.println("thread1 after waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1").start();
        new Thread(()->{
            synchronized (obj) {
                try {
                    System.out.println("thread2 notify");
                    // 打开或关闭这段注释，观察Thread1的状态
                    obj.notify();
                    // notify之后当前线程并不会释放锁，只是被notify的线程从等待队列进入同步队列
                    // sleep也不会释放锁
                    Thread.sleep(10000);
                    System.out.println("thread2 after sleep");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println("thread3 waiting");
                //condition.await();//释放锁了?
                condition.await(200, TimeUnit.SECONDS);
                System.out.println("thread3 after waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                }
        }, "Thread3").start();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println("thread4 notify");
                // 打开或关闭这段注释，观察Thread3的状态
                condition.signal();
                // notify之后当前线程并不会释放锁，只是被signal的线程从等待队列进入同步队列
                // sleep也不会释放锁
                Thread.sleep(10000);
                System.out.println("thread4 after sleep");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                }
        }, "Thread4").start();
    }
}
