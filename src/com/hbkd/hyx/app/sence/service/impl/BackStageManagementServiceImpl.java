package com.hbkd.hyx.app.sence.service.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.dao.BackStageManagementDao;
import com.hbkd.hyx.app.sence.service.BackStageManagementService;

import java.util.List;
import java.util.Map;

/**
 * @author anke
 * @date 2017/11/22
 */
public class BackStageManagementServiceImpl implements BackStageManagementService {
    private BackStageManagementDao backStageManagementDao;

    @Override
    public List<User> getUsersList(String userId, String status) {
        return backStageManagementDao.getUsersList(userId, status);
    }

    @Override
    public Integer addUsers(Map params) {
        return backStageManagementDao.addUsers(params);
    }

    @Override
    public Integer deleteUsers(String userID) {
        return backStageManagementDao.deleteUsers(userID);
    }

    public BackStageManagementDao getBackStageManagementDao() {
        return backStageManagementDao;
    }

    public void setBackStageManagementDao(BackStageManagementDao backStageManagementDao) {
        this.backStageManagementDao = backStageManagementDao;
    }
}
