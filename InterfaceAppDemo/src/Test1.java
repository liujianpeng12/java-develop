
/**
 * 接口:interface
 * 1.接口是完全抽象的,抽象的是功能,方法
 * 2.接口不能被实例化
 * 3.接口中只能声明常量和抽象方法
 * 4.子类实现接口,必须实现接口中所有的方法
 * 5.接口可以继承一个或多个接口,使用extends关键字
 * 6.接口可以包含类或接口
 * @author Administrator
 *
 */

interface MyInterface{
	public static final int NUM=1;
	public static int num=10;
	public int num2=1;
	int num3=21;
	
	public abstract void method1();
	public void method2();
	void method3();
	
	class A{
		
	}
	
	abstract class AbstractClass{
		
	}
	
	interface InterfaceXX{
		
	}
}

interface MyInterface2 extends MyInterface{
	void fun();
}

interface MyInterface3 extends MyInterface,MyInterface2{
	void fun();
}

class MyInterfaceImpl implements MyInterface{

	@Override
	public void method1() {
		System.out.println("method1");
	}

	@Override
	public void method2() {
		System.out.println("method2");
	}

	@Override
	public void method3() {
		System.out.println("method3");		
	}
	
}

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyInterfaceImpl impl=new MyInterfaceImpl();
		impl.method1();
		impl.method2();
		impl.method3();
	}

}
