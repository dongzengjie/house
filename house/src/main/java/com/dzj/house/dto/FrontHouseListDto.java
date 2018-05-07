package com.dzj.house.dto;

import java.util.Date;

public class FrontHouseListDto {

	
	private long houseId;
	private String title;
	private int price;
	private int room;
	private int area;
	private int floor;
	private int totalFloor;
	private String frontPicture;
	private String buildYear;
	private Date lastUpdateTime;
	private int parlour;
	private String direction;
	private String distanceToSubway;
	private String subwayName;
	private String subwayStationName;
	private String district;
	private String cityCnName;
	
	
	
	
	public String getCityCnName() {
		return cityCnName;
	}
	public void setCityCnName(String cityCnName) {
		this.cityCnName = cityCnName;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
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
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public int getTotalFloor() {
		return totalFloor;
	}
	public void setTotalFloor(int totalFloor) {
		this.totalFloor = totalFloor;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public int getParlour() {
		return parlour;
	}
	public void setParlour(int parlour) {
		this.parlour = parlour;
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
	public String getSubwayName() {
		return subwayName;
	}
	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}
	public String getSubwayStationName() {
		return subwayStationName;
	}
	public void setSubwayStationName(String subwayStationName) {
		this.subwayStationName = subwayStationName;
	}
	
	
	
	
	
}
