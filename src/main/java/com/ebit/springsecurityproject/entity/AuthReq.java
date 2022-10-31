package com.ebit.springsecurityproject.entity;

public class AuthReq {

	private String userName;
	private String pass;

	public AuthReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthReq(String userName, String pass) {
		super();
		this.userName = userName;
		this.pass = pass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "AuthReq [userName=" + userName + ", pass=" + pass + "]";
	}

}
