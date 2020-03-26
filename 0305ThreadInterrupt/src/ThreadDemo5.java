
/**
 *  中断线程 
 * 1、在线程外部通过调用interrupt方法中断线程，线程本身没有中断，只是作了一个标记
 * 那么此时调用wait,join,sleep方法将导致InterruptedException异常，并清除中断标记，
 * 这时我们想要线程中断，那么需要在线程内部自己中断。
 * 2、通常情况下，我们在中断线程时，都采用自定义标记的方式处理，
 * 而不使用interrupt方法
 * 
 * @author Administrator
 * 
 */
public class ThreadDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//中断方式:interrupt()
		Thread t2 = new Thread(new MyThread2());
		t2.start();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			if (i == 5) {
				//t1.interrupt();//中断线程(设置中断状态为true)
				t2.interrupt();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//自定义方式中断线程
//		MyThread my=new MyThread();
//		Thread t=new Thread(my);
//		t.start();	
//		for(int i=0;i<10;i++){
//			System.out.println(Thread.currentThread().getName() + "-" + i);
//			if(i==5){
//				my.setFlag(false);
//			}
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}

}

class MyThread2 implements Runnable{

	@Override
	public void run() {
		int i=0;
		while(!Thread.interrupted()){
			System.out.println("MyThread2-" + i);
			i++;
			try {
				Thread.sleep(1000);//中断线程后又调用sleep()方法,则中断状态将被清除,线程继续执行,并抛出 InterruptedException
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();//再次中断该线程,则该线程不再执行
			}
		}
	}
	
}

class MyThread implements Runnable {
	private Boolean flag=true;
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public void run() {
		int i = 0;
		while (flag) {
			System.out.println(Thread.currentThread().getName() + "-" + i);
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
