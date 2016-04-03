package com.ds.service;

import com.ds.domain.User;

/**
 * 用户登录的接口
 * @author qq245521957
 *
 */
public interface UserLoginService {
	/**
	 * 检查是否有匹配的用户
	 * @param userName 用户名
	 * @param password 密码
	 * @return 是否有匹配的用户
	 */
	boolean hasMatchUser(String userName, String password);

	/**
	 * 通过用户名查找用户
	 * @param userName 用户名
	 * @return 用户对象
	 */
	User getUserByUserName(String userName);

	/**
	 * 登录是否成功
	 * @param user 用户对象
	 */
	int loginSccess(User user);
}
