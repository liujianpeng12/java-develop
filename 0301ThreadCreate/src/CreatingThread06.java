import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池的方式，可以复用线程，节约系统资源。
 */
public class CreatingThread06 {

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(()-> System.out.println(Thread.currentThread().getName() + " is running!"));
        }
    }
}
