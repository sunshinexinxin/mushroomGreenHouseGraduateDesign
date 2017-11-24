package com.hbkd.hyx.app.login.service.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.dao.UserDao;
import com.hbkd.hyx.app.login.service.UserService;

/**
 * @author anke
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Override
    public User getUserByName(String id) {
        return userDao.getUserByName(id);
    }

    @Override
    public Integer getUserCountByName(String name) {
        return userDao.getUserCountByName(name);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
