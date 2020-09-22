import java.util.Arrays;
import java.util.List;

/**
 * 并行计算（Java8+）
 * 使用并行计算的方式，可以提高程序运行的效率，多线程并行执行。
 */
public class CreatingThread07 {

    public static void main(String[] args){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //串行,打印结果12345
        list.stream().forEach(System.out::print);
        System.out.println();
        //并行,打印结果随机,如32145
        list.parallelStream().forEach(System.out::print);
        System.out.println();
    }
}
