package com.abq;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue是java并发包下一个以数组实现的阻塞队列，它是线程安全的,且不需要扩容
 * 队列，是一种线性表，它的特点是先进先出，又叫FIFO，就像我们平常排队一样，先到先得，即先进入队列的人先出队。
 *
 * 栈的特点是后进先出，队列的特点是先进行出；
 *
 * （1）ArrayBlockingQueue不需要扩容，因为是初始化时指定容量，并循环利用数组；
 * （2）ArrayBlockingQueue利用takeIndex和putIndex循环利用数组；
 * （3）入队和出队各定义了四组方法为满足不同的用途；
 * （4）利用重入锁和两个条件保证并发安全；
 *
 * ArrayBlockingQueue有哪些缺点呢？
 * a）队列长度固定且必须在初始化时指定，所以使用之前一定要慎重考虑好容量；
 * b）如果消费速度跟不上入队速度，则会导致提供者线程一直阻塞，且越阻塞越多，非常危险；
 * c）只使用了一个锁来控制入队出队，效率较低，那是不是可以借助分段的思想把入队出队分裂成两个锁呢？
 */
public class ArrayBlockingQueueTest {
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
}
