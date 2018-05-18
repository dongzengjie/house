package com.dzj.house.elasticSearch;

import java.util.List;

public class EsResponse {

	private int total;
	private List<Long> houseIds;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<Long> getHouseIds() {
		return houseIds;
	}
	public void setHouseId(List<Long> houseId) {
		this.houseIds = houseId;
	}
	
	
}
