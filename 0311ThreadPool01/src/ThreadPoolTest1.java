import java.util.concurrent.*;

/**
 * 线程池--普通任务执行流程
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247484047&idx=1&sn=146ea61360cf60e0c948dc541ba55043&scene=21#wechat_redirect
 */
public class ThreadPoolTest1 {

    public static void main(String[] args){
        ExecutorService threadPool = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(5), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("丢弃任务!!!");
            }
        });

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + ", " + finalI + " running");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
