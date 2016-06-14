package com.ds.controller;

import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/video")
public class VideoController {
	
	@RequestMapping(value={"/",""})
	public String  index(){
		return "video/index";
	}
	@RequestMapping(value="/getbullet/{videoId}")
	public void getBullet(@PathVariable int videoId,PrintWriter out){
		out.print("一二三四");
	}

	
}
