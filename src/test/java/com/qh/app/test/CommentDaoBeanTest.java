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
import com.ds.domain.Page;
import com.ds.domain.Post;

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
		comment.setContent("测试content1");
		comment.setDate(new Date(new java.util.Date().getTime()));
		comment.setPostId(1);
		comment.setUserId(2);
		int count=commentDao.insert(comment);
		System.out.println(String.format("影响%d行,评论id=%d", count,comment.getCommentId()));
	}
	
	/**
	 * 测试update,selectById
	 */
	@Test
	public void test2(){
		Comment comment=commentDao.selectById(3);
		System.out.println(comment.toString());
		comment.setContent("�����޸ĺ������");
		int count=commentDao.update(3, comment);
		System.out.println(commentDao.selectById(3).getContent());
		System.out.println(String.format("Ӱ����%d��", count));
	}
	
	/**
	 * 测试delete,selectById
	 */
	@Test
	public void test3(){
		System.out.println(commentDao.selectById(6).toString());
		int count=commentDao.delete(6);
		System.out.println("ɾ����"+count+"��");
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
	/**
	 * 测试分页查询
	 */
	@Test
	public void test6(){
		Page<Comment> page=commentDao.page(1, 10);
		System.out.println(page.getResult());
	}
}
