import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class DynamicProxyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p=new Person("小明");
		DynamicProxy dp=new DynamicProxy(p);
		
		Subject s=(Subject)Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), dp);
		s.miai();
	}

}

//主题
interface Subject{
	void miai();
}

//被代理对象
class Person implements Subject{
	private String name;
	public Person(String name){
		this.name=name;
	}
	public void miai(){
		System.out.println(name+" 进行中...");
	}
}

class DynamicProxy implements InvocationHandler{

	Subject target;
	public DynamicProxy(Subject target){
		this.target=target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object obj=null;
		obj=method.invoke(target, args);
		after();
		return obj;
	}
	
	private void before(){
		System.out.println("代理之前进行处理...");
	}
	private void after(){
		System.out.println("代理之后进行处理...");
	}
}