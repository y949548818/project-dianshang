package com.qh.app.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.domain.Post;
import com.ds.service.PostInfoService;
import com.ds.service.PostPublishService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class PostServiceTest {
	
	@Autowired
	PostPublishService postPublishService;
	
	@Autowired
	PostInfoService postInfoService;
	
	/**
	 * 测试发布帖子
	 */
	@Test
	public void test1(){
		Post post=new Post();
		post.setTitle("标题");
		post.setUserId(1);
		post.setContent("内容");
		postPublishService.publish(post);
	}
}
