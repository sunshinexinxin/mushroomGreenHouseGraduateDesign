package com.hbkd.hyx.app.sence.service;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;

import javax.xml.ws.ServiceMode;
import java.util.List;

@ServiceMode
public interface UserInfoService {

	User getUserInfoById(String id);

	//根据用户 id 获取大棚信息
	List<Monitor> getUserInfoList(String userId);
}
