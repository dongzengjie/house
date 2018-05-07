package com.dzj.house.enums;

public enum HouseSearchEnum {
	HOUSE_SEARCH_ERROR(-1234,"查询失败");
	
	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private HouseSearchEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
}
