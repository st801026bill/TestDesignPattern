package com.bill.dp.common.exception;

public enum ErrorType {

	SUCCESS("0000"),  //執行成功
	UNKNOW_ERROR("9999");  //未知錯誤
	
	private String code;
	private String message;
	
	
	ErrorType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getMessage() {
		return this.code;
	}
}
