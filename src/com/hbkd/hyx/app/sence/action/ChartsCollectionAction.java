package com.hbkd.hyx.app.sence.action;

import com.hbkd.hyx.app.sence.bean.ChartsCollectionBean;
import com.hbkd.hyx.app.sence.service.ChartsCollectionService;
import com.hbkd.hyx.core.mvc.BaseAction;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anke on 2017/5/1.
 */
public class ChartsCollectionAction extends BaseAction {
    Logger logger = Logger.getLogger(ChartsCollectionAction.class);
    //注入属性
    @Autowired
    private ChartsCollectionService chartsService;
    private List<ChartsCollectionBean> tempWetList;
//    private List<String> tempWetList;

    /***温度湿度图表
     *
     * @return
     */
    public String tempWet() {
        String pointId = "00011";
        logger.info("数据报表统计-> 温度展示: " + pointId + " 号大棚");
        tempWetList = chartsService.getTempWetList(pointId);

        //空气温度
        List<String> airTempList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            airTempList.add(key.getMushroomAirtemp());
        }
        //空气湿度
        List<String> airhumidityList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            airhumidityList.add(key.getMushroomAirhumidity());
        }
        //土壤温度
        List<String> soiltempList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            soiltempList.add(key.getMushroomSoiltemp());
        }
        //土壤湿度
        List<String> soilmoistureList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            soilmoistureList.add(key.getMushroomSoilmoisture());
        }

        //光照强度
        List<String> ightintensityList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            ightintensityList.add(key.getMushroomIghtintensity());
        }

        //二氧化碳浓度
        List<String> co2densutyList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            co2densutyList.add(key.getMushroomCo2densuty());
        }
        //时间
        List<String> timeList = new ArrayList<>();
        for (ChartsCollectionBean key : tempWetList) {
            String shi = key.getCtime().substring(8, 10);
            String fen = key.getCtime().substring(10, 12);
            timeList.add("'" + shi + ":" + fen + "'");
        }

        super.getRequest().setAttribute("airTempList", airTempList);
        super.getRequest().setAttribute("airhumidityList", airhumidityList);
        super.getRequest().setAttribute("soiltempList", soiltempList);
        super.getRequest().setAttribute("soilmoistureList", soilmoistureList);
        super.getRequest().setAttribute("ightintensityList", ightintensityList);
        super.getRequest().setAttribute("co2densutyList", co2densutyList);
        super.getRequest().setAttribute("timeList", timeList);
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
