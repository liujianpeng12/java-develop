
public class ArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names={"11","cc","ww","22"};
		method(names);
		
		System.out.println("");
		method2("22","44");
		System.out.println("");
		method2("22","44","cc","kk");
	}
	private static void method(String[] names){
		//比一般的for循环耗费更多内存
		for(String name:names){
			System.out.print(name+" ");
		}
	}
	//可变参数
	private static void method2(String...names){
		//比一般的for循环耗费更多内存
		for(String name:names){
			System.out.print(name+" ");
		}
	}
}
