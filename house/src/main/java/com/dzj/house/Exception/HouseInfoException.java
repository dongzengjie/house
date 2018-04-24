package com.dzj.house.Exception;

import com.dzj.house.enums.HouseInfoEnum;

public class HouseInfoException extends RuntimeException{

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

	public HouseInfoException(String message) {
		super(message);
		
	}
	
	public HouseInfoException(HouseInfoEnum houseEnum) {
		super(houseEnum.getMsg());
		this.code=houseEnum.getCode();
	}

}
