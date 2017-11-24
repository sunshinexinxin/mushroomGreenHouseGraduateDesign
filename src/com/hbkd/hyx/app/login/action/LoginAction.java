package com.hbkd.hyx.app.login.action;

import com.hbkd.hyx.app.login.bean.ResuData;
import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.service.UserService;
import com.hbkd.hyx.app.sence.bean.Monitor;
import com.hbkd.hyx.app.sence.service.UserInfoService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.hbkd.hyx.tool.Md5Utils;
import com.hbkd.hyx.tool.StrKit;
import com.opensymphony.xwork2.ActionContext;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.ArrayList;
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


    private JSONObject json = new JSONObject();
    private ResuData resuData = new ResuData();

    /**
     * 登录方法
     */
    public String login() {
        try {
            logger.info("前台数据：用户名：" + userName + "\t密码：" + userPwd);
            user = userService.getUserByName(userName);
            logger.info("后台数据：" + user);
            if (user != null) {
                if (userPwd != null) {
                    if (user.getUserPsd().equals(Md5Utils.MD5Encode(userPwd))) {
                        try {
                            //设置session.
                            ActionContext.getContext().getSession().put("userName", user.getUserName());
                            ActionContext.getContext().getSession().put("userId", user.getUserId());
                            ActionContext.getContext().getSession().put("userBean", user);
                            logger.info(user.getUserName() + " 登录成功！");
                            return SUCCESS;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        logger.info("密码输入错误！");
                    }
                } else {
                    logger.info("用户密码出错，请联系管理员！");
                }
            } else {
                logger.info("用户名错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR;
    }


    /***地图首页方法
     *
     * @return
     */
    private Map<String, Object> rsJsonData;

    public String mushRoomMap() {
        //首先获取 userID, 然后根据 userId 获取个人数据
        String userId = ActionContext.getContext().getSession().get("userId").toString();
        logger.info("从session获取userId:" + userId);
        if (StrKit.isBlank(userId)) {
            return ERROR;
        }
        //查询蘑菇大棚
        List<Monitor> mushRoomList = userInfoService.getUserInfoList(userId);

        ResuData rs = new ResuData();
        rs.setStatus("200");
        rs.setMessage("成功");
        List resuList = new ArrayList();
        for (int i = 0; i < mushRoomList.size(); i++) {
            List resuLists = new ArrayList();
            resuLists.add(mushRoomList.get(i).getMushroomLat());
            resuLists.add(mushRoomList.get(i).getMushroomLong());
            resuList.add(resuLists);
        }
        rs.setData(resuList.toString());
        rsJsonData = JSONObject.fromObject(rs);
        System.out.println("rsJsonData\t" + rsJsonData);

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

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public ResuData getResuData() {
        return resuData;
    }

    public void setResuData(ResuData resuData) {
        this.resuData = resuData;
    }

    public Map<String, Object> getRsJsonData() {
        return rsJsonData;
    }

    public void setRsJsonData(Map<String, Object> rsJsonData) {
        this.rsJsonData = rsJsonData;
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
                ", json=" + json +
                ", resuData=" + resuData +
                ", rsJsonData=" + rsJsonData +
                '}';
    }

}
