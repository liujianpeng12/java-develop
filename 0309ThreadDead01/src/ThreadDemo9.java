
/**
 * 线程死锁: 死锁的定义是线程A占有着线程B需要的资源，线程B占有着线程A需要的资源，两个线程相互等待对方释放资源
 * 调用当前对象的同步方法时,在方法内部又调用了其他对象的同步方法,就会出现死锁
 * @author Administrator
 *
 */

public class ThreadDemo9 {
	public static void main(String[] args){
		new DeadThread();
	}
}

class DeadThread implements Runnable {
	BangFei b=new BangFei();
	GeGe g=new GeGe();
	public DeadThread(){
		new Thread(this).start();
		b.say(g);
	}

	@Override
	public void run() {
		g.say(b);
	}

}



class BangFei{
	public synchronized void say(GeGe g){
		System.out.println("给我500W,放了你妹妹");
		g.fun();
	}
	public synchronized void fun(){
		System.out.println("绑架犯得到了500W");
	}
}
class GeGe{
	public synchronized void say(BangFei b){
		System.out.println("放了我妹妹,给你500W,");
		b.fun();
	}
	public synchronized void fun(){
		System.out.println("哥哥救出妹妹,花了500W,");
	}
}
