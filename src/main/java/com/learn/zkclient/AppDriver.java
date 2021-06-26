package com.learn.zkclient;

import java.util.Date;

import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.learn.zkclient.constants.AppConstants;
import com.learn.zkclient.core.ZooKeeperDAO;
import com.learn.zkclient.entity.InstanceMetadata;
import com.learn.zkclient.utils.SerializerDeSerializer;

@SpringBootApplication
public class AppDriver implements InitializingBean, DisposableBean {

    @Autowired
    private ZooKeeperDAO zooKeeperDAO;

    public static void main(String[] args) {
	SpringApplication.run(AppDriver.class, args);
    }

    @Override
    public void destroy() throws Exception {
	System.out.println("app shutting down " + getInstanceData().getId());
    }

    @Bean
    public InstanceMetadata getInstanceData() {
	return new InstanceMetadata("Zk-client", "Mars", new Date());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
	InstanceMetadata instance = getInstanceData();
	zooKeeperDAO.save(AppConstants.INSTANCES_PATH + AppConstants.INSTANCE_PATH + instance.getId(),
		SerializerDeSerializer.serialize(instance), CreateMode.EPHEMERAL);
	System.out.println("Registered instance " + instance.getId() + " with zookeeper..");
    }

}