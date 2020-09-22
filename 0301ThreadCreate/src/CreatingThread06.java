import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujp
 * @create 2020-09-21 10:54
 */
public class CreatingThread06 {

    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            threadPool.execute(()-> System.out.println(Thread.currentThread().getName() + " is running!"));
        }
    }
}
