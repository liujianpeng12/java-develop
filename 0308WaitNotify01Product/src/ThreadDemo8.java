/**
 * 线程案例：生产者与消费者
 * wait与sleep的区别：
 * sleep:让当前线程进入休眠状态，让出当前CPU的执行时间，但是不释放在该对象上的对象锁
 * wait:让当前线程进入线程等待池，让出当前CPU的执行时间，并释放在该对象上的对象锁
 * 			需要其它线程调用notify、notifyAll方法或等待时间超时，该线程重新进入就绪状态
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Food food=new Food();
		new Thread(new Producter(food)).start();
		new Thread(new Consumer(food)).start();
	}

}

/**
 * 生产者:厨师
 * 
 * @author Administrator
 * 
 */
class Producter implements Runnable {

	Food food = null;

	public Producter(Food food) {
		this.food = food;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				this.food.set("鸡蛋炒西红柿", "鲜得有一套.");
			} else {
				this.food.set("辣椒炒肉", "美味多汁.");
			}
		}
	}

}

/**
 * 消费者:服务员
 * 
 * @author Administrator
 * 
 */
class Consumer implements Runnable {

	Food food = null;

	public Consumer(Food food) {
		this.food = food;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			food.get();
		}
	}
}

class Food {
	private String name;
	private String content;
	
	private boolean flag=true;//true表示可以生产,false表示可以消费

	/**
	 * 生产
	 * 
	 * @param name
	 * @param content
	 */
	public synchronized void set(String name, String content) {
		if(!flag){
			try {
				this.wait();//让当前线程进入等待池等待,没有指定时间,
							//需要其他线程唤醒,释放对象锁,让出CPU时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		setName(name);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setContent(content);
		
		flag=false;//表示生产完成,可以消费
		this.notify();//唤醒在该监视器上的一个线程
	}

	/**
	 * 消费
	 */
	public synchronized void get() {
		if(flag){
			try {
				this.wait();//让当前线程进行等待池等待,没有指定时间,
							//需要其他线程唤醒,释放对象锁,让出CPU时间
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(this.getName() + ":" + this.getContent());
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		flag=true;//消费完毕,可以再生产
		this.notify();//唤醒在该监视器上的一个线程
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
