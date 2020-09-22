
/**
 * 继承Thead类并重写run方法, 这种方式是一个类只能继承一个父类,如果这个类本身已经继承其它了, 就不能使用这种方式了
 */
public class CreatingThread01 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running!");
    }

    public static void main(String[] args){
        new CreatingThread01().start();
        new CreatingThread01().start();
        new CreatingThread01().start();
        new CreatingThread01().start();
        new CreatingThread01().start();
    }
}
