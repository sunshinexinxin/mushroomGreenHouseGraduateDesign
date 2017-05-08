package com.hbkd.hyx.app.sence.action;

import com.hbkd.hyx.app.sence.bean.ChartsCollectionBean;
import com.hbkd.hyx.app.sence.service.ChartsCollectionService;
import com.hbkd.hyx.core.mvc.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by anke on 2017/5/1.
 */
public class ChartsCollectionAction extends BaseAction{
    Logger logger = Logger.getLogger(ChartsCollectionAction.class);
    //注入属性
    @Autowired
    private ChartsCollectionService chartsService;
    private List<ChartsCollectionBean> tempWetList;

    /***温度湿度图表
     *
     * @return
     */
    public String tempWet() {
        String pointId = "00011";
        logger.info("数据报表统计-> 温度展示: " + pointId+" 号大棚");
        tempWetList = chartsService.getTempWetList(pointId);
        super.getRequest().setAttribute("tempWetList", tempWetList);
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public List<ChartsCollectionBean> getTempWetList() {
        return tempWetList;
    }

    public void setTempWetList(List<ChartsCollectionBean> tempWetList) {
        this.tempWetList = tempWetList;
    }

    public ChartsCollectionService getChartsService() {
        return chartsService;
    }

    public void setChartsService(ChartsCollectionService chartsService) {
        this.chartsService = chartsService;
    }

}
