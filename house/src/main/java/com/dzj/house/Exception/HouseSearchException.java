package com.dzj.house.Exception;

import com.dzj.house.enums.HouseSearchEnum;

public class HouseSearchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int code;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public HouseSearchException(HouseSearchEnum enum1) {
		super(enum1.getMsg());
		this.code = enum1.getCode();
	}
	
	

}
