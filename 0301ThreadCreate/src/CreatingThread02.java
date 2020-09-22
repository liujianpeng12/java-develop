
/**
 * 实现Runnable接口并实现run方法, 这种方式的好处是一个类可以实现多个接口, 不影响其继承体系
 */
public class CreatingThread02 implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running!");
    }

    public static void main(String[] args){
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
        new Thread(new CreatingThread02()).start();
    }
}
