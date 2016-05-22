package com.ds.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ds.dao.UserDao;
import com.ds.domain.Page;
import com.ds.domain.Post;
import com.ds.domain.User;
import com.ds.service.impl.PostServiceBean;

@Controller
public class IndexController {

	@Autowired
	PostServiceBean postService;
	@RequestMapping(value = {"/index.do","/index.html","/index","/"},method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="page",defaultValue="1",required=false)int pageNo){
		ModelAndView mav=new ModelAndView("index");
		int pageSize=10;
		Page<Post> page=postService.getPosts(pageNo, pageSize);
		System.out.println(page);
		mav.addObject("page",page);
		return mav;
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
