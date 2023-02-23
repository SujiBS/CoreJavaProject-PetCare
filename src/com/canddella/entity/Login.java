package com.canddella.entity;

public class Login {
	
	private int loginId;
	private String userName;
	private String password;
	public Login() {
		super();
	}
	public Login(int loginId, String userName, String password) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
	}
	public int getLoginId() {
		return loginId;
	}
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
}
