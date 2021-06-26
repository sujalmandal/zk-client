package com.learn.zkclient.config;

import java.io.IOException;

import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learn.zkclient.core.ZooKeeperConnection;
import com.learn.zkclient.core.ZooKeeperDAO;
import com.learn.zkclient.core.ZooKeeperDAOImpl;

@Configuration
public class AppConfig implements DisposableBean{
	
	@Value("${zookeeper.host}")
	private String zkHost;
	
	@Autowired
	private ZooKeeperConnection zkConn;
	
	@Autowired
	private ZooKeeper zk;
	
	@Bean
	public ZooKeeperConnection zooKeeperConn() {
		return new ZooKeeperConnection();
	}
	
	@Bean
	public ZooKeeper zooKeeper() throws InterruptedException, IOException {
		return zkConn.connnect(zkHost); 
	}
	
	@Bean
	public ZooKeeperDAO zkDAOImpl() {
		return new ZooKeeperDAOImpl(zk);
	}

	@Override
	public void destroy() throws Exception {
		zkConn.disconnect();
	}

}