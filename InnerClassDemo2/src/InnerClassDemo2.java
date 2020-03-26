

public class InnerClassDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog("hh");
		dog.childTalk("abc");
	}

}
class Dog{
	private String name;
	public Dog(String name){
		this.name=name;
	}
	
	public void say(){
		System.out.println("Outer class "+name);
	}	
	
	public void childTalk(final String str){
		//内部类(成员内部类)
		final int x=10;
		class ChildDog{
			public void talk(){
				System.out.println("Method inner class "+name);
				System.out.println(x);//变量必须声明为final
				System.out.println(str);
			}
		}
		ChildDog dog=new ChildDog();
		dog.talk();
	}
}
