package com.ds.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ds.dao.UserDao;
import com.ds.domain.User;

@Controller
public class IndexController {
//	@RequestMapping(value={"/","/abc","/index.jsp"},method=RequestMethod.GET)
	@RequestMapping(value = "/index.do")
	public String index(){
		System.out.println("index have a connection");
		return "index";
	}
	@Autowired
	UserDao userDao;
	@ResponseBody
	@RequestMapping("/json")
	public String json(){
//		System.out.println("json have a connection");
		List<User>users=new ArrayList<User>();
		users.add(new User(1, "admin","1.1.1.1", 16));
		users.add(new User(2, "admin2", "1.1.1.1",16));
		
		return JSON.toJSONString(users);
	}
	@ResponseBody
	@RequestMapping("/alluser")
	public String alluser(){
		System.out.println(userDao.selectAll().toString());
		return userDao.selectAll().toString();
	}

	
}
