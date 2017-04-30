package com.hbkd.hyx.app.sence.dao.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;
import com.hbkd.hyx.app.sence.dao.UserInfoDao;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserInfoDaoImpl extends SqlSessionDaoSupport implements UserInfoDao {

    private Logger logger = Logger.getLogger(UserInfoDaoImpl.class);
    User userInfo = null;
    List<Monitor> userInfoList = null;

    public User getUserInfoById(String id) {
        logger.info("SQL_ID:UserMapper.getUserByUserId");
        // sql语句，传入一个参数，后台查询后返回；
        userInfo = getSqlSession().selectOne("UserMapper.getUserByUserId", id);
        return userInfo;
    }

    public List<Monitor> getUserInfoList(String userId) {
        logger.info("SQL_ID:UserMapper.getUserByUserId [个人中心]获取个人信息");
        userInfoList = getSqlSession().selectList("UserInfoMapper.getUserInfoListByUserID", userId);
        return userInfoList;
    }

}
