
/**
 * 多线程中进行资源共享,就需要同步,但是同步多过,就可能造成死锁
 * 
 * 模拟线程死锁(该示例有成功的概率,多运行几次成功性较大)
 * @author Administrator
 *
 */
public class DeadThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DeadThread();
	}

}

class Kidnapper{
	public synchronized void say(Police p){
		System.out.println("绑匪说:先给钱再放人.");
		p.doService();
	}
	public synchronized void doService(){
		System.out.println("同意了,先放人再给钱");
	}
}
class Police{
	public synchronized void say(Kidnapper k){
		System.out.println("警察说:先放人再给钱.");
		k.doService();
	}
	public synchronized void doService(){
		System.out.println("同意了,先给钱再放人.");
	}
}

class DeadThread implements Runnable{
	Kidnapper k=new Kidnapper();
	Police p=new Police();
	public DeadThread(){
		new Thread(this).start();
		p.say(k);
	}
	public void run(){
		k.say(p);
	}
}
