package com.learn.zkclient.service;

import java.io.UnsupportedEncodingException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.zkclient.constants.AppConstants;
import com.learn.zkclient.core.ZooKeeperDAO;

@Service
public class ZkService {

    @Autowired
    private ZooKeeperDAO zooKeeperDAO;

    public Object getRegisteredInstances() {
	try {
	    return zooKeeperDAO.get(AppConstants.INSTANCES_PATH, new Watcher() {
		@Override
		public void process(WatchedEvent event) {
		    System.out.println(event.getPath());
		}
	    });
	} catch (UnsupportedEncodingException | KeeperException | InterruptedException e) {
	    e.printStackTrace();
	}
	return null;
    }

}
