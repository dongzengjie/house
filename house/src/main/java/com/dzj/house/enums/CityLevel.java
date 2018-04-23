package com.dzj.house.enums;

public enum CityLevel {
	CITY("city"),REGION("region");
	private String level;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	private CityLevel(String level) {
		this.level = level;
	}
	
	
	
}
