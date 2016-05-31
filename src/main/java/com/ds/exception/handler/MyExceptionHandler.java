package com.ds.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.ds.exception.UnknowTypeException;
import com.ds.exception.UnloginException;

public class MyExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if(ex instanceof UnloginException){
			return handleUnlogin((UnloginException) ex, request,
					response, handler);
		}
		else if(ex instanceof UnknowTypeException){
			return handleUnknownType((UnknowTypeException) ex, request,
					response, handler);
		}
		
		return null;
	}
	/**
	 * 用来处理对于未登录情况的异常
	 * @param ex
	 * @param request
	 * @param response
	 * @param handle
	 * @return
	 */
	public ModelAndView handleUnlogin(UnloginException ex,
			HttpServletRequest request, HttpServletResponse response, Object handle){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/user/login");
		return mav;
	}
	/**
	 * 用户处理对用户访问了没有的type时做出的处理
	 * @param ex
	 * @param request
	 * @param response
	 * @param handle
	 * @return
	 */
	public ModelAndView handleUnknownType(UnknowTypeException ex,
			HttpServletRequest request, HttpServletResponse response, Object handle){
		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:/exception/404");
		return mav;
	}

}
