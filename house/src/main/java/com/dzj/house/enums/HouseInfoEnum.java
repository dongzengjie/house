package com.dzj.house.enums;

public enum HouseInfoEnum {
	
	HOUSE_INFO_ERROR(-2001,"房屋信息错误"),
	INSERT_HOUSE_ERROR(-2002,"房屋信息插入失败"),
	HOUSEDETAIL_INFO_ERROR(-2003,"详细信息错误"),
	INSERT_HOUSEDETAIL_INFO_ERROR(-2005,"详细信息插入错误"),
	HOUSEDSUBSCRIBE_INFO_ERROR(-2004,"subscribe信息错误"),
	HOUSE_PAGING_ERROR(-2006,"分页信息错误"),
	HOUSE_SERACH_ERROR(-2007,"房屋查询出错"),
	HOUSE_ADD_PICTUR_ERROR(-2008,"添加图片失败"),
	HOUSE_UPDATE_ERROR(-1311,"更新失败"),
	HOUSE_ID_NULL(-1312,"房屋ID为空")
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
