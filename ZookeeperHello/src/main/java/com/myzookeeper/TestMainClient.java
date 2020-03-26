package com.myzookeeper;

import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class TestMainClient implements Watcher {
	protected ZooKeeper zk = null;
	protected Integer mutex;
	private int sessionTimeout = 10000;
	protected String root;
	
	public TestMainClient(String connectString){
		try {
			zk = new ZooKeeper(connectString, sessionTimeout, this);
			mutex =  new Integer(-1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	synchronized public void process(WatchedEvent event) {
		synchronized(mutex){
			mutex.notify();
		}
		
	}

}
