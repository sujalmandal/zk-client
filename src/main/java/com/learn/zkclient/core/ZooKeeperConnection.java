package com.learn.zkclient.core;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZooKeeperConnection {
	private ZooKeeper zk;
	private CountDownLatch latch = new CountDownLatch(1);
	
	public ZooKeeper connnect(String serverUrl) throws InterruptedException, IOException {
		zk = new ZooKeeper(serverUrl, 2500, new Watcher() {
			@Override
			public void process(WatchedEvent event) {
				if(event.getState()==KeeperState.SyncConnected) {
					latch.countDown();
				}
			}
		});
		latch.await();
		return zk;
	}
	
	public void disconnect() throws InterruptedException {
		zk.close();
	}
}