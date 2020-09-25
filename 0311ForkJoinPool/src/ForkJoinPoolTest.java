import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ForkJoinPool
 * https://mp.weixin.qq.com/s?__biz=Mzg2ODA0ODM0Nw==&mid=2247484059&idx=1&sn=a4e1899cbc583fb2e427ad0b4974bd44&scene=21#wechat_redirect
 *
 * 基本思想: 把一个规模大的问题划分为规模小的子问题,然后分而治之, 最后合并子问题的结果得到最终的结果
 *
 * 典型应用场景: 二分搜索、大整数乘法、Strassen矩阵乘法、棋盘覆盖、归并排序、快速排序、线性时间选择、汉诺塔
 *
 * （1）ForkJoinPool特别适合于“分而治之”算法的实现；
 * （2）ForkJoinPool和ThreadPoolExecutor是互补的，不是谁替代谁的关系，二者适用的场景不同；
 * （3）ForkJoinTask有两个核心方法——fork()和join()，有三个重要子类——RecursiveAction、RecursiveTask和CountedCompleter；
 * （4）ForkjoinPool内部基于“工作窃取”算法实现；
 * （5）每个线程有自己的工作队列，它是一个双端队列，自己从队列头存取任务，其它线程从尾部窃取任务；
 * （6）ForkJoinPool最适合于计算密集型任务，但也可以使用ManagedBlocker以便用于阻塞型任务；
 * （7）RecursiveTask内部可以少调用一次fork()，利用当前线程处理，这是一种技巧；
 *
 *
 *  ForkJoinPool内部原理:
 *  （1）每个工作线程都有自己的工作队列WorkQueue；
 *  （2）这是一个双端队列，它是线程私有的；
 *  （3）ForkJoinTask中fork的子任务，将放入运行该任务的工作线程的队头，工作线程将以LIFO的顺序来处理工作队列中的任务；
 *  （4）为了最大化地利用CPU，空闲的线程将从其它线程的队列中“窃取”任务来执行；
 *  （5）从工作队列的尾部窃取任务，以减少竞争；
 *  （6）双端队列的操作：push()/pop()仅在其所有者工作线程中调用，poll()是由其它线程窃取任务时调用的；
 *  （7）当只剩下最后一个任务时，还是会存在竞争，是通过CAS来实现的；
 */
public class ForkJoinPoolTest {

    /**
     * 计算1亿个整数和
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("计算1亿个整数和");

        int length = 100000000;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        }

        //实际单线程比forkjoin处理要快
        //可以使用 /3*3/3*3/3*3/3*3/3*3 来模拟耗时
        //
        singleThreadSum(array);
        //
        multiThreadSum(array);
        //
        forkJoinSum(array);


        //数组分段
        for (int i = 0; i < 8; i++) {
            System.out.println(array.length / 8 * i + " , " + (array.length / 8 * (i + 1)));
        }

    }

    /**
     * 单线程
     * @param array
     */
    private static void singleThreadSum(int[] array) {
        long sum = 0;

        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            //sum += array[i];
            sum += (array[i]/3*3/3*3/3*3/3*3/3*3);
        }
        long time = System.currentTimeMillis() -  start;
        System.out.println("单线程计算结果: " + sum + ", 耗时:" + time);
    }

    private static void multiThreadSum(int[] array) throws ExecutionException, InterruptedException {
        int count = 8;
        ExecutorService threadPoool = Executors.newFixedThreadPool(count);
        List<Future<Long>> list = new ArrayList<>();

        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            int num = i;
            Future<Long> future = threadPoool.submit(()->{
                long sum = 0;
                for (int j = array.length / count * num; j < (array.length / count * (num + 1)); j++) {
                    //sum += array[j];
                    sum += (array[j]/3*3/3*3/3*3/3*3/3*3);
                }
                return sum;
            });
            list.add(future);
        }

        long total = 0;
        for (Future<Long> future : list) {
            total += future.get();
        }
        long time = System.currentTimeMillis() -  start;
        System.out.println("线程池多线程计算结果: " + total + ", 耗时:" + time);
    }

    private static void forkJoinSum(int[] array) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        //提交任务
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new SumTask(array, 0, array.length));
        //获取结果
        long sum = forkJoinTask.get();
        forkJoinPool.shutdown();

        long time = System.currentTimeMillis() -  start;
        System.out.println("ForkJoinPool多线程计算结果: " + sum + ", 耗时:" + time);
    }

    private static class SumTask extends RecursiveTask<Long> {
        private int[] arr;
        private int from;
        private int to;

        public SumTask(int[] arr, int from, int to) {
            this.arr = arr;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // 小于1000的时候直接相加，可灵活调整
            if(to - from <= 1000) {
                long sum =0;
                for (int i = from; i < to; i++) {
                    //sum += arr[i];
                    sum += (arr[i]/3*3/3*3/3*3/3*3/3*3);
                }
                return sum;
            }

            //分成两段任务
            int middle = (from + to) / 2;
            SumTask left = new SumTask(arr,from, middle);
            SumTask right = new SumTask(arr,middle,to);

            //提交左边的任务
            left.fork();
            //右边的任务直接利用当前线程计算, 节约开销
            Long rightResult = right.compute();
            //等待左边计算完毕
            Long leftResult = left.join();
            //返回结果
            return leftResult + rightResult;
        }
    }
}
