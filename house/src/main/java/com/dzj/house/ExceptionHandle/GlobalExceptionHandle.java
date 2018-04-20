package com.dzj.house.ExceptionHandle;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import com.dzj.house.response.ResponseResult;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandle {

	private static final Logger log= LoggerFactory.getLogger(GlobalExceptionHandle.class);
	
	@ExceptionHandler(value=Exception.class)
	public ResponseResult<String> handleException(HttpServletRequest request,Exception e) {
		
		
		return null;
		
	}
}
