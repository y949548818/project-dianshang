package com.ds.exception;

import javax.servlet.ServletException;

/**
 * 用户未登录
 * @author qq245521957
 *
 */
public class UnloginException extends ServletException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "用户未登录";
	}

}
