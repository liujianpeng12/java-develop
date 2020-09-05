import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeTest {
    public static void main(String[] args) {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.addLast("34");
        arrayDeque.offerFirst("12");
        Iterator<String> iterator = arrayDeque.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
