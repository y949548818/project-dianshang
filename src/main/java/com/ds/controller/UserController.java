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
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public String register(@ModelAttribute("user") User user){
		return "user/regist";
	}
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			HttpSession session){
		if(result.getErrorCount()>0){
			return "user/regist";
		}
		User res=userService.getUserByUserName(user.getUsername());
		if(res!=null){
			result.addError(new ObjectError("user", "用户名重复"));
			return "user/regist";
		}
		else{
			userService.register(user);
			session.setAttribute("user", user);
			//TODO 需要再往login表里写入此用户登录了
			return "redirect:/index";
		}
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
			return "redirect:/index";
		}
		else{
			result.addError(new ObjectError("user", "用户名或密码错误"));
			return "user/login";
		}

	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.setAttribute("user",null);
		return "redirect:/index";
	}
}
