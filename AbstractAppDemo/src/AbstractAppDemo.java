
/**
 * 抽象类: abstract
 * 1.抽象类不一定要有抽象方法
 * 2.抽象类可以有属性和具体方法实现
 * 3.抽象方法:只有声明,没有实现
 * 4.抽象类不能被实例化
 * 5.非抽象类继承抽象类必须实现所有抽象方法
 * 
 * 抽象类的应用
 * 设计模式:模板方法设计模式
 * 核心:定义一个业务流程的整体框架,把一些细节部分延迟到子类中实现
 * 抽象的是可变的细节部分
 * @author Administrator
 *
 */

public class AbstractAppDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Palace s=new Shemale("hh");
		s.action();
	}

}
abstract class Palace{
	//模板方法设计模式
	public void action(){
		if(competition()){
			System.out.println("sucess");
		}else{
			System.out.println("fail");
		}
	}
	
	abstract boolean competition();
}
class Shemale extends Palace{
	private String name;
	public Shemale(String name){
		this.name=name;
	}
	
	public boolean competition(){
		System.out.println("I am "+ name);
		return true;
	}
}