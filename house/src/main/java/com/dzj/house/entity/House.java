package com.dzj.house.entity;

import java.util.Date;

public class House {
	private long houseId;
	private String title;
	private int price;
	private int area;
	private int room;
	private int floor;
	private int totalFloor;
	private int watchTimes;
	private String buildYear;
	private int status;//1.上架 0.下架
	private Date createTime;
	private Date lastUpdateTime;
	private String cityEnName;
	private String redionEnName;
	private String cover;
	private String direction;
	private String distanceToSubway;
	private String parlour;
	private String  district;
	private long userId;
	private int bathroom;
	private String street;
	private String frontPicture;
	private String cityCnName;
	
	
	
	
	
	public String getCityCnName() {
		return cityCnName;
	}
	public void setCityCnName(String cityCnName) {
		this.cityCnName = cityCnName;
	}
	public String getFrontPicture() {
		return frontPicture;
	}
	public void setFrontPicture(String frontPicture) {
		this.frontPicture = frontPicture;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getTotalFloor() {
		return totalFloor;
	}
	public void setTotalFloor(int totalFloor) {
		this.totalFloor = totalFloor;
	}
	public int getWatchTimes() {
		return watchTimes;
	}
	public void setWatchTimes(int watchTimes) {
		this.watchTimes = watchTimes;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
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
	public String getCityEnName() {
		return cityEnName;
	}
	public void setCityEnName(String cityEnName) {
		this.cityEnName = cityEnName;
	}
	public String getRedionEnName() {
		return redionEnName;
	}
	public void setRedionEnName(String redionEnName) {
		this.redionEnName = redionEnName;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getDistanceToSubway() {
		return distanceToSubway;
	}
	public void setDistanceToSubway(String distanceToSubway) {
		this.distanceToSubway = distanceToSubway;
	}
	public String getParlour() {
		return parlour;
	}
	public void setParlour(String parlour) {
		this.parlour = parlour;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getBathroom() {
		return bathroom;
	}
	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	
	
	
	
}
