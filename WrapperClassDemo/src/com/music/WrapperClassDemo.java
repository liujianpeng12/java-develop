package com.music;

public class WrapperClassDemo {

	/**
	 * Java 基本类型的包装类的大部分都实现了常量池技术，即 Byte,Short,Integer,Long,Character,Boolean；这
	 * 5 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据，但是超出此范围仍然会去创建新的对象。 两种浮点数类型的包装类
	 * Float,Double 并没有实现常量池技术。
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Integer直接赋值时,当值为1个字节(-128-127)的数时,将使用同一个对象
		// Byte,Short,Integer,Long 用到了享元设计模式
		Integer x1 = 1000;
		Integer x2 = 1000;
		System.out.println(x1 == x2);

		System.out.println("----------");
		test1();
		System.out.println("----------");
		test2();

	}

	private static void test1() {
		Integer i1 = 33;
		Integer i2 = 33;
		System.out.println(i1 == i2);// 输出 true
		Integer i11 = 333;
		Integer i22 = 333;
		System.out.println(i11 == i22);// 输出 false
		Double i3 = 1.2;
		Double i4 = 1.2;
		System.out.println(i3 == i4);// 输出 false

		Integer i5 = 40;
		Integer i6 = new Integer(40);
		System.out.println(i5 == i6);// 输出 false
	}

	private static void test2() {
		Integer i1 = 40;
		Integer i2 = 40;
		Integer i3 = 0;
		Integer i4 = new Integer(40);
		Integer i5 = new Integer(40);
		Integer i6 = new Integer(0);

		System.out.println("i1=i2   " + (i1 == i2));// true
		System.out.println("i1=i2+i3   " + (i1 == i2 + i3));// true
		System.out.println("i1=i4   " + (i1 == i4));// false
		System.out.println("i4=i5   " + (i4 == i5));// false
		// 语句 i4 == i5 + i6，因为+这个操作符不适用于 Integer 对象，首先 i5 和 i6 进行自动拆箱操作，进行数值相加，即
		// i4 == 40。然后 Integer 对象无法与数值进行直接比较，所以 i4 自动拆箱转为 int 值 40，最终这条语句转为 40
		// == 40 进行数值比较。
		System.out.println("i4=i5+i6   " + (i4 == i5 + i6)); // true
		System.out.println("40=i5+i6   " + (40 == i5 + i6));// true
		System.out.println("40=i5+i6   " + (i4 == i5 + 0));//true
		System.out.println("40=i5+i6   " + (40 == i5 + 0));//true
	}

}
