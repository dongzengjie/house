package com.dzj.house.entity;

import java.util.Date;

public class HouseSubscribe {
	private long houseSubscribeId;
	private long houseId;
	private long userId;
	private String desc;
	private int status;
	private Date createTime;
	private Date lastUpdateTime;
	private Date orderTime;
	private String telephone;
	private long adminId;
	public long getHouseSubscribeId() {
		return houseSubscribeId;
	}
	public void setHouseSubscribeId(long houseSubscribeId) {
		this.houseSubscribeId = houseSubscribeId;
	}
	public long getHouseId() {
		return houseId;
	}
	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	
	
	
}
