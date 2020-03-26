
/**
 * µ¥ÀýÄ£Ê½
 * @author Administrator
 *
 */
public class TestSingleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySingleton.getInstance().myPrint();
		MySingleton.getInstance().myPrint();
	}

}

class MySingleton{
	
	private static MySingleton instance=null;
	
	private MySingleton(){		
		System.out.println("MySingleton ...");
	}
	
	public static MySingleton getInstance(){
		if(instance==null){
			instance=new MySingleton();
		}
		return instance;
	}
	
	public void myPrint(){
		System.out.println("MySingleton print");
	}
}
