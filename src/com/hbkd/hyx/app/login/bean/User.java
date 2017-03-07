package com.hbkd.hyx.app.login.bean;

public class User {

	private String idno;
	private String userId;
	private String userName;
	private String userAge;
	private String userPsd;
	private String userPhone;
	private String userAdd;
	private String status;
	private String delFlag;
	private String memo;
	private String ctime;
	public String getIdno() {
		return idno;
	}
	public void setIdno(String idno) {
		this.idno = idno;
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
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserPsd() {
		return userPsd;
	}
	public void setUserPsd(String userPsd) {
		this.userPsd = userPsd;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAdd() {
		return userAdd;
	}
	public void setUserAdd(String userAdd) {
		this.userAdd = userAdd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	@Override
	public String toString() {
		return "User [idno=" + idno + ", userId=" + userId + ", userName="
				+ userName + ", userAge=" + userAge + ", userPsd=" + userPsd
				+ ", userPhone=" + userPhone + ", userAdd=" + userAdd
				+ ", status=" + status + ", delFlag=" + delFlag + ", memo="
				+ memo + ", ctime=" + ctime + "]";
	}


}
