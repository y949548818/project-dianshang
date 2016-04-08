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
		post.setTitle("这是第二22个帖子");
		post.setPostAdmin(2);
		post.setContent("这是内容22");
		int count=postDao.insert(post);
		System.out.println(String.format("修改了%d条记录，post的postId为%d",count,post.getPostId() ));
	}
	/**
	 * 测试update
	 */
	@Test
	public void test2(){
		Post post=new Post();
		post.setPostId(1);
		post.setTitle("这是修改后的帖子2");
		post.setContent("这是修改后的内容");
		int count=postDao.update(post.getPostId(), post);
		System.out.println(String.format("修改了%d条记录，post的postId为%d",count,post.getPostId() ));
		System.out.println(post);
	}
	/**
	 * 测试delete
	 */
	@Test
	public void test3(){
		
	
		int count=postDao.delete(1);
		if(count>0)
		System.out.println("删除成功");
	}
	
}
