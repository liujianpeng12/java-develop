package VolatileDemo;

/**
 * volatile 特性二: 禁止指令重排
 * 
 * 指令重排解释:
 * 如下以下代码
 * int i = 0;
 * int j = 1;
 * 可能会先执行int j = 1;这句，也就是重排序了
 * 
 * @author Administrator
 *
 */
public class VolatileDemo2 {
	private static String text;
	private static volatile boolean flag = false;
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			text = "my do something";
			//如先执行该句就是指令重排了, 这是text还没有赋值, 在其它线程输出text是空
			//（此处这个例子只是用于说明重排序，实际运行时很难出现。）
			flag = true;
			
		}).start();
		
		new Thread(() -> {
			while(!flag){
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println(text);
		}).start();
	}
}

class MyBus{
	private String text;
	private boolean flag = false;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}