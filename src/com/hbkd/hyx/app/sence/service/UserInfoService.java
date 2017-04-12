package com.hbkd.hyx.app.sence.service;

import com.hbkd.hyx.app.login.bean.User;

import java.util.List;


public interface UserInfoService {

	User getUserInfoById(String id);

	List<User> getUserInfoList(String string);
}
