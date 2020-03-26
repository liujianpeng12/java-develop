

//匿名内部类
public class InnerClassDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//继承式匿名内部类
		Dog dog=new Dog("aa"){
			public void say(){
				System.out.println("匿名 inner class "+name);
			}
		};
		dog.say();
	}

}
class Dog{
	protected String name;
	public Dog(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.println("Outer class "+name);
	}
}
