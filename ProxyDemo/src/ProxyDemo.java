
//静态代理模式
public class ProxyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person("ll");
		MatchMaker m=new MatchMaker(p);
		m.miai();
	}

}
//主题
interface Subject{
	void miai();
}
//被代理对象
class Person implements Subject{
	private String name;
	public Person(String name){
		this.name=name;
	}
	public void miai(){
		System.out.println(name+" 进行中...");
	}
}
//代理对象
class MatchMaker implements Subject{
	private Subject target;
	public MatchMaker(Subject p){
		target=p;
	}
	private void before(){
		System.out.println("代理之前进行处理...");
	}
	private void after(){
		System.out.println("代理之后进行处理...");
	}
	
	public void miai(){
		before();
		target.miai();
		after();
	}
}

