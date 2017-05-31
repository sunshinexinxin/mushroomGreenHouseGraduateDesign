package com.hbkd.hyx.app.sence.dao.impl;

import com.hbkd.hyx.app.sence.bean.ChartsCollectionBean;
import com.hbkd.hyx.app.sence.dao.ChartsCollectionDao;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by anke on 2017/5/1.
 */
public class ChartsCollectionDaoImpl extends SqlSessionDaoSupport implements ChartsCollectionDao {
    Logger logger = Logger.getLogger(ChartsCollectionDaoImpl.class);
    List<ChartsCollectionBean> chartsCollectionList;

    public List<ChartsCollectionBean> getTempWetListById(String pointId) {

        logger.info("SQL_ID:ChartsCollection.getTempWetListById [数据统计报表]温度展示");
        chartsCollectionList = getSqlSession().selectList("ChartsCollection.getTempWetListById",pointId);
        return chartsCollectionList;
    }
}
