

//OO设计原则
//面向接口编程(面向抽象编程)
//封装变化
//多用组合,少用继承

//策略模式
public class InterfaceAppDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person("me");
		Isay isay=new Say1();
		p.setIsay(isay);
		p.say();
		
		isay=new Say2();
		p.setIsay(isay);
		p.say();
	}

}
interface Isay{
	void say();
}

class Person{
	private String name;
	//把可变 行为抽象出来,定义成接口,并提供不同实现
	private Isay isay;
	public void setIsay(Isay isay){
		this.isay=isay;
	}
	
	public Person(String name){
		this.name=name;
	}
	
	void say(){
		isay.say();
	}
}

class Say1 implements Isay{
	public void say(){
		System.out.println("say 1.");
	}
}
class Say2 implements Isay{
	public void say(){
		System.out.println("say 2.");
	}
}
