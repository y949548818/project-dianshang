package com.ds.service;

import java.sql.Timestamp;
import java.util.List;

import com.ds.domain.Bullet;

/**
 * 选择弹幕的接口规范
 * @author qq245521957
 *
 */
public interface BulletSelectService {
	/**
	 * 
	 * @param videoId 
	 * @param time 开始时间（考虑到弹幕数量过多时分批次获取）
	 * @param amount 从time开始的多少个弹幕
	 * @return
	 */
	List<Bullet> getSomeBulletsByVideoIdAndTime(int videoId,int startTime,int amount);
}
