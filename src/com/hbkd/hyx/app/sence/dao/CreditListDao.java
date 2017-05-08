package com.hbkd.hyx.app.sence.dao;

import com.hbkd.hyx.app.sence.bean.CreditList;

import java.util.List;


public interface CreditListDao {

	List<CreditList> getCreditList(int pageNo);

	List<CreditList> getCreditSearch(String searchName);

}
