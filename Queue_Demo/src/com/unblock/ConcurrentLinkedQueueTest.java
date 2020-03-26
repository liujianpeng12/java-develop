package com.unblock;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 一个基于链接节点的无界线程安全队列。此队列按照 FIFO（先进先出）原则对元素进行排序。队列的头部 是队列中时间最长的元素。队列的尾部
 * 是队列中时间最短的元素。 新的元素插入到队列的尾部，队列获取操作从队列头部获得元素。当多个线程共享访问一个公共 collection
 * 时，ConcurrentLinkedQueue 是一个恰当的选择。此队列不允许使用 null 元素。
 * 
 * @author Administrator
 *
 */
public class ConcurrentLinkedQueueTest {

	public static void main(String[] args) {
		// offerAndPoll();
		// peek();
		//remove();
		iterator();
	}

	private static void offerAndPoll() {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("哈哈哈");
		System.out.println("offer后，队列是否空？" + queue.isEmpty());
		System.out.println("从队列中poll：" + queue.poll());
		System.out.println("pool后，队列是否空？" + queue.isEmpty());
	}

	private static void peek() {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("哈哈");
		System.out.println("offer后，队列是否空？" + queue.isEmpty());
		System.out.println("从队列中peek：" + queue.peek());
		System.out.println("从队列中peek：" + queue.peek());
		System.out.println("从队列中peek：" + queue.peek());
		System.out.println("peek后，队列是否空？" + queue.isEmpty());
	}

	private static void remove() {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("哈哈");
		System.out.println("offer后，队列是否空？" + queue.isEmpty());
		System.out.println("从队列中remove存在元素：" + queue.remove("哈哈"));
		System.out.println("从队列中remove不存在元素：" + queue.remove("123"));
		System.out.println("remove后，队列是否空？" + queue.isEmpty());
	}
	
	private static void iterator(){
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("3");
		queue.offer("2");
		Iterator<String> it = queue.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
