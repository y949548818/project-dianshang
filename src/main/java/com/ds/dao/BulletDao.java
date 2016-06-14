package com.ds.dao;

import java.util.List;

import com.ds.domain.Bullet;

public interface BulletDao extends IDao<Bullet>{

	/**
	 * 查询指定视频的所有弹幕
	 * @param videoId
	 * @return
	 */
	List<Bullet> selectAllByVideoId(int videoId);
	/**
	 * 查询从某一秒开始后的所有弹幕
	 * @param videoId
	 * @param startTime
	 * @return
	 */
	List<Bullet> selectAllByVideoIdAndStartTime(int videoId,int startTime);
	/**
	 * 查询从某一秒开始后的一定数量的弹幕
	 * @param videoId
	 * @param startTime
	 * @param amount
	 * @return
	 */
	List<Bullet> selectSomeByVideoIdAndStartTime(int videoId,int startTime,int amount);
}
