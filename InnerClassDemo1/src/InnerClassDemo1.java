
public class InnerClassDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog("hh");
		dog.say();
		
		//一般不这么使用
		Dog.ChildDog cDog=dog.new ChildDog();
		cDog.talk();
		
		dog.childTalk();
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
	//内部类(成员内部类)
	public class ChildDog{
		public void talk(){
			System.out.println("Inner class "+name);
		}
	}
	
	public void childTalk(){
		ChildDog dog=new ChildDog();
		dog.talk();
	}
}
