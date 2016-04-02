package com.ds.domain;

public class User {
	private int userId;
	private String username;
	private String lastIp;
	
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", lastIp=" + lastIp + "]";
	}
	public User(int userId, String username, String lastIp, int age) {
		super();
		this.userId = userId;
		this.username = username;
		this.lastIp = lastIp;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
