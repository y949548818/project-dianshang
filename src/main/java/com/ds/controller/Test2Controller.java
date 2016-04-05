package com.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.domain.User;
import com.ds.service.UserInfoService;


/**
 * 这个类是用来测试接口的
 * @author asus
 *
 */
@Controller
public class Test2Controller {

	@Autowired
	UserInfoService userInfoService;
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		
		return "this is test";
	}
	
	@ResponseBody
	@RequestMapping(value="/userinfo",method=RequestMethod.GET)
	public String userinfo(){
		
		User user=userInfoService.getUserByUserId(1);
		return user.toString();
	}
	public void t(){
		//zhushi12344
	}
}
