package com.dzj.house.dto;

import java.util.List;

public class HouseSearchDto {

	private List<FrontHouseListDto> frontHouseListDtoList;
	private int total;
	private String cityCnName;
	
	public String getCityCnName() {
		return cityCnName;
	}
	public void setCityCnName(String cityCnName) {
		this.cityCnName = cityCnName;
	}
	public List<FrontHouseListDto> getFrontHouseListDtoList() {
		return frontHouseListDtoList;
	}
	public void setFrontHouseListDtoList(List<FrontHouseListDto> frontHouseListDtoList) {
		this.frontHouseListDtoList = frontHouseListDtoList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
