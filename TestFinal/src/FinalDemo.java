
public class FinalDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A("12@163.com");
		a.desc();
	}

}

final class A{
	final String name="my name";
	final String email;
	public A(String e){
		email=e;
	}
	public final void desc(){
		System.out.println(name);
		//name="new";
	}
}
/*
class B extends A{
	
}
*/
