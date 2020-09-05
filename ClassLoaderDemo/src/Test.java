
public class Test {

	public static void main(String[] args){
		System.out.println("ClassLoaderDemo's ClassLoader is " + Test.class.getClassLoader());
        System.out.println("The Parent of ClassLoaderDemo's ClassLoader is " + Test.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLoaderDemo's ClassLoader is " + Test.class.getClassLoader().getParent().getParent());
    }
}
