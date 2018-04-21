package com.dzj.house.Exception;

import com.dzj.house.enums.LoginEnum;

public class LoginException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code ;

	
	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public LoginException(String message) {
		super(message);
		
	}
	
	public LoginException(LoginEnum loginEnum) {
		super(loginEnum.getMsg());
		this.code=loginEnum.getCode();
		
	}

}
