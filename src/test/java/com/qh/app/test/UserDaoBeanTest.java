package com.qh.app.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.ds.dao.CommentDao;
import com.ds.dao.UserDao;
import com.ds.domain.Page;
import com.ds.domain.User;
import com.ds.service.UserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class UserDaoBeanTest {

	@Autowired
	UserDao userDao;
	/**
	 * 测试UserDaoBean
	 */
	@Test
	public void test(){
		System.out.println(userDao.selectAll());
	}
	
	@Autowired
	UserInfoService userInfoService;
	/**
	 * 测试UserServiceBean
	 */
	@Test
	public void test2(){
		User user=userInfoService.getUserByUserId(2);
//		User user=userDao.selectById(1);
		System.out.println(user);
	}
	@Test
	public void test3(){
		try{
			
			Assert.isNull("123", "不是null");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	@Autowired
	CommentDao commentdao;
	/**
	 * 测试CommentDaoBean
	 */
	@Test
	public void test101(){
		System.out.println(commentdao.selectById(1).getContent());
	}
	@Test
	public void test111(){
		Date date=new Date();
		System.out.println(date.getTime());
		Timestamp time=new Timestamp(date.getTime());
		System.out.println(time);
	}
	/**
	 * 测试分页查询
	 */
	@Test
	public void test6(){
		Page<User> page=userDao.page(1, 10);
		System.out.println(page.getResult());
	}
	/**
	 * 测试selectByName
	 */
	@Test
	public void test7(){
		User user=userDao.selectByUserName("admin");
		System.out.println(user);
	}
	/**
	 * 测试insert
	 */
	@Test
	public void test8(){
		User user=new User();
		user.setHeaderPath("/123.jpg");
		user.setLastIp("127.0.0.1");
		user.setLastTime(new Timestamp(new Date().getTime()));
		user.setPassword("admin2");
		user.setUsername("admin2");
		userDao.insert(user);
		System.out.println(user);
	}
	/**
	 * 测试update
	 */
	@Test
	public void test9(){
		User user=userDao.selectByUserName("admin2");
		user.setPassword("admin3");
		userDao.update(user.getUserId(), user);
		System.out.println(user);
	}
	/**
	 * 测试delete
	 */
	@Test
	public void test10(){

		userDao.delete(3);
	}
}
