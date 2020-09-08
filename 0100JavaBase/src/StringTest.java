/**
 * https://www.cnblogs.com/ysocean/p/8571426.html
 */
public class StringTest {
    public static void main(String[] args) {
        //String的构造方法很多
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = new String(new char[]{'a', 'b', 'c'});
        String str4 = "abc";

        //String 类重写了 equals 方法，比较的是组成字符串的每一个字符是否相同，如果都相同则返回true，否则返回false。
        boolean b1 = str1.equals(str2);//true
        System.out.println(b1);

        System.out.println(str1 == str2);//false
        System.out.println(str2 == str3);//false
        System.out.println(str1 == str4);//true

        System.out.println("===============");
        String str5 = "helloworld";
        String str6 = str1+"world";//编译器不能确定为常量(会在堆区创建一个String对象)
        String str7 = "hello"+"world";//编译器确定为常量，直接到常量池中引用
        System.out.println(str5 == str6);//false
        System.out.println(str5 == str7);//true
        System.out.println(str6 == str7);//false

        System.out.println("````````````````````````````");
        String str11 = "hello";//字面量 只会在常量池中创建对象
        String str12 = str11.intern();
        System.out.println(str11==str12);//true

        String str13 = new String("world");//new 关键字只会在堆中创建对象
        String str14 = str13.intern();
        System.out.println(str13 == str14);//false

        String str15 = str11 + str12;//变量拼接的字符串，会在常量池中和堆中都创建对象
        String str16 = str15.intern();//这里由于池中已经有对象了，直接返回的是对象本身，也就是堆中的对象
        System.out.println(str15 == str16);//true

        String str17 = "hello1" + "world1";//常量拼接的字符串，只会在常量池中创建对象
        String str18 = str17.intern();
        System.out.println(str17 == str18);//true

        char v[];
        char[] v2;
        char c1 = 'a';
        System.out.println(c1);//a
        System.out.println(0 + c1);//97
        System.out.println((int)c1);//97

        //String 重写了hashCode()方法
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        //是基于字符串中每个字符的 Unicode 值
        System.out.println('a' - 'c');//-2
        System.out.println("abc".compareTo("adc"));//-2

        System.out.println("a" + "b");
        System.out.println("a".concat("b"));

        System.out.println("abcd".indexOf('a'));//0
        System.out.println("abcd".indexOf(97));//0
        System.out.println("abcd".indexOf("a"));//0
    }
}
