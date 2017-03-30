/**
 * Copyright (C) 2013-2014 the original author or authors.
 */
package com.seventeenkouer.common.Exception;
/**
 * @description
 *
 * @author zhou jun
 * @version v1.0
 *
 * @2013-8-9
 *
 */
@SuppressWarnings("rawtypes")
public class BaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1857785405765521004L;

	private String code;
	
	private String message;
	
	private Class clazz;
	
	public BaseException(Class clazz, String code, String message) {
		super(message);
		this.clazz = clazz;
		this.code = code;
		this.message = message;
    }

    public BaseException(Class clazz, String code, String message, Throwable cause) {
        super(message, cause);
		this.clazz = clazz;
		this.code = code;
		this.message = message;
    }

    public BaseException(Class clazz, String code, Throwable cause) {
        super(cause);
		this.code = code;
		this.clazz = clazz;
    }
	    
	public String getCode() {
		StringBuffer sb = new StringBuffer();
		if(this instanceof BusinessException){
			sb.append("B");
		} else {
			sb.append("A");
		}
		
		String codeFormat = ExceptionCodeFormat.getCode(clazz);
		if(codeFormat != null){
			sb.append(codeFormat);
		} else {
			sb.append("00000");
		}
		
		if(code != null){
			sb.append(code);
		} else {
			sb.append("0000");
		}
		return sb.toString();
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message != null? message:getLocalizedMessage();
	}

}
