package com.hbkd.hyx.app.login.service;

import com.hbkd.hyx.app.login.bean.User;

//import java.util.List;

/**
 * @author anke
 */
public interface UserService {

	/**用户登录，获取用户信息
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
