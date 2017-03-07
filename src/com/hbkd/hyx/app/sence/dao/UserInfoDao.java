package com.hbkd.hyx.app.sence.dao;

import java.util.List;

import com.hbkd.hyx.app.sence.bean.UserInfo;


public interface UserInfoDao {

	public UserInfo getUserInfoById(String id);

	public List<UserInfo> getUserInfoList(String id);

	public List<UserInfo> getUserOccList(String id);
}
