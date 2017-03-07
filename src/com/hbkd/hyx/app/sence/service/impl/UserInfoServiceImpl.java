package com.hbkd.hyx.app.sence.service.impl;

import java.util.List;

import com.hbkd.hyx.app.sence.bean.UserInfo;
import com.hbkd.hyx.app.sence.dao.UserInfoDao;
import com.hbkd.hyx.app.sence.service.UserInfoService;


public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao;

	public UserInfo getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfoById(id);
	}

	public List<UserInfo> getUserInfoList(String string) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserInfoList(string);
	}
	
	public List<UserInfo> getUserOccList(String string) {
		// TODO Auto-generated method stub
		return userInfoDao.getUserOccList(string);
	}

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


}
