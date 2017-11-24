package com.hbkd.hyx.app.sence.dao.impl;

import com.hbkd.hyx.app.sence.dao.CreditManageDao;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Map;


public class CreditManageDaoImpl extends SqlSessionDaoSupport implements
        CreditManageDao {

    Logger logger = Logger.getLogger(CreditManageDaoImpl.class);

    /* 管理员-添加信贷员信息 */
    @Override
    public Object getCreditManage(Map<String, String> map) {
        logger.info("SQL_ID:CreditManageMapper.getCreditManage 管理员-添加信贷员信息");
        Object creditManage = null;
        creditManage = getSqlSession().insert(
                "CreditManageMapper.getCreditManage", map);
        logger.info("添加信贷员信息成功");
        return creditManage;
    }

}
