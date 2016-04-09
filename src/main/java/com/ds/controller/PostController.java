package com.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ds.domain.Post;
import com.ds.domain.ReturnStatus;
import com.ds.service.impl.PostServiceBean;

/**
 * 这个控制器主要负责Post对象的操作
 * @author qq245521957
 *
 */
@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostServiceBean postService;
	
	
//	@RequestMapping("/publish")
//	public String publish(){
//		return "publish";
//	}
	
	@ResponseBody
	@RequestMapping(value="/publish",method=RequestMethod.GET)
	public String publish( String title,int postAdmin,String content){
		Post post=new Post();
		ReturnStatus status=new ReturnStatus();
		post.setTitle(title);
		post.setPostAdmin(postAdmin);
		post.setContent(content);
		if(postService.publish(post)){
			status.setResultKey(ReturnStatus.SUCCESS);
		}
		else{
			status.setResultKey(ReturnStatus.ERROR);
		}
		
		return JSON.toJSONString(status);
	}
	
	
	
}
