package com.myzookeeper.hello;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {

		//创建一个与服务器的连接
		ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 60000, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				System.out.println("已经触发了" + event.getPath() + "路径的" + event.getType() + "事件");
			}
		});
		
		//创建目录
		//zk.create("/myzookeeper", "mydata".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		//创建子目录
		//zk.create("/myzookeeper/node2", "mydata1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		
		System.out.println(new String(zk.getData("/myzookeeper", false, null)));
		
		//取出子目录列表
		System.out.println(zk.getChildren("/myzookeeper", true));
		
		//修改子目录数据
		zk.setData("/myzookeeper/node2", "mydata2".getBytes(), -1);
		System.out.println(new String(zk.getData("/myzookeeper/node2", false, null)));
		
		System.out.println("目录节点状态" + zk.exists("/myzookeeper", true));
		
		//创建另外的目录
		zk.create("/myzookeeper/node3", "mydata3".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println(new String(zk.getData("/myzookeeper/node3", true, null)));
		
		//删除子目录
		zk.delete("/myzookeeper/node2", -1);
		zk.delete("/myzookeeper/node3", -1);
		//删除父目录
		zk.delete("/myzookeeper", -1);
		
		zk.close();
	}
}
