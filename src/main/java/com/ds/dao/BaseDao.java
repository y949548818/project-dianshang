package com.ds.dao;

import java.util.List;

import com.ds.domain.User;

/**
 * Dao的基础接口
 * @author hgg
 *
 */
public interface BaseDao<T> {

	/**
	 * 根据指定的Id查照记录
	 * 
	 * @param userId
	 *            要查找的id
	 * @return 存在时返回一个对象，不存在时返回null
	 */
	T selectById(int userId);
	
	/**
	 * 查询所有
	 * 
	 * @return 所有的列表，按id升序排序
	 */
	List<T> selectAll();
	
	/**
	 * 插入指定的记录，插入完成后，要在对象中填上Id属性
	 * 
	 * @param obj
	 *            要插入的对象。插入成功会在数据库插入相应的值
	 * @return 影响的行数
	 */
	int insert(T obj);
	
	/**
	 * 修改指定的记录
	 * 
	 * @param id
	 *            根据此id来进行匹配
	 * @param obj
	 *            要更新的值
	 * @return 影响的行数
	 */
	int update(int id, T obj);
	
	/**
	 * 删除指定的记录
	 * 
	 * @param id
	 *            根据此id来进行匹配
	 * @return 影响的行数
	 */
	int delete(int id);
}
