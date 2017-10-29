package com.hbkd.hyx.app.sence.action;

import com.hbkd.hyx.app.sence.bean.Monitor;
import com.hbkd.hyx.app.sence.service.UserInfoService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.hbkd.hyx.tool.StrKit;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;

import java.util.List;

//个人中心模块
public class UserInfoAction extends BaseAction {

    Logger logger = Logger.getLogger(UserInfoAction.class);

    // 注入属性
    // 注入UserService
    private UserInfoService userInfoService;

    private String userId;
    private List<Monitor> userInfoList = null;

    private static final long serialVersionUID = 8264673797001399821L;

    public String userInfo() {
        //首先获取 userID, 然后根据 userId 获取个人数据
        userId = ActionContext.getContext().getSession().get("userId").toString();
        logger.debug("get userId from session  userId:" + userId);

        if (StrKit.isBlank(userId)) {
            return ERROR;
        }
        try {
//            userBean = userInfoService.getUserInfoById(userId);
//            ActionContext.getContext().getSession().put("userSession", userBean);

            userInfoList = userInfoService.getUserInfoList(userId);
            logger.debug(userInfoList);

            super.getRequest().setAttribute("userInfoList", userInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Monitor> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<Monitor> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "UserInfoAction{" +
                "userInfoService=" + userInfoService +
                ", userId='" + userId + '\'' +
                ", userInfoList=" + userInfoList +
                '}';
    }
}
