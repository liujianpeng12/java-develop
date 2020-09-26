import java.util.concurrent.*;

/**
 * 线程池--定时任务
 *
 * 实现定时任务有两个问题要解决，分别是指定未来某个时刻执行任务、重复执行。
 * （1）指定某个时刻执行任务，是通过延时队列的特性来解决的；
 * （2）重复执行，是通过在任务执行后再次把任务加入到队列中来解决的。
 *
 * （1）如何保证任务是在未来某个时刻才被执行？
 *     使用延迟队列,如果没有到时间是拿不出来的
 */
public class ThreadPoolTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);

        //执行一个无返回值任务,5秒后执行,只执行一次
        scheduledThreadPoolExecutor.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行一个无返回值任务,5秒后执行,只执行一次");
            }
        }, 5, TimeUnit.SECONDS);

        //执行一个有返回值任务,5秒后执行,只执行一次
        ScheduledFuture<Integer> future = scheduledThreadPoolExecutor.schedule(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("执行一个有返回值任务,5秒后执行,只执行一次");
                return 123;
            }
        },5, TimeUnit.SECONDS);
        System.out.println("返回值:" + future.get());

        //按固定频率执行一个任务,每2秒执行一次,1秒后执行
        scheduledThreadPoolExecutor.scheduleAtFixedRate(()->{
            System.out.println("autumn: " + System.currentTimeMillis());
        }, 1,2, TimeUnit.SECONDS);

        //按因为延时执行一个任务,每延时2秒执行一次,1秒后执行
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
            System.out.println("winter: " + System.currentTimeMillis());
        }, 1, 2, TimeUnit.SECONDS);

    }
}
