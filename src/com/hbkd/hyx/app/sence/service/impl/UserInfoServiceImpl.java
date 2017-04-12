package com.hbkd.hyx.app.sence.service.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.dao.UserInfoDao;
import com.hbkd.hyx.app.sence.service.UserInfoService;

import java.util.List;


public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;


    public User getUserInfoById(String id) {
        return userInfoDao.getUserInfoById(id);
    }

    public List<User> getUserInfoList(String id) {
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
