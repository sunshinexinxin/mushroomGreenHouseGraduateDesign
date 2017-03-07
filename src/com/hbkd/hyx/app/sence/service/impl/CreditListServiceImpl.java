package com.hbkd.hyx.app.sence.service.impl;

import java.util.List;

import com.hbkd.hyx.app.sence.bean.CreditList;
import com.hbkd.hyx.app.sence.dao.CreditListDao;
import com.hbkd.hyx.app.sence.service.CreditListService;


public class CreditListServiceImpl implements CreditListService {

	private CreditListDao creditListDao;

	public List<CreditList> getCreditList(int pageNo) {
		return creditListDao.getCreditList(pageNo);
	}

	public List<CreditList> getCreditSearch(String searchName) {
		return creditListDao.getCreditSearch(searchName);
	}

	public CreditListDao getCreditListDao() {
		return creditListDao;
	}

	public void setCreditListDao(CreditListDao creditListDao) {
		this.creditListDao = creditListDao;
	}

}
