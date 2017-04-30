package com.hbkd.hyx.app.sence.dao;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;

import java.util.List;


public interface UserInfoDao {

	User getUserInfoById(String id);

	List<Monitor> getUserInfoList(String id);

}