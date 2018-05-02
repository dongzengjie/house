package com.dzj.house.enums;

public enum RedisOverTime {
	
	OneDay(60*60*24);
	private int overTime;

	public int getOverTime() {
		return overTime;
	}

	public void setOverTime(int overTime) {
		this.overTime = overTime;
	}

	private RedisOverTime(int overTime) {
		this.overTime = overTime;
	}
	
	
	
}
