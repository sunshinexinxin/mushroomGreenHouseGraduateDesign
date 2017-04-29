<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+path + "/" ;
%>
<html>
 <head>
  <title> 个人中心</title>
  <link rel="shortcut icon" href="/mushroomGreenHouseGraduateDesign/static/image/favicon.ico" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/dpl-min.css" rel="stylesheet" type="text/css" />
  <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/bui-min.css" rel="stylesheet" type="text/css" />
  <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/page-min.css" rel="stylesheet" type="text/css" />   <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
  <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/prettify.css" rel="stylesheet" type="text/css" />
  <style type="text/css">
    code {
      padding: 0px 4px;
      color: #d14;
      background-color: #f7f7f9;
      border: 1px solid #e1e1e8;
    }
   </style>
 </head>
 <body>

  <div class="table table-bordered table-hover">
    <div class="detail-page">
      <h2>用户信息</h2>
      <div class="detail-section">  
        <h3>基本信息</h3>
        <div class="row detail-row " >
          <div class="span8">
            <label>编号：</label><span class="detail-text">${userSession.getUserId()}</span>
          </div>
          <div class="span8">
            <label>姓名：</label><span class="detail-text">${userSession.getUserName()}</span>
          </div>
           <div class="span8">
            <label>性别：</label><span class="detail-text">${userSession.getUserGender()}</span>
          </div>
        </div>
        <div class="row detail-row">
         <div class="span8">
            <label>生日：</label><span class="detail-text">${userSession.getUserBir()}</span>
          </div>
         <div class="span8">
            <label>年龄：</label><span class="detail-text">${userSession.getUserAge()}</span>
          </div>
          <div class="span8">
            <label>身高：</label><span class="detail-text">${userSession.getUserHight()}</span>
          </div>
        </div>
        <div class="row detail-row">
          <div class="span8">
            <label>体重：</label><span class="detail-text">${userSession.getUserWeight()}</span>
          </div>
          <div class="span8">
            <label>职位：</label><span class="detail-text">${userSession.getPosition()}</span>
          </div>
         <div class="span8">
            <label>手机：</label><span class="detail-text">${userSession.getMobilePhone()}</span>
          </div>
        </div>
        <div class="row detail-row">
          <div class="span8">
            <label>邮箱：</label><span class="detail-text">${userSession.getEmail()}</span>
          </div>
          <div class="span8">
            <label>家庭住址：</label><span class="detail-text">${userSession.getAddress()}</span>
          </div>
        </div>
      </div>
      <div class="detail-section"> 
        <h3>岗位信息</h3>
        <div class="row detail-row">
          <s:iterator value="userOccList" status="userInfo">
          <div class="span8">
            <label>入职时间：</label><span class="detail-text"><s:property value="occtime" /></span>
          </div>
          <div class="span8">
            <label>所属部门：</label><span class="detail-text"><s:property value="office" /></span>
          </div>
          <div class="span8">
            <label>部门领导：</label><span class="detail-text"><s:property value="leader" /></span>
          </div>
          </s:iterator>
        </div>
		
      </div>
		<div class="detail-section">
			<h3>
				人员信息
			</h3>
			<div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr bgcolor=#C1CDCD >
							<th>成员ID</th>
							<th>成员关系</th>
							<th>成员姓名</th>
							<th>出生日期</th>
							<th>联系方式</th>
							<th>电子邮箱</th>
							<th>成员职业</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="userInfoList" status="userInfo">
							<tr class="success">
								<td><s:property value="userId" /></td>
								<td><s:property value="relationShip" /></td>
								<td><s:property value="name" /></td>
								<td><s:property value="birthday" /></td>
								<td><s:property value="tel" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="position" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
  </div>

  <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/userInfo/js/jquery-1.8.1.min.js"></script>
  <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/userInfo/js/bui-min.js"></script>
  <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/userInfo/js/config-min.js"></script>
<body>
</html>  

