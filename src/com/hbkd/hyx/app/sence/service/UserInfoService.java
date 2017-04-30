package com.hbkd.hyx.app.sence.service;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;

import java.util.List;


public interface UserInfoService {

	User getUserInfoById(String id);

	List<Monitor> getUserInfoList(String userId);
}
