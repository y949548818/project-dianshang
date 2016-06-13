package com.ds.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ds.domain.Post;
import com.ds.domain.ReturnStatus;
import com.ds.domain.User;
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


	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String publish(){
		return "post/publishPost";
	}
	@RequestMapping(value="/show/{post_id}",method=RequestMethod.GET)
	public ModelAndView show(@PathVariable int post_id){
		System.out.println(post_id);
		ModelAndView mav=new ModelAndView("post/show");
		Post post=postService.selectPostById(post_id);
		
		mav.addObject("post", post);
		return mav;
	}
	@RequestMapping(value="/publish",method=RequestMethod.POST)
	public void doPublish(@RequestParam(name="title",required=false,defaultValue="")String title,
			@RequestParam(name="content",required=false,defaultValue="")String content,
			PrintWriter writer,
			HttpSession session
			){
		User user=(User) session.getAttribute("user");
		ReturnStatus status=new ReturnStatus();
		if("".equals(title)||"".equals(content)){
			status.addReason("参数不全");
			status.setResultKey(ReturnStatus.ERROR);
			writer.write(JSON.toJSONString(status));
			return;
		}
		//TODO 这里要添加post的type
		Post post=new Post();
		post.setTitle(title);
		post.setUserId(user.getUserId());
		post.setContent(content);
		post.setType(1);
		System.out.println(post);
		if(postService.publish(post)){
			status.setResultKey(ReturnStatus.SUCCESS);
		}
		else{
			status.setResultKey(ReturnStatus.ERROR);
		}
		writer.write(JSON.toJSONString(status));
		
		System.out.println(content);
		return;
	}



}
