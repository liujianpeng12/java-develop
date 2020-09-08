import java.util.ArrayList;

/**
 * https://www.cnblogs.com/ysocean/p/8419559.html
 */
public class ObjectTest {
    public static void main(String[] args) {

        //
        Integer integer = new Integer(0);
        System.out.println(integer.toString());

        //
        ArrayList arrayList = new ArrayList<>();
        arrayList.add("abc");
        System.out.println(arrayList.toString());

        String s = "123str";
        System.out.println(s.toString());

        //Object对象常用方法
        Object obj = new Object();
        System.out.println(obj.hashCode());
        System.out.println(obj.equals("122"));
        System.out.println(obj.toString());
        System.out.println(obj.getClass());
        System.out.println((new ObjectTest()).getClass());
        System.out.println(ObjectTest.class);
    }
}
