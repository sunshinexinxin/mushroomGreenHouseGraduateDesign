﻿<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>商业银行贷款贷后管理系统</title>
		<link rel="shortcut icon" href="/mushroomGreenHouseGraduateDesign/static/image/favicon.ico" />
		<link rel="stylesheet" type="text/css"
			href="/mushroomGreenHouseGraduateDesign/static/main/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css"
			href="/mushroomGreenHouseGraduateDesign/static/main/Styles/base.css" />
		<link rel="stylesheet" type="text/css"
			href="/mushroomGreenHouseGraduateDesign/static/main/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css"
			href="/mushroomGreenHouseGraduateDesign/static/main/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		<script type="text/javascript"
			src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-1.7.2.js">
</script>
		<script type="text/javascript"
			src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-ui-1.8.22.custom.min.js">
</script>
		<script type="text/javascript"
			src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/index.js">
</script>
	</head>
	<body>
		<div class="warp">
			<!--头部开始-->
			<div class="top_c">
				<div class="top-menu">
					<ul class="top-menu-nav">
						<li>
							<a href="#">首页</a>
						</li>
						<li>
							<a href="#">查询界面<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-form.html">表单样式</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-alert.html">弹出窗口</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-order.html">查询排序</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-1.html">查询结果一</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-2.html">查询结果二</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">维护界面<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-add.html">增加</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main//mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-edit.html">修改</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-del.html">删除</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">表单风格<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-Master-slave.html">主从表单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-collapse.html">折叠表单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tabs.html">标签式表单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tree.html">树+表单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-guide.html">向导</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tabs-list.html">标签页+列表</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">提示<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">权限提示</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">出错提示</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">警告提示</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">询问提示</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">对话框一</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">对话框二</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">辅助信息<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/order.html">采购订单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">数据说明</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">操作记录</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">提示</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				<div class="top-nav">
					欢迎您，${userNameSession}！&nbsp;&nbsp;
					<a href="/mushroomGreenHouseGraduateDesign/user/userInfo.action"  target="Conframe">个人中心</a> |
					<a href="/mushroomGreenHouseGraduateDesign/user/logout.action">安全退出</a>
				</div>
			</div>
			<!--头部结束-->
			<!--左边菜单开始-->
			<div class="left_c left">
				<h1>
					系统操作菜单
				</h1>
				<div class="acc">
					<div>
						<a class="one">逾期客户列表</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-form.html">表单样式</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-alert.html">弹出窗口</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-order.html">查询排序</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-1.html">查询结果一</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-2.html">查询结果二</a>
							</li>
						</ul>
					</div>
					<div>
						<a class="one">欲逾期客户列表</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-add.html">增加</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-edit.html">修改</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-del.html">删除</a>
							</li>
						</ul>
					</div>
					<div>
						<a class="one">查看通知消息</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-Master-slave.html">主从表单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-collapse.html">折叠表单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tabs.html">标签式表单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tree.html">树+表单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-guide.html">向导</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tabs-list.html">标签页+列表</a>
							</li>
						</ul>
					</div>
					<div>
						<a class="one">预留菜单</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">权限提示</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">出错提示</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">警告提示</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">询问提示</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">对话框一</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">对话框二</a>
							</li>
						</ul>
					</div>
					<div>
						<a class="one">预留菜单</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/order.html">采购订单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">数据说明</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">操作记录</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">提示</a>
							</li>
						</ul>
					</div>
					<div id="datepicker"></div>
				</div>

			</div>
			<!--左边菜单结束-->
			<!--右边框架开始-->
			<div class="right_c">
				<div class="nav-tip" onclick="javascript:void(0)">
					&nbsp;
				</div>

			</div>
			<div class="Conframe">
				<iframe name="Conframe" id="Conframe"></iframe>
			</div>
			<!--右边框架结束-->

			<!--底部开始-->
			<div class="bottom_c">
				Copyright &copy;2016 王灿辉 毕业设计专用
			</div>
			<!--底部结束-->
		</div>
	</body>
</html>