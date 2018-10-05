package com.metka.enums;

public enum ResponseCode {

	SUCCESS(0, "success", "成功"),
	EXCEPTION_EROR(1,"exception error","出现异常");
	private ResponseCode(int code, String msg, String cnMsg) {
		this.code = code;
		this.cnMsg = cnMsg;
		this.msg = msg;
	}

	private String msg;
	private String cnMsg;

	public String getCnMsg() {
		return cnMsg;
	}

	public void setCnMsg(String cnMsg) {
		this.cnMsg = cnMsg;
	}

	private int code;

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

}
