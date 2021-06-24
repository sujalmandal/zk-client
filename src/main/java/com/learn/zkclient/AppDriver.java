package com.learn.zkclient;

import java.util.Date;

import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learn.zk.ZooKeeperDAO;
import com.learn.zk.utils.SerializerDeSerializer;
import com.learn.zkclient.entity.InstanceMetadata;

@SpringBootApplication
public class AppDriver implements CommandLineRunner {
	
	@Autowired
	private ZooKeeperDAO zooKeeperDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(AppDriver.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		InstanceMetadata instance = new InstanceMetadata("Zk-client", "Mars", new Date());
		zooKeeperDAO.save(
				"/instances/"+instance.getId(),
				SerializerDeSerializer.serialize(instance),
				CreateMode.EPHEMERAL);
		System.out.println("Wrote instance data to zookeeper!");
		Thread.sleep(1000*30);
		System.out.println("App shutting down..");
	}
	
}