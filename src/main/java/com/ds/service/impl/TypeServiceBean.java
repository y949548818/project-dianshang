package com.ds.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.dao.TypeDao;
import com.ds.domain.Type;
import com.ds.service.TypeSelectService;

/**
 * 这个类是用来作为type的服务类
 * @author qq245521957
 *
 */
public class TypeServiceBean implements TypeSelectService {
	
	@Autowired
	TypeDao typeDao;
	
	@Override
	public List<Type> selectAll() {
		return typeDao.selectAll();
	}

	@Override
	public Map<Integer, String> selectAllForMap() {
		List<Type>types =typeDao.selectAll();
		Map<Integer, String>typeMap=new HashMap<>();
		for(Type type:types){
			typeMap.put(type.getTypeId(),type.getName());
		}
		return typeMap;
	}

}
