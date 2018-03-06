package com.hbkd.hyx.app.sence.dao;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;

import java.util.List;


/**
 * @author anke
 */
public interface UserInfoDao {

	/**根个人中心
	 * @param id
	 * @return
	 */
	User getUserInfoById(String id);

	/**根个人中心
	 * @param id
	 * @return
	 */
	List<Monitor> getUserInfoList(String id);

}