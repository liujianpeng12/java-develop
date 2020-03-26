
public class InstanceofDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person m=new Man();
		say(m);
		Person w=new Women();
		say(w);
	}
	/*
	static void say(Man m){
		m.say();
	}
	static void say(Women w){
		w.say();
	}*/
	static void say(Person p){
		p.say();
		if(p instanceof Man){
			Man m=(Man)p;
			m.desc();
		}
	}
}

abstract class Person{
	abstract void say();
}
class Man extends Person{
	void say(){
		System.out.println("man");
	}
	protected void desc(){
		System.out.println("desc");
	}
}
class Women extends Person{
	void say(){
		System.out.println("wemon");
	}
}
