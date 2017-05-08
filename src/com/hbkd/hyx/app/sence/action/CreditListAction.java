package com.hbkd.hyx.app.sence.action;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.hbkd.hyx.app.login.bean.User;
import com.hbkd.hyx.app.sence.bean.CreditList;
import com.hbkd.hyx.app.sence.service.CreditListService;
import com.hbkd.hyx.core.mvc.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class CreditListAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5838358082758295533L;

	Logger logger = Logger.getLogger(CreditListAction.class);
	// 注入UserService
	private CreditListService creditListService;
	// 注入属性
	private User userId = null;
	private String searchName;
	private static int pageNo;
	private String page = null;
	private List<CreditList> creditList;

	public String creditList() {
		setPageNO();
		creditList = creditListService.getCreditList(pageNo);
		logger.info(creditList.toString());
		super.getRequest().setAttribute("creditList", creditList);
		logger.info(creditList.size());
		return SUCCESS;
	}

	public String searchCredit() {
		logger.info("输入的查询关键字：" + searchName);
		creditList = creditListService.getCreditSearch(searchName);
		logger.info(creditList.toString());
		super.getRequest().setAttribute("creditList", creditList);
		return SUCCESS;
	}

	@SuppressWarnings("deprecation")
	public String creditListExport() throws IOException {
		
		creditList = creditListService.getCreditSearch("");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("信贷员列表");
		
		HSSFRow row = sheet.createRow((short) 0);
		row.createCell((short) 0).setCellValue("序号");
		row.createCell((short) 1).setCellValue("编号");
		row.createCell((short) 2).setCellValue("姓名");
		row.createCell((short) 3).setCellValue("性别");
		row.createCell((short) 4).setCellValue("生日");
		row.createCell((short) 5).setCellValue("年龄");
		row.createCell((short) 6).setCellValue("手机号");
		row.createCell((short) 7).setCellValue("邮箱地址");
		row.createCell((short) 8).setCellValue("职位");
		
		for (int i = 0; i < creditList.size(); i++) {
			HSSFRow rows = sheet.createRow((short) i+1);
			
			rows.createCell((short) 0).setCellValue(creditList.get(i).getId());
			rows.createCell((short) 1).setCellValue(creditList.get(i).getUserId());
			rows.createCell((short) 2).setCellValue(creditList.get(i).getUserName());
			rows.createCell((short) 3).setCellValue(creditList.get(i).getUserGender());
			rows.createCell((short) 4).setCellValue(creditList.get(i).getUserBir());
			rows.createCell((short) 5).setCellValue(creditList.get(i).getUserAge());
			rows.createCell((short) 6).setCellValue(creditList.get(i).getMobilePhone());
			rows.createCell((short) 7).setCellValue(creditList.get(i).getEmail());
			rows.createCell((short) 8).setCellValue(creditList.get(i).getPosition());
		}

		FileOutputStream fileOut = new FileOutputStream("../信贷员列表.xls");
		wb.write(fileOut);
		fileOut.close();
		logger.info("导出完毕");
		return SUCCESS;
	}

	public void setPageNO() {
		if (page.equals("1")) {
			pageNo = 0;
		} else if (page.equals("2")) {
			pageNo = pageNo - 9;
			if (pageNo < 0) {
				pageNo = 0;
			}
		} else if (page.equals("3")) {
			pageNo = pageNo + 9;
			if (pageNo >= Integer.parseInt(ActionContext.getContext()
					.getSession().get("countCredit").toString())) {
				pageNo = Integer.parseInt(ActionContext.getContext()
						.getSession().get("countCredit").toString()) - 9;
			}
		} else if (page.equals("4")) {
			pageNo = Integer.parseInt(ActionContext.getContext().getSession()
					.get("countCredit").toString()) - 9;
		}
		if (pageNo < 0) {
			pageNo = 0;
		}
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public CreditListService getCreditListService() {
		return creditListService;
	}

	public void setCreditListService(CreditListService creditListService) {
		this.creditListService = creditListService;
	}

	public List<CreditList> getCreditList() {
		return creditList;
	}

	public void setCreditList(List<CreditList> creditList) {
		this.creditList = creditList;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public static int getPageNo() {
		return pageNo;
	}

	public static void setPageNo(int pageNo) {
		CreditListAction.pageNo = pageNo;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CreditListAction [creditList=" + creditList
				+ ", creditListService=" + creditListService + ", logger="
				+ logger + ", page=" + page + ", searchName=" + searchName
				+ ", userId=" + userId + "]";
	}

}
