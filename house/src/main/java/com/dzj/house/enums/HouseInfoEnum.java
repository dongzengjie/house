package com.dzj.house.enums;

public enum HouseInfoEnum {
	
	HOUSE_INFO_ERROR(-2001,"房屋信息错误"),
	INSERT_HOUSE_ERROR(-2002,"房屋信息插入失败"),
	HOUSEDETAIL_INFO_ERROR(-2003,"详细信息错误"),
	INSERT_HOUSEDETAIL_INFO_ERROR(-2005,"详细信息插入错误"),
	HOUSEDSUBSCRIBE_INFO_ERROR(-2004,"subscribe信息错误")
	;
	
	private int code;
	private String msg;
	
	

	private HouseInfoEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private HouseInfoEnum(int code) {
		this.code = code;
	}
	
	
}
