package com.abq;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {
    private int size = 0;//阻塞队列最大容量

    LinkedList<E> list = new LinkedList<>();//队列底层实现

    ReentrantLock lock = new ReentrantLock();
    Condition notFull = null;//队列满时的等待条件
    Condition notEmpty = null;//队列空时的等待条件

    public MyBlockingQueue(int size) {
        this.size = size;
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void endequeue(E e) {
        lock.lock();
        try {
            // 这里之所以使用while而不是if
            // 是因为有可能多个线程阻塞在lock上
            // 即使唤醒了可能其它线程先一步修改了队列又变成满的了
            // 这时候需要再次等待
            while (size == list.size()) {
                notFull.await();//队列已满,在notFull条件上等待
            }
            System.out.println("入队列:" + e);
            list.add(e);//入队:加入链表末尾

            notEmpty.signal(); //通知在notEmpty条件上等待的线程
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E dequeue()  {
        lock.lock();
        E e = null;
        try {
            while(list.size() == 0) {
                notEmpty.await();//队列为空,在notEmpty条件上等待
            }
            e = list.poll();//出队:移除链表首元素
            System.out.println("出队列:" + e);

            notFull.signal();//通知在notFull条件上等待的线程
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            lock.unlock();
        }

        return e;
    }
}
