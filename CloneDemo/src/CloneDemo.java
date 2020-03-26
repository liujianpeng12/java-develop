public class CloneDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cat c = new Cat("haha", 3);
		try {
			Cat c1 = (Cat) c.clone();
			System.out.println(c1);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

/*
 * 一个类要想实现克隆,必须 
 * 1.实现Cloneable接口,该接口是一个标记接口,没有任何方法 
 * 2.重写Object类中的clone方法
 * 需要创建一组对象时,使用克隆比使用new创建对象效应要高
 */
class Cat implements Cloneable {
	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + ":" + age;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}