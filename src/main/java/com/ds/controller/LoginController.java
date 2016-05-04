package com.ds.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ds.dao.UserDao;
import com.ds.domain.User;

@Controller
public class LoginController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public ModelAndView doLogin(@Valid User user,BindingResult result,HttpSession session){
		ModelAndView mav=new ModelAndView();
		List<ObjectError> lists=result.getAllErrors();
		
		List<String>errors=new ArrayList<>();
		for(ObjectError error:lists){
			System.out.println(error.getDefaultMessage());
			errors.add(error.getDefaultMessage());
		}
		if(errors.size()>0){
			mav.addObject("error", errors);
			mav.setViewName("login");
			return mav;
		}
		User res=userDao.selectByUserName(user.getUsername());
		if(res!=null&&res.getPassword().equals(user.getPassword())){
			session.setAttribute("user", res);
			//TODO 需要再往login表里写入此用户登录了
			mav.setViewName("redirect:/static/image/1.jpg");
			return mav;
		}
		else{
			errors.add("用户名或密码错误");
			mav.addObject("error", errors);
			mav.setViewName("login");
			return mav;
		}

	}
}
