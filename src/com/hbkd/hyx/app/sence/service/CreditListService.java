package com.hbkd.hyx.app.sence.service;

import com.hbkd.hyx.app.sence.bean.CreditList;

import java.util.List;


public interface CreditListService {

	List<CreditList> getCreditList(int pageNo);

	List<CreditList> getCreditSearch(String searchName);
}
