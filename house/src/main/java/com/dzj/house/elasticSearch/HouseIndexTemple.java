package com.dzj.house.elasticSearch;

import java.util.Date;

public class HouseIndexTemple {
	private long houseId;
	private String title;
	private int price;
	private int area;
	private Date createTime;
	private Date lastUpdateTime;
	private String cityEnName;
	private String frontPicture;
	private String regionEnName;
	private String direction;
	private int distanceToSubway;
	private String street;
	private String district;
	private String description;
	private String traffic;
	private String layoutDesc;
	private String roundService;
	private String rentWay;
	
	private String subwayName;
	private String subwayStationName;
	
	
	
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
	public String getFrontPicture() {
		return frontPicture;
	}
	public void setFrontPicture(String frontPicture) {
		this.frontPicture = frontPicture;
	}
	public String getRegionEnName() {
		return regionEnName;
	}
	public void setRegionEnName(String regionEnName) {
		this.regionEnName = regionEnName;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getDistanceToSubway() {
		return distanceToSubway;
	}
	public void setDistanceToSubway(int distanceToSubway) {
		this.distanceToSubway = distanceToSubway;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getLayoutDesc() {
		return layoutDesc;
	}
	public void setLayoutDesc(String layoutDesc) {
		this.layoutDesc = layoutDesc;
	}
	public String getRoundService() {
		return roundService;
	}
	public void setRoundService(String roundService) {
		this.roundService = roundService;
	}
	public String getRentWay() {
		return rentWay;
	}
	public void setRentWay(String rentWay) {
		this.rentWay = rentWay;
	}
	
	
	
}
