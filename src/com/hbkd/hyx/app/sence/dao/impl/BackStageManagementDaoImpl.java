package com.hbkd.hyx.app.sence.dao.impl;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.dao.BackStageManagementDao;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anke
 * @date 2017/11/22
 */
public class BackStageManagementDaoImpl extends SqlSessionDaoSupport implements BackStageManagementDao {

    Logger logger = Logger.getLogger(BackStageManagementDaoImpl.class);

    /**
     * 系统后台管理-系统用户配置
     * 获取系统用户列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<User> getUsersList(String userId,String status) {

        logger.info("SQL_ID:BackStageManagement.getUsersByUserID");
        Map params = new HashMap<>(16);
        params.put("userId", userId);
        params.put("status", Integer.parseInt(status));
        // sql语句，传入一个参数，后台查询后返回；
        List<User> usersList = getSqlSession().selectList("BackStageManagement.getUsersByUserID", params);
        return usersList;
    }

    /**
     * 系统后台管理-系统用户配置
     * 添加系统用户
     *
     * @param params
     * @return
     */
    @Override
    public Integer addUsers(Map params) {
        logger.info("SQL_ID:BackStageManagement.addUsers");
        int insert = getSqlSession().insert("BackStageManagement.addUsers", params);
        return insert;
    }

    /**
     * 系统后台管理-系统用户配置
     * 删除系统用户
     *
     * @param userId
     * @return
     */
    @Override
    public Integer deleteUsers(String userId) {
        logger.info("SQL_ID:BackStageManagement.deleteUsers");
        System.out.println(userId);
        int delete = getSqlSession().delete("BackStageManagement.deleteUsers",userId);
        return delete;
    }
}
