package com.vince.annotation;

import java.lang.annotation.*;

/**
 * 注解
 * 
 * @author Administrator
 * 
 */
@MyAnnotation(name = "abc", like = { "a", "b", "c" },sex=EnumSex.G)
public class AnnotationDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	@SuppressWarnings("deprecation")// @SuppressWarnings 表示关闭不当的编译器警告信息
	public static void main(String[] args) throws ClassNotFoundException {
		
		//反射与注解
		Class<?> c=Class.forName("com.vince.annotation.User");
		Annotation[] annotations=c.getAnnotations();
		for(Annotation a: annotations){
			if(c.isAnnotationPresent(MyAnnotation.class)){
				MyAnnotation ma=(MyAnnotation)a;
				System.out.println(ma.name());
			}
		}
	}

	

}
@MyAnnotation(name="bb",like={"a","b","c"},sex=EnumSex.M )
class User{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "name";
	}

	@Deprecated
	public void print() {
		System.out.println("out");
	}
}

/**
 * 自定义注解
 * 
 * @author Administrator
 * 
 */
@Inherited//允许被其子类继承
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})//使用范围
@Retention(RetentionPolicy.RUNTIME)//元注解
@interface MyAnnotation {
	public String name();

	// 定义一个属性,并指定默认值
	public int age() default 10;

	// 数组属性
	public String[] like();
	
	//枚举属性
	public EnumSex sex();
}

enum EnumSex{
	M,G
}


