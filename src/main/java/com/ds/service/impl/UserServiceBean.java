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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isUserNameAvailable(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasMatchUser(String userName, String password) {
		// TODO Auto-generated method stub
		User user=userDao.selectByUserName(userName);
		return user!=null&&user.getPassword().equals(password);
	}

	@Override
	public int loginSccess(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectById(userId);
	}

	@Override
	public Page<User> getUsers(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
