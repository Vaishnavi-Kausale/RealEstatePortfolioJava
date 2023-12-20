package com.rpf.vk.entity;

public class PropertystatusPojo {
	long propertyid;
	int status;
	public PropertystatusPojo(long propertyid, int status) {
		super();
		this.propertyid = propertyid;
		this.status = status;
	}
	public PropertystatusPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getPropertyid() {
		return propertyid;
	}
	public void setPropertyid(long propertyid) {
		this.propertyid = propertyid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
