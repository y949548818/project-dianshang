package com.ds.dao;

import java.util.List;

import com.ds.domain.User;

public interface UserDao {
	/**
	 * 根据指定的userId查照记录
	 * 
	 * @param userId
	 *            要查找的用户的id
	 * @return 存在时返回一个对象，不存在时返回null
	 */
	User selectByUserId(int userId);

	/**
	 * 根据指定的userName查照记录
	 * 
	 * @param userName
	 *            要查找的用户名
	 * @return 存在时返回一个对象，不存在时返回null
	 */
	User selectByUserName(String userName);

	/**
	 * 查询所有用户
	 * 
	 * @return 所有用户的列表，按id升序排序
	 */
	List<User> selectAllUsers();

	/**
	 * 插入指定的用户，插入完成后，要在user对象中填上userId属性
	 * 
	 * @param user
	 *            要插入的用户，userId会在插入成功后更新成数据库中对应的值
	 * @return 影响的行数
	 */
	int insert(User user);

	/**
	 * 修改指定的用户
	 * 
	 * @param userId
	 *            根据此id来进行匹配
	 * @param user
	 *            要更新的值
	 * @return 影响的行数
	 */
	int update(int userId, User user);

	/**
	 * 删除指定的用户
	 * 
	 * @param userId
	 *            根据此id来进行匹配
	 * @return 影响的行数
	 */
	int delete(int userId);
}
