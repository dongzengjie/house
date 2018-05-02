package com.dzj.house.entity;

public class HousePicture {
	private long housePictureId;
	private long houseId;
	private String cdnPrefix;
	private String width;
	private String heigh;
	private String location;
	private String path;
	private int homePicture;
	
	
	public int getHomePicture() {
		return homePicture;
	}
	public void setHomePicture(int homePicture) {
		this.homePicture = homePicture;
	}
	public long getHousePictureId() {
		return housePictureId;
	}
	public void setHousePictureId(long housePictureId) {
		this.housePictureId = housePictureId;
	}
	public long getHouseId() {
		return houseId;
	}
	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}
	public String getCdnPrefix() {
		return cdnPrefix;
	}
	public void setCdnPrefix(String cdnPrefix) {
		this.cdnPrefix = cdnPrefix;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeigh() {
		return heigh;
	}
	public void setHeigh(String heigh) {
		this.heigh = heigh;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
