
public class InterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
interface A{
	
}
interface B{
	
}
interface IEat{
	String name="my name";//name Îª³£Á¿
	public static final String ADDR="addr";
	public abstract void eat();
}
interface Hit extends A,B{
	void cry();
}
class Goddess implements Hit,IEat{
	public void cry(){
		System.out.print("123");
	}
	public void eat(){
		System.out.println("eat");
	}
}
abstract class Person implements IEat{
	public abstract void eat();
	
	void say(){
		//name="ww";
	}
}

