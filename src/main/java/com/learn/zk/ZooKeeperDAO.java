package com.learn.zk;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.ACL;

public interface ZooKeeperDAO {
	
	public void save(String path, byte[] data, CreateMode createMode) 
			throws KeeperException, InterruptedException;

	void saveWithACL(String path, byte[] data, List<ACL> acls, CreateMode createMode) 
			throws KeeperException, InterruptedException;
	
	public void update(String path, byte[] data) 
			throws KeeperException, InterruptedException;
	
	Object get(String path, Watcher watcher) 
			throws UnsupportedEncodingException, KeeperException, InterruptedException;
}