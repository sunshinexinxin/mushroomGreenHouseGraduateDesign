package com.hbkd.hyx.app.sence.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hbkd.hyx.app.sence.service.CreditManageService;
import com.hbkd.hyx.core.mvc.BaseAction;


public class CreditManageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(CreditManageAction.class);

	private CreditManageService creditManageService;
	private String userId;
	private String userName;
	private String userGender;
	private Map<String, String> map = new HashMap<String, String>();
	private Object retStringObject;

	public String addCredit() {
		return SUCCESS;
	}

	public String addCreditMessage() {
		map.put("userId", getUserId());
		map.put("userName", getUserName());
		map.put("userGender", getUserGender());
		logger.info("????????????????????????" + getUserId() + "???" + getUserName() + "???"
				+ getUserGender());
		retStringObject = creditManageService.getCreditManage(map);
		return SUCCESS;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public CreditManageService getCreditManageService() {
		return creditManageService;
	}

	public void setCreditManageService(CreditManageService creditManageService) {
		this.creditManageService = creditManageService;
	}

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

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Object getRetStringObject() {
		return retStringObject;
	}

	public void setRetStringObject(Object retStringObject) {
		this.retStringObject = retStringObject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CreditManageAction [logger=" + logger
				+ ", creditManageService=" + creditManageService + ", userId="
				+ userId + ", userName=" + userName + ", userGender="
				+ userGender + ", map=" + map + ", retStringObject="
				+ retStringObject + "]";
	}
}
