package com.hbkd.hyx.app.sence.service.impl;

import com.hbkd.hyx.app.sence.bean.ChartsCollectionBean;
import com.hbkd.hyx.app.sence.dao.ChartsCollectionDao;
import com.hbkd.hyx.app.sence.service.ChartsCollectionService;

import java.util.List;

/**
 * Created by anke on 2017/5/1.
 */
public class ChartsCollectionServicImpl implements ChartsCollectionService {
    private ChartsCollectionDao chartsCollectionDao;

    public List<ChartsCollectionBean> getTempWetList(String pointId) {
        return chartsCollectionDao.getTempWetListById(pointId);
    }

    public ChartsCollectionDao getChartsCollectionDao() {
        return chartsCollectionDao;
    }

    public void setChartsCollectionDao(ChartsCollectionDao chartsCollectionDao) {
        this.chartsCollectionDao = chartsCollectionDao;
    }
}
