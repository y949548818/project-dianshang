package com.ds.controller;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.ds.domain.Bullet;
import com.ds.service.impl.BulletService;

@Controller
@RequestMapping("/video")
public class VideoController {

	@Autowired
	BulletService bulletService;

	@RequestMapping(value={"/",""})
	public String  index(){
		return "video/index";
	}
	@RequestMapping(value="/getbullet/{videoId}")
	public void getBullet(@PathVariable int videoId,
			@RequestParam(value="startTime",defaultValue="0",required=false)int startTime,
			/* 0表示全部*/
			@RequestParam(value="amount",defaultValue="100",required=false)int amount,
			PrintWriter out){
		List<Bullet> bullets=bulletService.getSomeBulletsByVideoIdAndTime(videoId, startTime, amount);
		
		out.print(JSON.toJSONString(bullets));
	}


}
