package com.dzj.house.dto;

import java.util.Date;
import java.util.List;

import com.dzj.house.entity.HousePicture;

public class HouseListDto {
	

	
	private long houseId;
	
	private String title;
	private Date lastUpdateTime;
	private int status;
	private	List<HousePicture> housePictureList;
	
	
	public List<HousePicture> getHousePictureList() {
		return housePictureList;
	}
	public void setHousePictureList(List<HousePicture> housePictureList) {
		this.housePictureList = housePictureList;
	}
	public long getHouseId() {
		return houseId;
	}
	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
