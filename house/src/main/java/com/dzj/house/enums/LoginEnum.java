package com.dzj.house.enums;

public enum LoginEnum {

	USER_NULL(-1002,"用户不存在"),PASSWORD_ERROR(-1003,"密码错误"),SECURITY_ILLEGAL(-1004,"权限非法");
	
	private int code;
	private String msg;
	
	

	private LoginEnum(int code, String msg) {
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

	private LoginEnum(int code) {
		this.code = code;
	}
	
	
	
}
