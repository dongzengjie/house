package com.dzj.house.response;

import com.dzj.house.enums.ResultEnum;

public class ResponseResult<T> {

	private T result;
	private int code;
	private String msg;
	

	public ResponseResult(T result, ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
		this.result = result;
		
	}
	
	public ResponseResult(ResultEnum resultEnum) {
		this.code = resultEnum.getCode();
		this.msg = resultEnum.getMsg();
	}
	
	public ResponseResult(String msg,int code) {
		this.code = code;
		this.msg = msg;
	}
	
	
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
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
