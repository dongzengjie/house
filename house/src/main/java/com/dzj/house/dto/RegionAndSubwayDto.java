package com.dzj.house.dto;

import java.util.List;

import com.dzj.house.entity.Subway;
import com.dzj.house.entity.SupportAddress;

public class RegionAndSubwayDto {
	private List<Subway> subwayList;
	private List<SupportAddress> supportAddresseList;
	public List<Subway> getSubwayList() {
		return subwayList;
	}
	public void setSubwayList(List<Subway> subwayList) {
		this.subwayList = subwayList;
	}
	public List<SupportAddress> getSupportAddresseList() {
		return supportAddresseList;
	}
	public void setSupportAddresseList(List<SupportAddress> supportAddresseList) {
		this.supportAddresseList = supportAddresseList;
	}
	
	
}
