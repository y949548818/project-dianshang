package com.ds.service;

import com.ds.domain.Page;
import com.ds.domain.User;

/**
 * 暂时先用做用户的个人信息服务接口
 * @author qq245521957
 *
 */
public interface UserInfoService {
	/**
	 * 根据用户查询用户
	 * 
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String userName);

	/**
	 * 根据用户ID查询用户
	 * 
	 * @param userId
	 * @return
	 */
	User getUserByUserId(int userId);

	/**
	 * 分页查询所有用户
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<User> getUsers(int pageNo, int pageSize);
}
