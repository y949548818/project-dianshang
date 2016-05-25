package com.ds.exception;

import javax.servlet.ServletException;

/**
 * 没有这种类别的post
 * @author qq245521957
 *
 */
public class UnknowTypeException extends ServletException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Override
	public String getMessage() {
		return "没有相关的类别";
	}

}
