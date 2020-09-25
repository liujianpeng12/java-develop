import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 线程池--未来任务执行流程
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247484051&idx=1&sn=1daf7ff100d5e5215646b5e081dc87c4&scene=21#wechat_redirect
 *
 * （1）未来任务是通过把普通任务包装成FutureTask来实现的
 * （2）通过FutureTask不仅能够获取任务执行的结果，还有感知到任务执行的异常，甚至还可以取消任务；
 * （3）AbstractExecutorService中定义了很多模板方法，这是一种很重要的设计模式；
 * （4）FutureTask其实就是典型的异步调用的实现方式，后面我们学习到Netty、Dubbo的时候还会见到这种设计思想的。
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int num =  100;
        List<Future<Integer>> list = new ArrayList<>(num);

        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < num; i++) {
            int finalI = i;
            Future<Integer> future = threadPool.submit(()->{
                return finalI;
            });
            list.add(future);
        }

        //求结果
        int sum = 0;
        for (Future<Integer> future : list) {
            sum +=future.get();
        }
        System.out.println(sum);
    }
}
