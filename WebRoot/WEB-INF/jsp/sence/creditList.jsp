<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
<head>
	<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/creditList/js/jquery-2.0.0.min.js"></script>
	<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/creditList/js/jquery-ui"></script>
	<link href="/mushroomGreenHouseGraduateDesign/static/creditList/css/bootstrap-combined.min.css" rel="stylesheet" media="screen">
	<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/creditList/js/bootstrap.min.js"></script>
	
	 <link href="/mushroomGreenHouseGraduateDesign/static/paging/css/bootstrap.min.css" rel="stylesheet">
    <script src="/mushroomGreenHouseGraduateDesign/static/paging/js/jquery-1.11.1.min.js"></script>
    <script src="/mushroomGreenHouseGraduateDesign/static/paging/js/bootstrap.js"></script>
    <script src="/mushroomGreenHouseGraduateDesign/static/paging/js/extendPagination.js"></script>
	
</head>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12"> 
			<p>
				<form action="/mushroomGreenHouseGraduateDesign/user/creditListExport.action" method="post" >
					<div style="width:3%;padding:0;margin:0;float:left;box-sizing:border-box;">
						<button class="btn btn-small btn-primary" type="submit" >导出</button>
					</div>
				</form>
				<form action="/mushroomGreenHouseGraduateDesign/user/searchCredit.action" method="post" align="right">
					<div style="width:97%;padding:0;margin:0;float:left;box-sizing:border-box;">
						<input name="searchName" class="input-medium search-query" type="text" placeholder="请输入姓名"/>
						<button class="btn btn-mini" type="submit">查找</button>
					</div>
				</form>
			</p>
			
			<div>&nbsp;</div>
			<table class="table table-bordered table-hover">
				<thead>
					<tr bgcolor=#C1CDCD>
					
						<th>序号</th>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>生日</th>
						<th>年龄</th>
						<th>手机号</th>
						<th>邮箱地址</th>
						<th>职位</th>
						<th>属性</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="creditList" status="creditList">
						<tr><%-- class="success"、error、warning、info --%>
							<td><s:property value="id" /></td>
							<td><s:property value="userId" /></td>
							<td><s:property value="userName" /></td>
							<td><s:property value="userGender" /></td>
							<td><s:property value="userBir" /></td>
							<td><s:property value="userAge" /></td>
							<td><s:property value="mobilePhone" /></td>
							<td><s:property value="email" /></td>
							<td><s:property value="position" /></td>
							<td><button type="button" ><a href="/mushroomGreenHouseGraduateDesign/user/userInfo.action?userNo=${userId}">详情</a></button></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		<div class="pagination pagination-right" align="right">
			<ul>
				<li><a href="/mushroomGreenHouseGraduateDesign/user/creditList.action?page=1">首页</a></li>
				<li><a href="/mushroomGreenHouseGraduateDesign/user/creditList.action?page=2">上一页</a></li>
				<li><a href="/mushroomGreenHouseGraduateDesign/user/creditList.action?page=3">下一页</a></li>
				<li><a href="/mushroomGreenHouseGraduateDesign/user/creditList.action?page=4">尾页</a></li>
			</ul>
		</div> 
		</div>
	</div>
</div>
</body>
</html>