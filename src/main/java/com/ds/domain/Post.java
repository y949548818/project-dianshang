package com.ds.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 这个类是帖子的实体类
 * @author asus
 *
 */
public class Post {
	/**
	 * 帖子的标题
	 */
	private String title;
	/**
	 * 帖子的id
	 */
	private int postId;
	/**
	 * 帖子发布者的id
	 */
	private int userId;
	/**
	 * 帖子的内容
	 */
	private String content;
	/**
	 * 帖子发布的时间
	 */
	private Timestamp publishTime;
	/**
	 * 帖子的类型
	 */
	private int type;
	/**
	 * 回复的数量
	 */
	private int reply_count;
	/**
	 * 点击的数量
	 */
	private int click_count;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}
	public int getClick_count() {
		return click_count;
	}
	public void setClick_count(int click_count) {
		this.click_count = click_count;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPostId() {
		return postId;
	}
	
	@Override
	public String toString() {
		return "Post [title=" + title + ", postId=" + postId + ", userId=" + userId + ", content=" + content
				+ ", publishTime=" + publishTime + ", type=" + type + ", reply_count=" + reply_count + ", click_count="
				+ click_count + "]";
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Post() {
		super();
		this.setPublishTime(new Timestamp(new Date().getTime()));
	}
	
	
}
