package com.hbkd.hyx.app.sence.service;

import java.util.List;

import com.hbkd.hyx.app.sence.bean.UserInfo;


public interface UserInfoService {

	public UserInfo getUserInfoById(String id);

	public List<UserInfo> getUserInfoList(String string);

	public List<UserInfo> getUserOccList(String string);
}
