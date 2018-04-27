package com.dzj.house.dto;

import java.util.List;

public class HouseResponseDto {

	private int count;
	private List<HouseListDto> houseListDtoList;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<HouseListDto> getHouseListDtoList() {
		return houseListDtoList;
	}
	public void setHouseListDtoList(List<HouseListDto> houseListDtoList) {
		this.houseListDtoList = houseListDtoList;
	}
	
	
}
