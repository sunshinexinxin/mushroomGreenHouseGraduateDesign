package com.hbkd.hyx.app.sence.action;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.service.UserInfoService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;

import java.util.List;

public class UserInfoAction extends BaseAction {

    Logger logger = Logger.getLogger(UserInfoAction.class);
    // 注入UserService
    private UserInfoService userInfoService;

    // 注入属性
    private User userBean = null;
    private String userId;
    private List<User> userInfoList = null;

    private static final long serialVersionUID = 8264673797001399821L;

    public String userInfo() {
        //首先获取 userID, 然后根据 userId 获取个人数据
        userId = ActionContext.getContext().getSession().get("userId").toString();
        logger.info("get userId from session  userId:" + userId);

        if ("".equals(userId)) return ERROR;
        try {
            userBean = userInfoService.getUserInfoById(userId);
            ActionContext.getContext().getSession().put("userSession", userBean);


            userInfoList = userInfoService.getUserInfoList(userId);
            for (User userInfo : userInfoList) {
                logger.info(userInfo.toString());
            }

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

    public User getUserbean() {
        return userBean;
    }

    public void setUserbean(User userbean) {
        this.userBean = userbean;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<User> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<User> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "UserInfoAction{" +
                "userInfoService=" + userInfoService +
                ", userbean=" + userBean +
                ", userId='" + userId + '\'' +
                ", userInfoList=" + userInfoList +
                '}';
    }
}
