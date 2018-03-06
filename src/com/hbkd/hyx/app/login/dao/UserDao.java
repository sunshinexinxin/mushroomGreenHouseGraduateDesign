package com.hbkd.hyx.app.login.dao;

import com.hbkd.hyx.app.login.bean.User;


/**
 * @author anke
 */
public interface UserDao {

	/**获取登录用户信息
	 * @param id
	 * @return
	 */
	User getUserByName(String id);

	/**根据用户名获取用户数量
	 * @param name
	 * @return
	 */
	Integer getUserCountByName(String name);

}
