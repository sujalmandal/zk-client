package com.learn.zk;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class ZooKeeperDAOImpl implements ZooKeeperDAO {

	private ZooKeeper zooKeeper;

	public ZooKeeperDAOImpl(ZooKeeper zk) {
		this.zooKeeper = zk;
	}

	@Override
	public void save(String path, byte[] data, CreateMode createMode) 
			throws KeeperException, InterruptedException {
		saveWithACL(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, createMode);
	}

	@Override
	public void saveWithACL(String path, byte[] data, List<ACL> acls, CreateMode createMode)
			throws KeeperException, InterruptedException {
		zooKeeper.create(path, data, acls, createMode);
	}

	@Override
	public void update(String path, byte[] data) throws KeeperException, InterruptedException {
		int version = zooKeeper.exists(path, true).getVersion();
		zooKeeper.setData(path, data, version);
	}

	@Override
	public Object get(String path, Watcher watcher) 
			throws UnsupportedEncodingException, KeeperException, InterruptedException {
		byte[] b = zooKeeper.getData(path, watcher, null);
		return new String(b, "UTF-8");
	}

}