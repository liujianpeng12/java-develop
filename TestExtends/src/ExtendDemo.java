
public class ExtendDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomeChicken hc=new HomeChicken();
		hc.say();
	}
	
}

class Chicken{
	protected String name="123";
	public Chicken(String name){
		System.out.println("chicken");
	}
	protected void say(){
		System.out.println("hi");
	}
	protected void count(){
		System.out.println("count");
	}
}

class HomeChicken extends Chicken{
	public HomeChicken(){
		super("");
		System.out.println("HomeChicken");
	}
	public void say(){
		System.out.println("hello");
		System.out.println(super.name);
		super.count();		
	}
}