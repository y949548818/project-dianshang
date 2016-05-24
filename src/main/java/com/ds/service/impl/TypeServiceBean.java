package com.ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ds.dao.PostDao;
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
		// TODO Auto-generated method stub
		return typeDao.selectAll();
	}

}
