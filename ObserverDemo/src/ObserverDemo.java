import java.util.ArrayList;

/**
 * 观察者模式 
 * Subject (被观察的对象接口) 
 * 		规定ConcreteSubject的统一接口 
 * 		每个Subject可以有多个Observer
 * ConcreteSubject(具体被观察对象) 
 * 		维护对所有具体观察者的引用列表 
 * 		状态发生变化时发送通知给所有注册的观察者 
 * Observer(观察者接口)
 * 		规定ConcreteObserver的统一接口 
 * 		定义了一个update()方法 
 * ConcreteObserver(具体观察者对象)
 * 		维护一个对ConcreteSubject的引用 
 * 		特定状态与ConcreteSubject同步
 * 		实现Observer接口,通过update()方法接收ConcreteSubject的通知
 * 
 * @author Administrator
 * 
 */
public class ObserverDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dog dog=new Dog();
		Person p1=new Person("小明");
		Person p2=new Person("小红");
		
		dog.registerObserver(p1);
		dog.registerObserver(p2);
		
		System.out.println("小狗优惠价:"+888);
		dog.setPrice(888);
		
		System.out.println("小狗优惠价:"+688);
		dog.setPrice(688);
		
		System.out.println("小狗优惠价:"+588);
		dog.removeObserver(p2);
		dog.setPrice(588);
	}

}

/**
 * 被观察的对象接口
 * 
 * @author Administrator
 * 
 */
interface Subject {
	void registerObserver(Observer o);

	void removeObserver(Observer o);

	void notifyObserver();
}

/**
 * 被观察对象:小狗
 * 
 * @author Administrator
 * 
 */
class Dog implements Subject {
	ArrayList<Observer> list = new ArrayList<Observer>();
	private float price=1000;

	public void setPrice(float price) {
		this.price = price;
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer o) {
		list.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		list.remove(o);
	}

	@Override
	public void notifyObserver() {
		for (Observer o : list) {
			o.update(this.price);
		}
	}
}

/**
 * 观察者对象接口
 * 
 * @author Administrator
 * 
 */
interface Observer {
	void update(float price);
}

class Person implements Observer {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	@Override
	public void update(float price) {
		System.out.println(name + " 关注的小狗价格变动为:" + price);
	}

}
