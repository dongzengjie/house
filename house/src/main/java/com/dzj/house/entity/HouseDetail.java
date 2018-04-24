package com.dzj.house.entity;

public class HouseDetail {
	private long houseDetailId;
	private String description;
	private String layoutDesc;
	private String traffic;
	private String roundService;
	private String rentWay;
	private String address;
	private long subwayId;
	private String subwayName;
	private long subwayStationId;
	private String subwayStationName;
	private long houseId;

	public long getHouseDetailId() {
		return houseDetailId;
	}

	public void setHouseDetailId(long houseDetailId) {
		this.houseDetailId = houseDetailId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLayoutDesc() {
		return layoutDesc;
	}

	public void setLayoutDesc(String layoutDesc) {
		this.layoutDesc = layoutDesc;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public long getSubwayStationId() {
		return subwayStationId;
	}

	public void setSubwayStationId(long subwayStationId) {
		this.subwayStationId = subwayStationId;
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
	
	
	
	
}
