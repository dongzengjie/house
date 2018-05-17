package com.dzj.house.entity;

import java.util.Date;

public class House {
	private long houseId;
	private String title;
	private Integer price;
	private Integer area;
	private Integer room;
	private Integer floor;
	private Integer totalFloor;
	private int watchTimes;
	private String buildYear;
	private int status;//1.上架 0.下架 -1 审核未通过 1 审核通过 -2 待审核
	private Date createTime;
	private Date lastUpdateTime;
	private String cityEnName;
	private String regionEnName;
	private String cover;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public Integer getRoom() {
		return room;
	}
	public void setRoom(Integer room) {
		this.room = room;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getTotalFloor() {
		return totalFloor;
	}
	public void setTotalFloor(Integer totalFloor) {
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
	public String getRegionEnName() {
		return regionEnName;
	}
	public void setRegionEnName(String regionEnName) {
		this.regionEnName = regionEnName;
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
	public String getFrontPicture() {
		return frontPicture;
	}
	public void setFrontPicture(String frontPicture) {
		this.frontPicture = frontPicture;
	}
	public String getCityCnName() {
		return cityCnName;
	}
	public void setCityCnName(String cityCnName) {
		this.cityCnName = cityCnName;
	}
	private String direction;
	private String distanceToSubway;
	private String parlour;
	private String  district;
	private long userId;
	private int bathroom;
	private String street;
	private String frontPicture;
	private String cityCnName;
	
	
	
	

	
	
}
