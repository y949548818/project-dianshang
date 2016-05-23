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
	private int author;
	/**
	 * 帖子的内容
	 */
	private String content;
	/**
	 * 帖子发布的时间
	 */
	private Timestamp publishTime;
	
	
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
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Post [title=" + title + ", postId=" + postId + ", postAdmin=" + author + ", content=" + content
				+ ", publishTime=" + publishTime + "]";
	}
	public Post() {
		super();
		this.setPublishTime(new Timestamp(new Date().getTime()));
	}
	
	
}
