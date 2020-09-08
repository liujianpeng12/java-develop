import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        asList();
        System.out.println("----------------------");
        sort();
        System.out.println("----------------------");
        binarySearch();
        System.out.println("----------------------");
        arrayCopy();
        System.out.println("----------------------");
        copyOf();
        System.out.println("----------------------");
        equals();
        System.out.println("----------------------");
        fill();
    }

    private static void asList() {
        //Arrays.asList() 方法使用场景
        //asList()方法返回的是 Arrays 的一个内部类 java.util.Arrays.ArrayList,但是，生成的List的长度是固定的；
        //能够进行修改操作（比如，修改某个位置的元素）；不能执行影响长度的操作（如add、remove等操作），否则会抛出UnsupportedOperationException异常。
        //所以 Arrays.asList 比较适合那些已经有数组数据或者一些元素，而需要快速构建一个List，只用于读取操作，而不进行添加或删除操作的场景。
        List<String> list1 = Arrays.asList("1", "2");
        //list1.add("a");// java.lang.UnsupportedOperationException

        String[] strs1 = {"a", "b", "c"};
        List<String> list2 = Arrays.asList(strs1);
        System.out.println(list2.size());//3

        int[] ints1 = {1, 2, 3};
        List<int[]> list3 = Arrays.asList(ints1);
        System.out.println(list3.size());//1

        Integer[] ints2 = {1, 2, 3};
        List<Integer> list4 = Arrays.asList(ints2);
        System.out.println(list4.size());//3

        //已知数组数据，如何快速获取一个可进行增删改查的列表List
        String[] strs2 = {"2", "3", "4"};
        List<String> list5 = new ArrayList<>(Arrays.asList(strs2));
        list5.add("a");
        System.out.println(list5.size());//4
    }

    private static void sort() {
        int[] ints1 = {2, 6, 3, 0, 7, 1};
        Arrays.sort(ints1);
        System.out.println(Arrays.toString(ints1));

        String[] arr1 = {"t", "d", "rw", "b"};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void binarySearch() {
        String[] arr = {"t", "d", "rw", "b"};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, "b");
        System.out.println(index);
    }

    private static void arrayCopy() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println(Arrays.toString(arr2));
    }

    private static void copyOf() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = Arrays.copyOf(arr1, arr1.length);
        System.out.println(Arrays.toString(arr2));
    }

    private static void equals() {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(Arrays.equals(arr1, arr2));
    }

    private static void fill() {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        System.out.println(Arrays.toString(arr));
    }
}
