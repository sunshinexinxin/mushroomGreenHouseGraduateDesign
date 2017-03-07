package com.hbkd.hyx.app.sence.dao;

import java.util.List;

import com.hbkd.hyx.app.sence.bean.CreditList;


public interface CreditListDao {

	public List<CreditList> getCreditList(int pageNo);

	public List<CreditList> getCreditSearch(String searchName);

}
