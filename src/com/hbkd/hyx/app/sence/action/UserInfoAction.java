package com.hbkd.hyx.app.sence.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.login.service.UserService;
import com.hbkd.hyx.app.sence.bean.UserInfo;
import com.hbkd.hyx.app.sence.service.UserInfoService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class UserInfoAction extends BaseAction {
	
	Logger logger = Logger.getLogger(UserInfoAction.class);
	// 注入UserService
	private UserInfoService userInfoService;
	private UserService userService ;
	
	// 注入属性
	private User userInfo = null;
	private String userId ;
	private String userNo ;
	private List<UserInfo> userInfoList = null;
	private List<UserInfo> userOccList = null;

	private static final long serialVersionUID = 8264673797001399821L;

	public String userInfo() {
		try {
			if(null != userNo){
				logger.info("if->userId:"+userId+"\tuserNo:"+userNo);
				userInfo = userService.getUserById(userNo);
				ActionContext.getContext().getSession().put("userSession", userInfo);
			}else{
				logger.info("else->userId:"+userId+"\tuserNo:"+userNo);
				userId = (String) ActionContext.getContext().getSession().get("userIdSession");
				userNo = userId;
				logger.info("else2->userId:"+userId+"\tuserNo:"+userNo);
				userInfo = userService.getUserById(userNo);
				ActionContext.getContext().getSession().put("userSession", userInfo);
				logger.info("else->userId:"+userId+"\tuserNo:"+userNo);
			}
			
			
			userInfoList = userInfoService.getUserInfoList(userNo);
			userOccList = userInfoService.getUserOccList(userNo);
			for (UserInfo userInfo : userInfoList) {
				logger.info(userInfo.toString());
			}
			for (UserInfo userOcc : userOccList) {
				logger.info(userOcc.toString());
			}
			
			super.getRequest().setAttribute("userInfoList",userInfoList);
			super.getRequest().setAttribute("userOccList",userOccList);
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

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List<UserInfo> getUserOccList() {
		return userOccList;
	}

	public void setUserOccList(List<UserInfo> userOccList) {
		this.userOccList = userOccList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
