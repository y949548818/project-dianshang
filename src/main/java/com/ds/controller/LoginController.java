package com.ds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ds.domain.User;

@Controller
public class LoginController {

	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String doLogin(User user){
		System.out.println(user);
		return "login";
	}
}
