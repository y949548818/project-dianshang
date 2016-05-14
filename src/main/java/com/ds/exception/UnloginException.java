package com.ds.exception;

import javax.servlet.ServletException;

public class UnloginException extends ServletException{

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "用户未登录";
	}

}
