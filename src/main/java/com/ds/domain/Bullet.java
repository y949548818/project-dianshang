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
	 * 评论内容
	 */
	private String content;
	/**
	 * 发布时间
	 */
	private Timestamp date;
	/**
	 * 弹幕的颜色
	 */
	private int color;
	/**
	 * 弹幕的模式
	 */
	private int mode;
	/**
	 * 发布者的id
	 */
	private int userId;
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
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Bullet [bulletId=" + bulletId + ", content=" + content + ", date=" + date + ", color=" + color
				+ ", mode=" + mode + ", userId=" + userId + "]";
	}

	
}
