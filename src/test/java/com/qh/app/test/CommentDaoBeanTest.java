package com.qh.app.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dao.CommentDao;
import com.ds.domain.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml")
public class CommentDaoBeanTest {

	@Autowired
	CommentDao commentDao;
	
	/**
	 * 测试insert
	 */
	@Test
	public void test1(){
		Comment comment=new Comment();
		comment.setContent("第一个评论");
		comment.setDate(new Date(new java.util.Date().getTime()));
		comment.setPostId(11);
		comment.setUserId(11);
		int count=commentDao.insert(comment);
		System.out.println(String.format("修改了%d记录，comment的commentId为%d", count,comment.getCommentId()));
	}
	
	/**
	 * 测试update,selectById
	 */
	@Test
	public void test2(){
		Comment comment=commentDao.selectById(3);
		System.out.println(comment.toString());
		comment.setContent("这是修改后的评论");
		int count=commentDao.update(3, comment);
		System.out.println(commentDao.selectById(3).getContent());
		System.out.println(String.format("影响了%d行", count));
	}
	
	/**
	 * 测试delete,selectById
	 */
	@Test
	public void test3(){
		System.out.println(commentDao.selectById(6).toString());
		int count=commentDao.delete(6);
		System.out.println("删除了"+count+"行");
		System.out.println(commentDao.selectById(6)==null?"is null":"not null");
	}
	
	/**
	 * 测试selectAll
	 */
	@Test
	public void test4(){
		List<Comment> lists=commentDao.selectAll();
		for (Comment comment : lists) {
			System.out.println(comment.toString());
		}
	}
}
