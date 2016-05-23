package com.ds.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ds.domain.User;
import com.ds.service.impl.UserServiceBean;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceBean userService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(@ModelAttribute("user") User user){
		return "user/login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			HttpSession session){
		
		if(result.getErrorCount()>0){
			return "user/login";
		}
		User res=userService.getUserByUserName(user.getUsername());
		if(res!=null&&res.getPassword().equals(user.getPassword())){
			session.setAttribute("user", res);
			//TODO 需要再往login表里写入此用户登录了
			return "redirect:/static/image/1.jpg";
		}
		else{
			result.addError(new ObjectError("login", "用户名或密码错误"));
			return "user/login";
		}

	}
}