
public class StringDemo2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name="abc";
		method(name);
		System.out.println("name: "+name);
		method2(name);
		System.out.println("name: "+name);
	}
	private static void method(String sName){
		sName="123";
	}
	private static void method2(String sName)
	{
		sName=new java.util.Random().nextInt()+"";
	}
}
