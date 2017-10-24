package com.hbkd.hyx.app.login.action;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.service.UserService;
import com.hbkd.hyx.app.sence.bean.Monitor;
import com.hbkd.hyx.app.sence.service.UserInfoService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.hbkd.hyx.tool.Constant;
import com.hbkd.hyx.tool.Md5Utils;
import com.hbkd.hyx.tool.StrKit;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONArray;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anke
 */
public class LoginAction extends BaseAction {

    protected final Logger logger = Logger.getLogger(LoginAction.class);

    private static final long serialVersionUID = -22247146217995282L;
    //此属性名必须和spring配置文件中的id名一致

    private UserService userService;

    /**
     * 以上注入的service、属性 必须要有getter、setter方法 setter 方法用于接受页面传入参数 getter方法用于返回页面,展示
     * <p>
     * Struts2 中 定义的属性 必须要有getter、setter方法 Spring 配置文件中
     * 定义的bean也必须要有getter、setter方法
     */

    private User user;
    private String userName;
    private String userPwd;
    private List<User> userList;


    /**
     * 复用类，根据用户 id 获取地图经纬度
     */
    private UserInfoService userInfoService;
//    private List<Monitor> mushRoomList = null;

    /**
     * 登录方法
     */
    public String login() {
        try {
            logger.info("前台数据：用户名：" + userName + "\t密码：" + userPwd);
            user = userService.getUserById(userName);
            logger.info("后台数据：" + user);
            if (user != null) {
                if (userPwd != null) {
                    if (user.getUserPsd().equals(Md5Utils.MD5Encode(userPwd))) {
                        try {
                            //设置session.
                            ActionContext.getContext().getSession().put("userName", user.getUserName());
                            ActionContext.getContext().getSession().put("userId", user.getUserId());
                            ActionContext.getContext().getSession().put("userBean", user);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (Constant.MANAGE.equals(user.getStatus()) || Constant.DEVELOPER.equals(user.getStatus())) {
                            return "manage";
                        } else if (Constant.STAFF.equals(user.getStatus())) {
                            return "staff";
                        }
                    } else {
                        logger.info("密码输入错误！");
                    }
                } else {
                    logger.info("请输入密码！");
                }
            } else {
                logger.info("用户名错误！");
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

    /***地图首页方法
     *
     * @return
     */
    public String mushRoomMap() {
        //首先获取 userID, 然后根据 userId 获取个人数据
        String userId = ActionContext.getContext().getSession().get("userId").toString();
        logger.debug("get userId from session  userId:" + userId);
        if (StrKit.isBlank(userId)) {
            return ERROR;
        }

        //查询蘑菇大棚

        List<Monitor> mushRoomList = userInfoService.getUserInfoList(userId);

        Map mushRoomMaps = new HashMap<>(16);
        Map mushRoomMap;
        for (int i = 0; i < mushRoomList.size(); i++) {
            mushRoomMap = new HashMap<>(16);
            mushRoomMap.put("mushroomLat", mushRoomList.get(i).getMushroomLat());
            mushRoomMap.put("mushroomLong", mushRoomList.get(i).getMushroomLong());
            mushRoomMaps.put("point" + (i + 1), mushRoomMap);
        }

        JSONArray data = JSONArray.fromObject(mushRoomMaps);
        System.out.println(data);
        ActionContext.getContext().getSession().put("mushRoomList", data);
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Override
    public String toString() {
        return "LoginAction{" +
                "userService=" + userService +
                ", user=" + user +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userList=" + userList +
                ", userInfoService=" + userInfoService +
                '}';
    }

}
