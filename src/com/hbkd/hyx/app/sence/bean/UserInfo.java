package com.hbkd.hyx.app.sence.bean;

public class UserInfo {

	private String id;
	private String userId; // ??????id
	private String relationShip; // ??????
	private String name; // ??????
	private String birthday; // ????????????
	private String tel; // ????????????
	private String email; // ????????????
	private String position; // ??????
	private String occTime; // ????????????
	private String office; // ????????????
	private String leader; // ????????????

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

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	public String getOcctime() {
		return occTime;
	}

	public void setOcctime(String occtime) {
		this.occTime = occtime;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Override
	public String toString() {
		return "UserInfo [birthday=" + birthday + ", email=" + email + ", id="
				+ id + ", leader=" + leader + ", name=" + name + ", occtime="
				+ occTime + ", office=" + office + ", position=" + position
				+ ", relationShip=" + relationShip + ", tel=" + tel
				+ ", userId=" + userId + "]";
	}

}
