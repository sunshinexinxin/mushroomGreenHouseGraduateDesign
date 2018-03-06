package com.hbkd.hyx.app.login.bean;

import com.hbkd.hyx.app.sence.bean.Monitor;

public class User {

    //用户id
    private String userId;
    //用户姓名
    private String userName;
    //用户年龄
    private String userAge;
    //用户密码
    private String userPsd;
    //用户联系方式
    private String userPhone;
    //用户地址
    private String userAdd;
    //用户身份标识.0:开发测试;1:普通用户;2:管理员
    private String status;
    //删除标识.初始为0;删除为1.
    private String delFlag;
    //备注
    private String memo;
    //创建时间
    private String ctime;

    //大棚监控点
    private Monitor monitor;
    //统计
    private Monitor coun;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserPsd() {
        return userPsd;
    }

    public void setUserPsd(String userPsd) {
        this.userPsd = userPsd;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Monitor getCoun() {
        return coun;
    }

    public void setCoun(Monitor coun) {
        this.coun = coun;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userPsd='" + userPsd + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAdd='" + userAdd + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", memo='" + memo + '\'' +
                ", ctime='" + ctime + '\'' +
                ", monitor=" + monitor +
                ", coun=" + coun +
                '}';
    }
}
