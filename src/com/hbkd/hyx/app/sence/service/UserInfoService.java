package com.hbkd.hyx.app.sence.service;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * @author anke
 */
@ServiceMode
public interface UserInfoService {

	User getUserInfoById(String id);

	/**根个人中心
	 * @param userId
	 * @return
	 */
	List<Monitor> getUserInfoList(String userId);
}
