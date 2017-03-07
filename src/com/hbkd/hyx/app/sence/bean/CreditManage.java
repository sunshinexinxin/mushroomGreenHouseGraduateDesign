package com.hbkd.hyx.app.sence.bean;

public class CreditManage {

	private String id;
	private String userId;
	private String userName;
	private String userGender;
	private String userBir;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserBir() {
		return userBir;
	}

	public void setUserBir(String userBir) {
		this.userBir = userBir;
	}

	@Override
	public String toString() {
		return "CreditManage [id=" + id + ", userId=" + userId + ", userName="
				+ userName + ", userGender=" + userGender + ", userBir="
				+ userBir + ", getId()=" + getId() + ", getUserId()="
				+ getUserId() + ", getUserName()=" + getUserName()
				+ ", getUserGender()=" + getUserGender() + ", getUserBir()="
				+ getUserBir() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
