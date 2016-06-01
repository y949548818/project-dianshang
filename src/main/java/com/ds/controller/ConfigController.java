package com.ds.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.baidu.ueditor.ActionEnter;

@RequestMapping("/config")
@Controller
public class ConfigController {

	@RequestMapping(value="/ueditor")
	public void config(PrintWriter out,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		System.out.println("have a connection");
		request.setCharacterEncoding( "utf-8" );
		System.out.println("requestURI"+request.getRequestURI());
		response.setHeader("Content-Type" , "text/html");
		String rootPath = request.getSession().getServletContext().getRealPath( "/" );
		System.out.println(rootPath);
		out.write( new ActionEnter( request, rootPath ).exec() );
	}
}
