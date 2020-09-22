import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callabe接口，会一直等待业务执行完成后,可以获取线程执行的结果，FutureTask实际上实现了Runnable接口。
 */
public class CreatingThread04 implements Callable<Long> {
    long num = 1;

    @Override
    public Long call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is running!");
        Thread.sleep(20000);
        return num;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Long> task = new FutureTask<Long>(new CreatingThread04());
        new Thread(task).start();
        System.out.println("等待完成任务");
        long result = task.get();
        System.out.println("任务结果:" + result);
    }
}
