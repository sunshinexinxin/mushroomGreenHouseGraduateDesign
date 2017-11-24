package com.hbkd.hyx.app.sence.action;

import com.hbkd.hyx.app.login.bean.ResuData;
import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.service.UserService;
import com.hbkd.hyx.app.sence.service.BackStageManagementService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.hbkd.hyx.tool.CommonUtil;
import com.hbkd.hyx.tool.Md5Utils;
import com.hbkd.hyx.tool.StrKit;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统后台管理模块
 *
 * @author anke
 * @date 2017/11/22.
 */
public class BackStageManagementAction extends BaseAction {
    Logger logger = Logger.getLogger(BackStageManagementAction.class);


    private String status;
    private String userID;

    private String userName;
    private String userPsd;
    private String userAge;
    private String userPhone;
    private String userAdd;
    private String memo;

    private Map<String, Object> rsJsonData;
    private BackStageManagementService backStageManagementService;
    private UserService userService;

    /**
     * 获取系统用户列表
     * 排除同等级，以及自己
     *
     * @return
     */
    public String getUsers() {

        List<User> usersList = backStageManagementService.getUsersList(userID, status);

        ResuData resuData = new ResuData();
        if (usersList == null) {
            resuData.setData(null);
            resuData.setStatus("400");
            resuData.setMessage("获取数据失败");
        }
        resuData.setData(usersList);
        rsJsonData = JSONObject.fromObject(resuData);
        System.out.println(rsJsonData);

        return SUCCESS;
    }

    /**
     * 添加系统用户
     *
     * @return
     */
    public String addUsers() {
        Map<String, String> params = new HashMap<>(16);
        params.put("userName", userName);
        params.put("userPsd", Md5Utils.MD5Encode(userPsd));
        params.put("userAge", userAge);
        params.put("userPhone", userPhone);
        params.put("userAdd", userAdd);
        params.put("status", status);
        params.put("memo", memo);
        params.put("ctime", CommonUtil.getLocalSysTime1());
        logger.info("系统后台管理-添加系统用户" + params);
        //判断是否存在该用户，如果存在，不添加
        Integer userCountByName = userService.getUserCountByName(userName);
        ResuData resuData = new ResuData();
        if(StrKit.notBlank(userCountByName.toString())&&userCountByName==0){
            //添加用户
            Integer rst = backStageManagementService.addUsers(params);
            User userById;
            if (rst == 1) {
                //根据刚刚插入的用户，查询出来刚刚插入的数据，因为id等是自动生成的，所以需要重新查询一次
                try {
                    userById = userService.getUserByName(userName);
                    System.out.println(userById);
                    if (userById == null) {
                        resuData.setStatus("400");
                        resuData.setMessage("添加数据成功，获取失败");
                    } else {
                        resuData.setData(userById);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                resuData.setStatus("400");
                resuData.setMessage("添加数据失败");
            }
        }else{
            resuData.setStatus("400");
            resuData.setMessage("用户名已存在");
        }

        rsJsonData = JSONObject.fromObject(resuData);
        System.out.println(rsJsonData);
        return SUCCESS;
    }

    public String deleteUsers() {
        Integer integer = backStageManagementService.deleteUsers(userID);
        ResuData resuData = new ResuData();
        if (integer != 1) {
            resuData.setStatus("400");
            resuData.setMessage("失败");
        }
        rsJsonData = JSONObject.fromObject(resuData);
        System.out.println(rsJsonData);
        return SUCCESS;
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public Map<String, Object> getRsJsonData() {
        return rsJsonData;
    }

    public void setRsJsonData(Map<String, Object> rsJsonData) {
        this.rsJsonData = rsJsonData;
    }

    public BackStageManagementService getBackStageManagementService() {
        return backStageManagementService;
    }

    public void setBackStageManagementService(BackStageManagementService backStageManagementService) {
        this.backStageManagementService = backStageManagementService;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String toString() {
        return "BackStageManagementAction{" +
                "status='" + status + '\'' +
                ", userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userPsd='" + userPsd + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAdd='" + userAdd + '\'' +
                ", memo='" + memo + '\'' +
                ", rsJsonData=" + rsJsonData +
                ", backStageManagementService=" + backStageManagementService +
                ", userService=" + userService +
                '}';
    }
}
