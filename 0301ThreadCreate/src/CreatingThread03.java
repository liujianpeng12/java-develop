/**
 * @author liujp
 * @create 2020-09-21 10:18
 */
public class CreatingThread03 {

    public static void main(String[] args){
        //Thread匿名类,重写Thread的run()方法
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running!");
            }
        }.start();

        //Runnable匿名类,实现其run()方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " is running!");
            }
        }).start();

        //同上,使用lambda表达式函数式编程(java8+)
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + " is running!");
        }).start();
    }
}
