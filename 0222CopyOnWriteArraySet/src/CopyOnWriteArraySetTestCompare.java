import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 如何比较两个Set中的元素是否完全相等？
 * 1)最简单的方式就是判断是否A中的元素都在B中，B中的元素是否都在A中，也就是两次两层循环。
 * 2)Set中的元素并不重复，所以只要先比较两个Set的元素个数是否相等，再作一次两层循环就可以了
 */
public class CopyOnWriteArraySetTestCompare {

    public static void main(String[] args) {
        Set<Integer> set1 = new CopyOnWriteArraySet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new CopyOnWriteArraySet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);

        System.out.println(eq(set1, set2));
        System.out.println(eq(set2, set1));

    }

    private static <T> boolean eq(Set<T> set1, Set<T> set2) {
        if(set1.size() != set2.size()) {
            return false;
        }

        for (T t : set1) {
            // contains相当于一层for循环
            if(!set2.contains(t)) {
                return false;
            }
        }
        return true;
    }
}
