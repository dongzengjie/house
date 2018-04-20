package com.dzj.house.enums;

public enum ResultEnum {

	SUCCESS(1,"成功"),ERROR(-1,"失败"),UPLOAD_FAIL(-2,"图片上传失败");
	
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
	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public static ResultEnum stateof(int code) {
		for (ResultEnum resultEnum : values()) {
			if(resultEnum.getCode() == code) {
				return resultEnum;
			}
		}
		return null;
	}
	
}
