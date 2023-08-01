package com.example.user.customException;

import org.springframework.stereotype.Component;

@Component
public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9154586261719287136L;
	
	private String errorCode;
	private String errorMessage;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public BusinessException() {
		
	}
	

}
