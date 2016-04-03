package com.qh.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class MyTest {

	@Autowired
	UserDao userDao;
	/**
	 * 测试UserDaoBean
	 */
	@Test
	public void test(){
		System.out.println(userDao.selectAll());
	}
}
