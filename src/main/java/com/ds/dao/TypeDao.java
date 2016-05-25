package com.ds.dao;


import com.ds.domain.Type;

public interface TypeDao extends IDao<Type>{
	
	/**
	 * 通过名字查Type
	 * @param name
	 * @return
	 */
	Type selectByName(String name);
}
