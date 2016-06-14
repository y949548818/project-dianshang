package com.ds.service;

import com.ds.domain.Bullet;

/**
 * 发布弹幕的接口规范
 * @author qq245521957
 *
 */
public interface BulletPublishService {

	/**
	 * 发布一个弹幕
	 * @param bullet
	 * @return
	 */
	int publish(Bullet bullet);
}
