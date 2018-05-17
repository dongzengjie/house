package com.dzj.house.dto;

public class SearchDto {
	private String cityEnName;
	
	private long subwayId;
	private String subwayName;
	
	private int room;
	private String direction;
	private String regionEnName;
	private String rentWay;
	private String orderBy;
	private int start;
	private int size;
	private int priceMin;
	private int priceMax;
	private int areaMin;
	private int areaMax;
	private String keywords;
	
	private String orderDirection;
	
	
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getOrderDirection() {
		return orderDirection;
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	public String getCityEnName() {
		return cityEnName;
	}
	public void setCityEnName(String cityEnName) {
		this.cityEnName = cityEnName;
	}
	public long getSubwayId() {
		return subwayId;
	}
	public void setSubwayId(long subwayId) {
		this.subwayId = subwayId;
	}
	public String getSubwayName() {
		return subwayName;
	}
	public void setSubwayName(String subwayName) {
		this.subwayName = subwayName;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getRegionEnName() {
		return regionEnName;
	}
	public void setRegionEnName(String regionEnName) {
		this.regionEnName = regionEnName;
	}
	public String getRentWay() {
		return rentWay;
	}
	public void setRentWay(String rentWay) {
		this.rentWay = rentWay;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}
	public int getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	public int getAreaMin() {
		return areaMin;
	}
	public void setAreaMin(int areaMin) {
		this.areaMin = areaMin;
	}
	public int getAreaMax() {
		return areaMax;
	}
	public void setAreaMax(int areaMax) {
		this.areaMax = areaMax;
	}
	
	
}
