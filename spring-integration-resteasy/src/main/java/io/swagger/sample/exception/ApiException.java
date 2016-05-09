package io.swagger.sample.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		this.code = code;
		logger.info("code:{},msg:{}",this.code,msg);
	}
}
