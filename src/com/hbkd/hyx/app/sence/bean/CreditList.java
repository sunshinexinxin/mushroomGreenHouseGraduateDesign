package com.hbkd.hyx.app.sence.bean;

public class CreditList {

	private String id;
	private String userId;
	private String userName;
	private String userGender;
	private String userBir;
	private String userAge;
	private String mobilePhone;
	private String email;
	private String position;
	private String search;
	private String count;

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

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSearch() {
		return search;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "CreditList [count=" + count + ", email=" + email + ", id=" + id
				+ ", mobilePhone=" + mobilePhone + ", position=" + position
				+ ", search=" + search + ", userAge=" + userAge + ", userBir="
				+ userBir + ", userGender=" + userGender + ", userId=" + userId
				+ ", userName=" + userName + "]";
	}

}
