package com.ds.service;

import com.ds.domain.User;

/**
 * 用户注册的接口
 * @author qq245521957
 *
 */
public interface UserRegisterService {

	/**
	 * 用户注册
	 * 调用时必须要填充 userName，password，lastVisit，lastIp字段
	 * @param user
	 */
	void register(User user);

	/**
	 * 检查下用户名是否可用
	 * @param userName
	 * @return
	 */
	boolean isUserNameAvailable(String userName);
}
