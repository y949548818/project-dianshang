package com.ds.service;

import java.util.List;
import java.util.Map;

import com.ds.domain.Type;

public interface TypeSelectService {

	List<Type> selectAll();
	/**
	 * 按照map的形式查找所有的type
	 * @return
	 */
	Map<Integer,String> selectAllForMap();
}
