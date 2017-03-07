package com.hbkd.hyx.app.sence.service.impl;

import java.util.Map;

import com.hbkd.hyx.app.sence.dao.CreditManageDao;
import com.hbkd.hyx.app.sence.service.CreditManageService;


public class CreditManageServiceImpl implements CreditManageService {
	
	private CreditManageDao creditManageDao;

	public Object getCreditManage(Map<String, String> map) {
		// TODO Auto-generated method stub
		return creditManageDao.getCreditManage(map);
	}

	public CreditManageDao getCreditManageDao() {
		return creditManageDao;
	}

	public void setCreditManageDao(CreditManageDao creditManageDao) {
		this.creditManageDao = creditManageDao;
	}

}
