package com.ds.domain;

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
	private int postAdmin;
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
	public int getPostAdmin() {
		return postAdmin;
	}
	public void setPostAdmin(int postAdmin) {
		this.postAdmin = postAdmin;
	}
	
}
