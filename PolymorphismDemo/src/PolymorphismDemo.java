
public class PolymorphismDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person man=new Man();
		man.say();
		//man.desc();		
		Person women=new Women();
		women.say();
		
		Man m=(Man)man;
		m.say();
		m.desc();
		//Women w=(Women)man;//java.lang.ClassCastException
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