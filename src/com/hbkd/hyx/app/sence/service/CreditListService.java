package com.hbkd.hyx.app.sence.service;

import java.util.List;

import com.hbkd.hyx.app.sence.bean.CreditList;


public interface CreditListService {

	public List<CreditList> getCreditList(int pageNo);

	public List<CreditList> getCreditSearch(String searchName);
}
