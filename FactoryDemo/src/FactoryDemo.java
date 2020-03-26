

//简单工厂模式
public class FactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IEat e=Factory.getInstance("dog");
		e.eat();
		e=Factory.getInstance("cat");
		e.eat();
	}

}
class Factory{
	public static IEat getInstance(String name){
		if(name.equals("cat")){
			return new Cat();
		}else if(name.equals("dog")){
			return new Dog();
		}
		return null;
	}
}
interface IEat{
	void eat();
}
class Cat implements IEat{
	public void eat(){
		System.out.println("Cat eat.");
	}
}
class Dog implements IEat{
	public void eat(){
		System.out.println("Dog eat.");
	}
}
