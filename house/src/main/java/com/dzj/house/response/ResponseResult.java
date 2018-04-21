package com.dzj.house.response;

import com.dzj.house.enums.ResultEnum;

public class ResponseResult<T> {

	private T data;
	private int code;
	private String msg;
	

	public ResponseResult(T data, ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
		this.data = data;
		
	}
	
	public ResponseResult(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
	}
	
	public ResponseResult(String msg,int code) {
		this.code = code;
		this.msg = msg;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
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
	
	
	
}
