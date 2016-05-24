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
import com.ds.service.impl.TypeServiceBean;

@Controller
public class IndexController {

	@Autowired
	PostServiceBean postService;
	@Autowired
	TypeServiceBean typeService;
	@RequestMapping(value = {"/index.do","/index.html","/index","/"},method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(value="page",defaultValue="1",required=false)int pageNo,@RequestParam(value="type",defaultValue="",required=false)String type){
		ModelAndView mav=new ModelAndView("index");
		int pageSize=10;
		//如果type为null,说明是默认的显示类别
		if(type==null||"".equals(type))
		{
			mav.addObject("page",postService.getPosts(pageNo, pageSize));
			mav.addObject("types",typeService.selectAll());
		}
		else{
			
		}
		
		
		
		
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
