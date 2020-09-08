import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        //一半值
        System.out.println(10 >> 1);

        //两倍值
        System.out.println(3333 << 1);

        List<String> arraylist = new ArrayList<>();
        //arraylist.add(2, "2");

        arraylist.add("1");
        arraylist.add("2");
        arraylist.add("3");
        arraylist.remove(1);
    }
}
