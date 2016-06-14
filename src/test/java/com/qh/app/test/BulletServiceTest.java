package com.qh.app.test;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.domain.Bullet;
import com.ds.service.impl.BulletService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("file:src/main/webapp/WEB-INF/springmvc-servlet.xml") 
public class BulletServiceTest {
	
	@Autowired
	BulletService bulletService;
	
	/**
	 * 测试获得
	 */
	@Test
	public void test1(){
		
		System.out.println(bulletService.getSomeBulletsByVideoIdAndTime(5, 10, 4));
	}
	/**
	 * 测试发布弹幕
	 */
	@Test
	public void test2(){
		
		Bullet bullet=new Bullet();
		bullet.setColor(0x000000);
		bullet.setContent("测试弹幕");
		bullet.setPublishTime(new Timestamp(new Date().getTime()));
		bullet.setUserId(2);
		bullet.setVideoId(5);
		bullet.setVideoTime(25);
		System.out.println(bulletService.publish(bullet));
	}
}
