package com.metka.result;

import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.metka.enums.ResponseCode;

public class Result<T> {

	@JsonIgnore
	private ResponseCode responseCode;

	private String msg;
	private String cnMsg;
	private Integer code;
	private T data;

	public Result() {
		// TODO Auto-generated constructor stub
	}


	public Result(ResponseCode responseCode, T data) {
		super();
		this.msg=responseCode.getMsg();
		this.cnMsg=responseCode.getCnMsg();
		this.code=responseCode.getCode();
		
		this.data = data;
	}


	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}


	public ResponseCode getResponseCode() {
		return responseCode;
	}


	public void setResponseCode(ResponseCode responseCode) {
		this.cnMsg=responseCode.getCnMsg();
		this.msg=responseCode.getMsg();
		this.code=responseCode.getCode();
	}


	public String getCnMsg() {
		return cnMsg;
	}


	public void setCnMsg(String cnMsg) {
		this.cnMsg = cnMsg;
	}


	@Override
	public String toString() {
		return "Result [msg=" + msg + ", cnMsg=" + cnMsg + ", code=" + code + ", data=" + data + "]";
	}

	
}
