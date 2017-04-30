package com.hbkd.hyx.app.login.action;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.service.UserService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginAction extends BaseAction {

    protected final Logger logger = Logger.getLogger(LoginAction.class);

    private static final long serialVersionUID = -22247146217995282L;
    // 注入UserService
    @Autowired
    private UserService userService;
    /**
     * 以上注入的service、属性 必须要有getter、setter方法 setter 方法用于接受页面传入参数 getter方法用于返回页面,展示
     * <p>
     * Struts2 中 定义的属性 必须要有getter、setter方法 Spring 配置文件中
     * 定义的bean也必须要有getter、setter方法
     */
    // 注入属性
    private User user;
    private String userName;
    private String userPwd;
    private List<User> userList;

    /**
     * 登录方法
     */
    public String login() {
        try {
            logger.info("前台数据：用户名：" + userName + "\t密码：" + userPwd);
            user = userService.getUserById(userName);
            logger.info("后台数据：" + user);
            if (user != null) {
                if (user.getUserPsd().equals(userPwd)) {
                    try {
                        //设置session.
                        ActionContext.getContext().getSession().put("userName", user.getUserName());
                        ActionContext.getContext().getSession().put("userId", user.getUserId());
                        ActionContext.getContext().getSession().put("userBeen", user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (user.getStatus().equals("0") || user.getStatus().equals("1")) {
                        return "manage";
                    } else if (user.getStatus().equals("2")) {
                        return "staff";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }


    /**
     * 退出方法
     */
    public String logout() {
        return SUCCESS;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Logger getLogger() {
        return logger;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}
