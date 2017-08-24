package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class Zk {
	private static String connectString="10.0.1.88:2181";  
	private static int sessionTimeout=999999;  
	
	public static void main(String[] args) throws Exception{  
	
		Watcher watcher=new Watcher(){  
			public void process(WatchedEvent event) {  
				System.out.println("监听到的事件："+event);  
			}  
		};  
		final ZooKeeper zookeeper=new ZooKeeper(connectString,sessionTimeout,watcher);  
			System.out.println("获得连接："+zookeeper);  
			final byte[] data=zookeeper.getData("/zk1", watcher, null);  
			System.out.println("读取的值："+new String(data));  
			zookeeper.close();  
	}
}
