
/**
 * 同时继承Thread并实现了Runnable接口
 */
public class CreatingThread09 {

    public static void main(String[] args){
        new Thread(()-> {
            System.out.println("Runnable:" + Thread.currentThread().getName());
        }){
            @Override
            public void run() {
                System.out.println("Thread:" + Thread.currentThread().getName());
            }
        }.start();
    }
}
