package com.dzj.house.entity;

import java.util.List;

public class Subway {

	private long subwayId;
	private String subwayName;
	private String cityEnName;
	private List<SubwayStation> subwayStationList;
	
	 
	
	public List<SubwayStation> getSubwayStationList() {
		return subwayStationList;
	}
	public void setSubwayStationList(List<SubwayStation> subwayStationList) {
		this.subwayStationList = subwayStationList;
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
	public String getCityEnName() {
		return cityEnName;
	}
	public void setCityEnName(String cityEnName) {
		this.cityEnName = cityEnName;
	}
	
	
}
