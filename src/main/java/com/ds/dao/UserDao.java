package com.ds.dao;

import java.util.List;

import com.ds.domain.User;

public interface UserDao extends BaseDao<User> {


	/**
	 * 根据指定的userName查照记录
	 * 
	 * @param userName
	 *            要查找的用户名
	 * @return 存在时返回一个对象，不存在时返回null
	 */
	User selectByUserName(String userName);

}
