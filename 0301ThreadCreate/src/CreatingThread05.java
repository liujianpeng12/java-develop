import java.util.Timer;
import java.util.TimerTask;

/**
 * 使用定时器java.util.Timer可以快速地实现定时任务，TimerTask实际上实现了Runnable接口。
 */
public class CreatingThread05 {
    public static void main(String[] args){
        Timer timer = new Timer();
        //每隔1秒执行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running!");
            }
        }, 0, 1000);
    }
}
