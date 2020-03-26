package com.myzookeeper.locks;

import java.util.Arrays;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.data.Stat;

import com.myzookeeper.TestMainClient;

public class MyLocks extends TestMainClient {

	String myZnode;
	
	public MyLocks(String connectString, String root) {
		super(connectString);
		super.root =  root;
		
		if(zk != null){
			try {
				Stat s = zk.exists(root, false);
				if(s == null){
					zk.create(root, new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
				}
			} catch (KeeperException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void getLock() throws KeeperException, InterruptedException{
		List<String> list = zk.getChildren(root, false);
		String[] nodes = list.toArray(new String[list.size()]);
		Arrays.sort(nodes);
		if(myZnode.equals(root + "/" + nodes[0])){
			doAction();
		}else{
			waitForLock(nodes[0]);
		}
	}
	
	private void waitForLock(String lower) throws InterruptedException, KeeperException{
		Stat s = zk.exists(root + "/" + lower, true);//监控当前最小的节点
		if(s != null){
			mutex.wait();
		}else{
			getLock();
		}
	}
	
	private void check() throws KeeperException, InterruptedException{
		myZnode = zk.create(root + "/lock_", new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		getLock();
	}
	
	@Override
	public void process(WatchedEvent event){
		if(event.getType() == Event.EventType.NodeDeleted){
			System.out.println("得到通知");
			super.process(event);
			doAction();
		}
	}
	
	private void doAction(){
		System.out.println("同步队列已经得到同步，可以开始执行后面的任务了");
	}
	
	public static void main(String[] args){
		String connectString = "192.168.0.180:2181";
		
		MyLocks myLocks = new MyLocks(connectString, "/locks");
		try {
			myLocks.check();
		} catch (KeeperException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
