package com.ds.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.dao.UserDao;
import com.ds.domain.Page;
import com.ds.domain.User;
import com.ds.service.UserInfoService;
import com.ds.service.UserLoginService;
import com.ds.service.UserRegisterService;

/**
 * 用户服务的实现类
 * @author asus
 *
 */
public class UserServiceBean  implements UserInfoService,UserLoginService,UserRegisterService{

	@Autowired
	UserDao userDao;
	
	@Override
	public void register(User user) {
		//TODO 用户注册功能
		userDao.insert(user);
	}

	@Override
	public boolean isUserNameAvailable(String userName) {
		//TODO 用户名是否重复
		return false;
	}

	@Override
	public boolean hasMatchUser(String userName, String password) {
		User user=userDao.selectByUserName(userName);
		return user!=null&&user.getPassword().equals(password);
	}

	@Override
	public int loginSccess(User user) {
		//TODO 是否登录成功
		return 0;
	}

	@Override
	public User getUserByUserName(String userName) {
		return userDao.selectByUserName(userName);
	}

	@Override
	public User getUserByUserId(int userId) {
		return userDao.selectById(userId);
	}

	@Override
	public Page<User> getUsers(int pageNo, int pageSize) {
		//获取用户列表
		return null;
	}

}
