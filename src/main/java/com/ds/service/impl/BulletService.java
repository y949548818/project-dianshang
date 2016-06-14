package com.ds.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.dao.BulletDao;
import com.ds.domain.Bullet;
import com.ds.service.BulletPublishService;
import com.ds.service.BulletSelectService;

@Service
public class BulletService implements BulletPublishService,BulletSelectService{

	@Autowired
	BulletDao bulletDao;
	
	
	@Override
	public List<Bullet> getSomeBulletsByVideoIdAndTime(int videoId, int startTime, int amount) {
		// TODO Auto-generated method stub
		return bulletDao.selectSomeByVideoIdAndStartTime(videoId, startTime, amount);
	}


	@Override
	public int publish(Bullet bullet) {
		// TODO Auto-generated method stub
		return bulletDao.insert(bullet);
	}




	
	
	
}
