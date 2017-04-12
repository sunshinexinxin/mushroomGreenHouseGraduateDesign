package com.hbkd.hyx.app.login.service.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.dao.UserDao;
import com.hbkd.hyx.app.login.service.UserService;

//import java.util.List;


public class UserServiceImpl implements UserService {

	// 注入UserDao 该变量名称必须与配置文件中定义的<bean id ="userDao"> 相同
	private UserDao userDao;

	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
