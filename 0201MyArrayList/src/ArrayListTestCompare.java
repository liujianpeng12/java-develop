import java.util.ArrayList;
import java.util.List;

/**
 * 如何比较两个List中的元素是否完全相等呢？
 * 1)最简单的方式就是判断是否A中的元素都在B中，B中的元素是否都在A中，也就是两次两层循环。
 * 2)不需要做两次两层遍历，一次也可以搞定，设定一个标记数组，标记某个位置的元素是否找到过
 */
public class ArrayListTestCompare {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(8);
        list1.add(0);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(7);
        list2.add(8);
        list2.add(0);

        System.out.println(eq(list1, list2));
        System.out.println(eq(list2, list1));
    }

    private static <T> boolean eq(List<T> list1, List<T> list2) {
        if(list1.size() != list2.size()) {
            return false;
        }
        // 标记某个元素是否找到过，防止重复
        boolean[] matched = new boolean[list1.size()];

        outer: for(T t : list1) {
            for(int i = 0; i < list2.size(); i++) {
                // i这个位置没找到过才比较大小
                if(!matched[i] && list2.get(i).equals(t)) {
                    matched[i] = true;
                    continue outer;
                }
            }
            return false;
        }
        return true;
    }
}
