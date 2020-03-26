
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * volatile不能保证原子操作
 * 
 * 一些同学可能会觉得疑惑，如果用volatile修饰的共享变量可以保证可见性，那么结果不应该是300000么?

        问题就出在num++这个操作上，因为num++不是个原子性的操作，而是个复合操作。我们可以简单讲这个操作理解为由这三步组成:

　　1.读取

　　2.加一

　　3.赋值

　　所以，在多线程环境下，有可能线程A将num读取到本地内存中，此时其他线程可能已经将num增大了很多，
       线程A依然对过期的num进行自加，重新写到主存中，最终导致了num的结果不合预期，而是小于30000。
 */
public class Counter {
    public static volatile int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(){
                public void run(){
                	
                    for(int j=0;j<10000;j++){
                        num++;//自加操作
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num);
    }
}