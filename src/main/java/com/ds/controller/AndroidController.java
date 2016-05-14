package com.ds.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ds.domain.ReturnStatus;
import com.ds.domain.User;
import com.ds.service.impl.UserServiceBean;

/**
 * 用来给android客户端使用的controller
 * @author qq245521957
 *
 */
@Controller
@RequestMapping("/android")
public class AndroidController {
	
	@Autowired
	UserServiceBean userService;
	
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public void doLogin(@Valid @ModelAttribute("user") User user,
			BindingResult result,
			PrintWriter writer,
			HttpSession session){
		System.out.println(user);
		ReturnStatus rs=new ReturnStatus();
		if(result.getErrorCount()>0){
			rs.setResultKey(ReturnStatus.ERROR);
			for(ObjectError error:result.getAllErrors()){
				rs.addReason(error.getDefaultMessage());
			}
			writer.write(JSON.toJSONString(rs));
			System.out.println(JSON.toJSONString(rs));
			return ;
		}
		User res=userService.getUserByUserName(user.getUsername());
		if(res!=null&&res.getPassword().equals(user.getPassword())){
			session.setAttribute("user", res);
			rs.setResultKey(ReturnStatus.SUCCESS);
			rs.addReason("登录成功");
			//TODO 需要再往login表里写入此用户登录了
		}
		else{
			rs.setResultKey(ReturnStatus.ERROR);
			rs.addReason("用户名或密码错误");
		}
		writer.write(JSON.toJSONString(rs));

	}
}
