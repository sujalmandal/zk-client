package com.learn.zkclient.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class InstanceMetadata implements Serializable{
	
	private static final long serialVersionUID = 9072347525316740388L;
	
	private String id;
	private String instanceName;
	private String region;
	private Date lastUpdated;
	
	public InstanceMetadata(String instanceName, String region, Date lastUpdated) {
		super();
		this.id = UUID.randomUUID().toString();
		this.instanceName = instanceName;
		this.region = region;
		this.lastUpdated = lastUpdated;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "InstanceMetadata [id=" + id + ", instanceName=" + instanceName + ", region=" + region + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
}