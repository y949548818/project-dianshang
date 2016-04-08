package com.qh.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dao.PostDao;
import com.ds.domain.Post;



@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class PostTest {

	@Autowired
	PostDao postDao;
	
	/**
	 * 测试Insert
	 */
	@Test
	public void test1(){
		Post post=new Post();
		post.setTitle("这是第二个帖子");
		post.setPostAdmin(1);
		post.setContent("这是内容");
		postDao.insert(post);
		
	}
	
}
