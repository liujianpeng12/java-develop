import java.util.Observable;
import java.util.Observer;

public class ObserverDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog=new Dog();
		Person p1=new Person("小明");
		Person p2=new Person("小红");
		
		dog.addObserver(p1);
		dog.addObserver(p2);
		
		System.out.println("小狗优惠价:"+888);
		dog.setPrice(888);
		
		System.out.println("小狗优惠价:"+688);
		dog.setPrice(688);
		
		System.out.println("小狗优惠价:"+588);
		dog.deleteObserver(p2);
		dog.setPrice(588);
	}

}

class Dog extends Observable {
	float price = 1000;

	public float getPricce() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
		this.setChanged();
		this.notifyObservers(price);
	}
}

class Person implements Observer {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println(name + " 关注的小狗价格优惠为:" + arg);

	}

}