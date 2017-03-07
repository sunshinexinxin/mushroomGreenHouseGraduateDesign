package com.hbkd.hyx.app.login.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.dao.UserDao;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	
	protected final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public User getUserById(String name) {
		User user = new User();
		// sql语句，传入一个参数，后台查询后返回；
		logger.info("SQL_ID：UserMapper.getUserById"+"获取用户个人身份信息");
		user = getSqlSession().selectOne("UserMapper.getUserById", name);
		return user;
	}

	public List<User> getUserList(List<String> list) {
		List<User> userList = new ArrayList<User>();
		logger.info("SQL_ID：UserMapper.getUserFamiList");
//		userList = getSqlSession().selectList("UserMapper.getUserFamiList", list);
		return userList;
	}
}
