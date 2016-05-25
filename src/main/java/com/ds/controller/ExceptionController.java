package com.ds.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exception")
public class ExceptionController {

	@RequestMapping("/404")
	public String exceptionOf404(){
		return "exception/404";
	}
}
