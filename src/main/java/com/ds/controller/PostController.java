package com.ds.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
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


	@RequestMapping(value="/publish",method=RequestMethod.GET)
	public String publish(){
		return "publishPost";
	}
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	public void doPublish(@RequestParam(name="title",required=false,defaultValue="")String title,
			@RequestParam(name="postAdmin",required=false,defaultValue="-1")int postAdmin,
			@RequestParam(name="content",required=false,defaultValue="")String content,
			PrintWriter writer){

		ReturnStatus status=new ReturnStatus();
		//		System.out.println("title:" + title);
		//		System.out.println("postAdmin:" + postAdmin);
		//		System.out.println("content:" + content);
		if("".equals(title)||postAdmin==-1||"".equals(content)){
			status.addReason("参数不全");
			status.setResultKey(ReturnStatus.ERROR);
			writer.write(JSON.toJSONString(status));
			return;
		}
		Post post=new Post();
		post.setTitle(title);
		post.setPostAdmin(postAdmin);
		post.setContent(content);
		if(postService.publish(post)){
			status.setResultKey(ReturnStatus.SUCCESS);
		}
		else{
			status.setResultKey(ReturnStatus.ERROR);
		}
		//		writer.print(JSON.toJSONString(status));
		writer.write(JSON.toJSONString(status));
		return;
	}



}
