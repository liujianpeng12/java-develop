
public class Test {

	public static void main(String[] args){
		System.out.println("ClassLodarDemo's ClassLoader is " + Test.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + Test.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + Test.class.getClassLoader().getParent().getParent());
    }
}
