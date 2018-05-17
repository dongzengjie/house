package com.dzj.house.enums;

public enum HouseStatusEnum {
	CHECK(-2),PASS(1),UNDER(0),UNQUALIFIED(-1);
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private HouseStatusEnum(int code) {
		this.code = code;
	}
	
	
}
