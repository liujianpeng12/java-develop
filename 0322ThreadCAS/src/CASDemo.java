import java.util.concurrent.atomic.AtomicBoolean;

public class CASDemo implements Runnable {

	AtomicBoolean flag  = new AtomicBoolean(true);

	public static void main(String[] args){
		CASDemo demo = new CASDemo();
		new Thread(demo).start();
		new Thread(demo).start();
	}

	@Override
	public void run() {
		System.out.println("thread:"+Thread.currentThread().getName()+";flag:"+flag.get());
		if(flag.compareAndSet(true, false)){
			System.out.println(Thread.currentThread().getName()+""+flag.get());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag.set(true);
		}else{
			System.out.println("重试机制thread:"+Thread.currentThread().getName()+";flag:"+flag.get());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			run();
		}

	}


}
