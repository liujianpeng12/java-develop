/**
 *
 */
public class DoubleEndedTest {
    public static void main(String[] args) {
        tail();
        System.out.println("======================================");
        head();
    }

    /**
     * 尾部下标从1、2、3、.....、14、15、0，依次按照顺序存储，当达到最大值之后，返回到头部，从 0 开始，结果是一个循环下标。
     */
    private static void tail() {
        int tail = 0;
        int[] elements = new int[16];
        for (int i = 0; i < elements.length;  i++) {
            tail = (tail + 1) & (elements.length - 1);
            System.out.println("第" + (i+1) + "次计算，结果值：" + tail);
        }
    }

    /**
     * 头部计算的下标从15、14、13、.....、2、1、0，依次从大到小按照顺序存储，当达到最小值之后，返回到头部，从 0 开始，结果也是一个循环下标
     */
    private static void head() {
        int head = 0;
        int[] elements = new int[16];
        for (int i = 0; i < elements.length;  i++) {
            head = (head - 1) & (elements.length - 1);
            System.out.println("第" + (i+1) + "次计算，结果值：" + head);
        }
    }

}
