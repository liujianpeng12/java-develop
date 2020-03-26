
public class AbstractDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XiaoBird xb=new XiaoBird();
		xb.say();
	}

}

abstract class Bird{
	protected String name;
	
	public Bird(){
		System.out.println("bird");
	}
	
	protected void setName(String name){
		this.name=name;
	}
	protected abstract void say();
}
class XiaoBird extends Bird{
	protected void say(){
		System.out.println("Ð¡Äñ");
	}
}