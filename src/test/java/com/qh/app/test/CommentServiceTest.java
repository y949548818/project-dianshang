package com.qh.app.test;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.domain.Comment;
import com.ds.service.CommentInfoService;
import com.ds.service.CommentPublishService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml")
public class CommentServiceTest {
	
	@Autowired
	CommentPublishService commentPublishService;
	
	@Autowired
	CommentInfoService commentInfoService;
	
	/*
	 * ���Է�������
	 */
	@Test
	public void test1(){
		Comment comment=new Comment();
		comment.setContent("publish测试");
		comment.setDate(new Date(new java.util.Date().getTime()));
		comment.setPostId(1);
		comment.setUserId(1);
		commentPublishService.Publish(comment);
	}

}
