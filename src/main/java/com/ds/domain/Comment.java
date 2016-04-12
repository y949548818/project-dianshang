package com.ds.domain;

import java.sql.Date;

/**
 * 这个是评论的实体类
 * @author asus
 *
 */
public class Comment {
	
	/**
	 * 评论的id
	 */
	private int commentId;
	/**
	 * 评论的内容
	 */
	private String content;
	/**
	 * 评论发布者的id;
	 */
	private int userId;
	/**
	 * 帖子的id
	 */
	private int postId;
	/**
	 * 评论发布的日期
	 */
	private Date date;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Comment [CommentId=" + commentId + ", content=" + content + ", userId=" + userId + ", postId=" + postId
				+ ", Date=" + date.toString() + "]";
	}
	
}
