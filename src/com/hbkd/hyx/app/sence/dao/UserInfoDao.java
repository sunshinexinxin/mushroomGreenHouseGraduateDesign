package com.hbkd.hyx.app.sence.dao;

import com.hbkd.hyx.app.login.bean.User;

import java.util.List;


public interface UserInfoDao {

	User getUserInfoById(String id);

	List<User> getUserInfoList(String id);

}