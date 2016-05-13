package com.ds.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ds.domain.User;
import com.ds.service.UserInfoService;


/**
 * 这个类是用来测试接口的
 * @author asus
 *
 */
@Controller
@RequestMapping(value="/demo")
public class DemoController {

	@Autowired
	UserInfoService userInfoService;
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		
		return "this is test";
	}
	
	@RequestMapping(value="/login")
	public void doLogin(PrintWriter writer,HttpSession session,String username,String password){
		if("admin".equals(username)&&"admin".equals(password)){
			session.setAttribute("user", "admin");
			writer.write("success");
			
		}
		else{
			writer.write("error");
		}
	}
	@RequestMapping(value="/home")
	public void doHome(PrintWriter writer,HttpSession session){
		String user=(String) session.getAttribute("user");
		System.out.println(user);
		if(user!=null&&!("".equals(user))){
			writer.write("welcome "+user);
		}
		else{
			writer.write("please login");
		}
	}
	
	@RequestMapping(value="/chinese",method=RequestMethod.GET)
	public void chinese(PrintWriter writer) throws IOException{
//			request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write("这是中文");
		writer.write("这是中文");
//		try {
//			return new String("这是中文".getBytes("ISO-8859-1"),"ISO-8859-1");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "error";
	}
	
	@ResponseBody
	@RequestMapping(value="/userinfo",method=RequestMethod.GET)
	public String userinfo(){
		
		User user=userInfoService.getUserByUserId(1);
		return user.toString();
	}
	public void t(){
		//zhushi12344
	}
}
