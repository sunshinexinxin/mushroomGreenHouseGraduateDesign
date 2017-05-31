package com.hbkd.hyx.app.sence.service;

import com.hbkd.hyx.app.sence.bean.ChartsCollectionBean;

import java.util.List;

/**
 * Created by anke on 2017/5/1.
 */
public interface ChartsCollectionService {

    List<ChartsCollectionBean> getTempWetList(String pointId);
}
