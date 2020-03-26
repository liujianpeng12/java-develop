package VolatileDemo;

/**
 * https://www.cnblogs.com/tong-yuan/p/volatile.html
 * 
 * volatile特性一: 可见性--当一个线程修改了共享变量的值，其它线程能立即感知到这种变化
 * 
 * 下面代码中,针对finished变量，使用volatile修饰时这个程序可以正常结束，不使用volatile修饰时这个程序永远不会结束
 * 
 * 因为不使用volatile修饰时，checkFinished()所在的线程每次都是读取的它自己工作内存中的变量的值，这个值一直为0，所以一直都不会跳出while循环。
 * 使用volatile修饰时，checkFinished()所在的线程每次都是从主内存中加载最新的值，当finished被主线程修改为1的时候，它会立即感知到，进而会跳出while循环。
 * 
 * @author Administrator
 *
 */
public class VolatileDemo1 {

	//private static boolean finished = false;
	private static volatile boolean finished = false;
	
	private static void checkFinish(){
		while(!finished){
			//do smoething
		}
		System.out.println("子线程结束");
	}
	
	private static void finish(){
		finished = true;
	}
	
	public static void main(String[] args) throws InterruptedException {
		//起一个线程检测是否结束
		new Thread(() -> checkFinish()).start();
		
		Thread.sleep(1000);//不睡眠的话不使用volatile也可以结束子线程
		
		//设置结束标志
		new Thread(() -> finish()).start();
		
		System.out.println("主线程结束");
	}
}
