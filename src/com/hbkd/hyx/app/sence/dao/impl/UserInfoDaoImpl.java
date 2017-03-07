package com.hbkd.hyx.app.sence.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hbkd.hyx.app.sence.bean.UserInfo;
import com.hbkd.hyx.app.sence.dao.UserInfoDao;


public class UserInfoDaoImpl extends SqlSessionDaoSupport implements UserInfoDao {
	
	private Logger logger = Logger.getLogger(UserInfoDaoImpl.class);

	public UserInfo getUserInfoById(String id) {
        UserInfo userInfo = null;
        System.out.println("SQL_ID:UserInfoMapper.getUserInfoFami");
     // sql语句，传入一个参数，后台查询后返回；
//        userInfo = getSqlSession().selectOne("UserInfoMapper.getUserInfoFami", id);
		return userInfo;
	}

	public List<UserInfo> getUserInfoList(String id) {
		List<UserInfo> userInfoList = null;
		logger.info("SQL_ID:UserInfoMapper.getUserInfoFamiList获取用户家庭成员信息");
		userInfoList = getSqlSession().selectList("UserInfoMapper.getUserInfoFamiList",id);
		return userInfoList;
	}
	
	public List<UserInfo> getUserOccList(String id) {
		List<UserInfo> userInfoList = null;
		logger.info("SQL_ID:UserInfoMapper.getUserOccList获取用户职业变动信息");
		userInfoList = getSqlSession().selectList("UserInfoMapper.getUserOccList",id);
		return userInfoList;
	}

}
