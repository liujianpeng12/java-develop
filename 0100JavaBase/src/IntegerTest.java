/**
 * https://www.cnblogs.com/ysocean/p/8564466.html
 */
public class IntegerTest {
    public static void main(String[] args) {
        char c = '1';
        int i = c;
        System.out.println(i);//49

        int si = Character.digit('1', 10);
        System.out.println(si);//1

        Integer in = 128;//装箱
        System.out.println(in);

        Integer iin = new Integer(1);
        int m = iin;//拆箱
        System.out.println(m);

        Integer in1 = new Integer(2);
        Integer in2 = new Integer(2);
        System.out.println(in1 == in2);//false

        Integer it1 = Integer.valueOf(3);
        Integer it2 = 3;
        System.out.println(it1 == it2);//true
    }
}
