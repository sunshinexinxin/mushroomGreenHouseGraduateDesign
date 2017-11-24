package com.hbkd.hyx.app.sence.dao.impl;

import com.hbkd.hyx.app.sence.bean.CreditList;
import com.hbkd.hyx.app.sence.dao.CreditListDao;
import com.opensymphony.xwork2.ActionContext;
import org.apache.log4j.Logger;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreditListDaoImpl extends SqlSessionDaoSupport implements CreditListDao {
	
	private Logger logger = Logger.getLogger(CreditListDaoImpl.class);

	/*点击页面直接显示信贷员*/
	@Override
	public List<CreditList> getCreditList(int pageNo) {
		List<CreditList> creditList = null;
		CreditList countCredit = null;
		logger.info("SQL_ID:UserInfoMapper.getCreditList 获取信贷员列表");
		countCredit = getSqlSession().selectOne("CreditListMapper.getCreditCount");
		ActionContext.getContext().getSession().put("countCredit", countCredit.getCount());
		creditList = getSqlSession().selectList("CreditListMapper.getCreditList",pageNo);
		logger.info("查询完毕,graduate.TB_ML_USERS_INFO表共有数据"+countCredit.getCount()+"条");
		return creditList;
	}

	/*搜索信贷员*/
	@Override
	public List<CreditList> getCreditSearch(String searchName) {
		List<CreditList> creditList = null;
		CreditList countCredit = null;
		logger.info("SQL_ID:UserInfoMapper.getCreditSearch 通过搜索获取信贷员");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchName", searchName);
		countCredit = getSqlSession().selectOne("CreditListMapper.getCreditSearchCount",map);
		ActionContext.getContext().getSession().put("countCredit", countCredit.getCount());
		creditList = getSqlSession().selectList("CreditListMapper.getCreditSearch",map);
		logger.info("查询完毕,通过关键字["+searchName+"]共搜索出数据"+countCredit.getCount()+"条");
		return creditList;
	}

}
