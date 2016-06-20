package com.qh.app.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.dao.BulletDao;
import com.ds.dao.PostDao;
import com.ds.dao.impl.BulletDaoBean;
import com.ds.domain.Bullet;
import com.ds.domain.Page;
import com.ds.domain.Post;



@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class BulletDaoBeanTest {

	@Autowired
	BulletDao bulletDao;
	
	/**
	 * 测试Insert
	 */
	@Test
	public void test1(){
		Bullet bullet=new Bullet();
		bullet.setColor(0xffffff);
		bullet.setContent("测试内容");
		bullet.setMode(Bullet.MODE_RIGHT_TO_LEFT);
		bullet.setPublishTime(new Timestamp(new Date().getTime()));
		bullet.setUserId(2);
		bullet.setVideoId(5);
		bullet.setVideoTime(2);
		
		int count=bulletDao.insert(bullet);
		System.out.println(String.format("修改了%d条记录，bullet的bulletId为%d",count,bullet.getBulletId() ));
	}
	
	/**
	 * 测试selectAll
	 */
	@Test
	public void test2(){
		List<Bullet> bullets=bulletDao.selectAllByVideoId(5);
		System.out.println(bullets);
	}

	/**
	 * 测试selectAllByVideoIdAndStartTime
	 */
	@Test
	public void test3(){
		List<Bullet> bullets=bulletDao.selectAllByVideoIdAndStartTime(5, 10);
		System.out.println(bullets);
	}
	/**
	 * 测试selectSomeByVideoIdAndStartTime
	 */
	@Test
	public void test4(){
		List<Bullet> bullets=bulletDao.selectSomeByVideoIdAndStartTime(5, 10, 1);
		System.out.println(bullets);
	}
	
	/**
	 * 测试selectById
	 */
	@Test
	public void test5(){
		Bullet bullet=bulletDao.selectById(35);
		System.out.println(bullet.toString());
	}
	
	/**
	 * 测试update
	 */
	@Test
	public void test6(){
		Bullet bullet=bulletDao.selectById(35);
		System.out.println(bullet.toString());
		bullet.setContent("修改后的测试内容");
		bulletDao.update(bullet.getBulletId(), bullet);
		bullet=bulletDao.selectById(35);
		System.out.println(bullet.toString());
	}
	
	/**
	 * 测试delete
	 */
	@Test
	public void test7(){
		System.out.println(bulletDao.delete(35));
	}
	

}
