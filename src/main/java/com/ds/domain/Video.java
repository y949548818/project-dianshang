package com.ds.domain;

import java.sql.Timestamp;

public class Video {
	/**
	 * 视频的id
	 */
	private int videoId;
	/**
	 * 视频名字
	 */
	private String title;
	/**
	 * 发布日期
	 */
	private Timestamp date;
	/**
	 * video的路径
	 */
	private String uri;
	/**
	 * 发布者的id
	 */
	private int userId;
	
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", date=" + date + ", uri=" + uri + ", userId="
				+ userId + "]";
	}
	
}
