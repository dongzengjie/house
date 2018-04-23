package com.dzj.house.entity;

import java.util.Date;
import java.util.List;

public class SupportAddress {
	private long supportAddressId;
	private String belongTo;
	private String cityEnName;
	private String cityCnName;
	private String level;
	private Date baiduMapLng;
	private Date baiduMapLat;
	
	private List<Subway> subWayList;
	
	
	public List<Subway> getSubWayList() {
		return subWayList;
	}
	public void setSubWayList(List<Subway> subWayList) {
		this.subWayList = subWayList;
	}
	public long getSupportAddressId() {
		return supportAddressId;
	}
	public void setSupportAddressId(long supportAddressId) {
		this.supportAddressId = supportAddressId;
	}
	public String getBelongTo() {
		return belongTo;
	}
	public void setBelongTo(String belongTo) {
		this.belongTo = belongTo;
	}
	public String getCityEnName() {
		return cityEnName;
	}
	public void setCityEnName(String cityEnName) {
		this.cityEnName = cityEnName;
	}
	public String getCityCnName() {
		return cityCnName;
	}
	public void setCityCnName(String cityCnName) {
		this.cityCnName = cityCnName;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Date getBaiduMapLng() {
		return baiduMapLng;
	}
	public void setBaiduMapLng(Date baiduMapLng) {
		this.baiduMapLng = baiduMapLng;
	}
	public Date getBaiduMapLat() {
		return baiduMapLat;
	}
	public void setBaiduMapLat(Date baiduMapLat) {
		this.baiduMapLat = baiduMapLat;
	}
	
	
	
}
