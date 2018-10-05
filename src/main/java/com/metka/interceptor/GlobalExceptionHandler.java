/*package com.metka.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.metka.enums.ResponseCode;
import com.metka.result.Result;


*//**
 * 
 * @Title: GlobalExceptionHandler
 * @Package: com.zuipin.framework.exceptionhandler
 * @author: zengxinchao  
 * @date: 2017年3月23日 下午3:25:30
 * @Description: GlobalExceptionHandler
 *//*
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public Result<?> defaultErrorHandler(Exception e) {


		if(e instanceof RuntimeException){
			
			Result result=new Result();
			result.setResponseCode(ResponseCode.EXCEPTION_EROR);
			result.setMsg(e.getMessage());
			return result;
		}

		return null;
	}

}
*/