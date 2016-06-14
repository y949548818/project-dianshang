package com.ds.domain;

import java.sql.Timestamp;

/**
 * 这个类是弹幕的实体类
 * @author qq245521957
 *
 */
public class Bullet {

	/**
	 * 弹幕id
	 */
	private int bulletId;
	/**
	 * 视频id
	 */
	private int videoId;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 发布时间
	 */
	private Timestamp publishTime;
	/**
	 * 弹幕的颜色
	 */
	private int color;
	/**
	 * 弹幕的模式
	 */
	private int mode=1;
	/**
	 * 发布者的id
	 */
	private int userId;
	/**
	 * 视频的时间
	 */
	private int videoTime;
	/**
	 * 随机从右边某个高度出现。然后自右向左移动
	 */
	public static final int MODE_RIGHT_TO_LEFT=1;
	/**
	 * 出现在上方然后渐渐消失
	 */
	public static final int MODE_TOPE=2;
	/**
	 * 出现在下方，然后渐渐消失
	 */
	public static final int MODE_BOTTOM=3;
	
	public int getBulletId() {
		return bulletId;
	}
	public void setBulletId(int bulletId) {
		this.bulletId = bulletId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public int getVideoTime() {
		return videoTime;
	}
	public void setVideoTime(int videoTime) {
		this.videoTime = videoTime;
	}
	
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	@Override
	public String toString() {
		return "Bullet [bulletId=" + bulletId + ", videoId=" + videoId + ", content=" + content + ", publishTime="
				+ publishTime + ", color=" + color + ", mode=" + mode + ", userId=" + userId + ", videoTime="
				+ videoTime + "]";
	}

	
}
