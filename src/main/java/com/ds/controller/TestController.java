package com.ds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 这个类是用来测试接口的
 * @author asus
 *
 */
@Controller
public class TestController {

	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		
		return "this is test";
	}
	
}
