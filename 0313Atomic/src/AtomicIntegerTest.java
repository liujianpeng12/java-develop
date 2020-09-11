/**
 * 原子操作是指不会被线程调度机制打断的操作，这种操作一旦开始，就一直运行到结束，中间不会有任何线程上下文切换。
 * 原子操作可以是一个步骤，也可以是多个操作步骤，但是其顺序不可以被打乱，也不可以被切割而只执行其中的一部分，将整个操作视作一个整体是原子性的核心特征。
 *
 * （1）AtomicInteger中维护了一个使用volatile修饰的变量value，保证可见性；
 * （2）AtomicInteger中的主要方法最终几乎都会调用到Unsafe的compareAndSwapInt()方法保证对变量修改的原子性。
 */
public class AtomicIntegerTest {
}
