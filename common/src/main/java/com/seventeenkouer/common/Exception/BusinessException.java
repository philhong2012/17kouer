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
public class BusinessException extends BaseException {

	private static final long serialVersionUID = -7708751067684751046L;

	/**
	 * @param clazz
	 * @param message
	 */
	public BusinessException(Class clazz, String code, String message) {
		super(clazz, code, message);
	}

	/**
	 * @param clazz
	 * @param message
	 * @param cause
	 */
	public BusinessException(Class clazz, String code, String message, Throwable cause) {
		super(clazz, code, message, cause);
	}

	/**
	 * @param clazz
	 * @param cause
	 */
	public BusinessException(Class clazz, String code, Throwable cause) {
		super(clazz, code, cause);
	}
	

}
