package com.hbkd.hyx.app.sence.service.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.Monitor;
import com.hbkd.hyx.app.sence.dao.UserInfoDao;
import com.hbkd.hyx.app.sence.service.UserInfoService;

import java.util.List;


/**
 * @author anke
 */
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;


    @Override
    public User getUserInfoById(String id) {
        return userInfoDao.getUserInfoById(id);
    }

    @Override
    public List<Monitor> getUserInfoList(String id) {
        return userInfoDao.getUserInfoList(id);
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public String toString() {
        return "UserInfoServiceImpl{" +
                "userInfoDao=" + userInfoDao +
                '}';
    }
}
