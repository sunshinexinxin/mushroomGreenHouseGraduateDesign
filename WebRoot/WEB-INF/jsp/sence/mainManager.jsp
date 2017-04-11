<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>蘑菇大棚监控系统</title>
		<link rel="shortcut icon" href="/mushroomGreenHouseGraduateDesign/static/image/favicon.ico" />
		<link rel="stylesheet" type="text/css"href="/mushroomGreenHouseGraduateDesign/static/main/Styles/admin-all.css" />
		<link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/base.css" />
		<link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
		
		<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-1.7.2.js"> </script>
		<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-ui-1.8.22.custom.min.js"> </script>
		<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/index.js"> </script>

		<script type="text/javascript">
			 function fireEvent(element,event){
			     if (document.createEventObject){
			         // dispatch for IE
			         var evt = document.createEventObject();
			         return element.fireEvent('on'+event,evt)
			     }
			     else{
			         // dispatch for firefox + others
			         var evt = document.createEvent("HTMLEvents");
			         evt.initEvent(event, true, true ); // event type,bubbling,cancelable
			         return !element.dispatchEvent(evt);
			     }
			 }
			
			 function _click(){
			 fireEvent(document.getElementById('123'), 'click'); 
			 }
		</script>

	</head>
	<body onload="_click();">
		
		<div class="warp">
			<!--头部开始-->
			<div class="top_c">
				<div class="top-menu">
					<ul class="top-menu-nav">
						<li>
							<a target="Conframe" href="/mushroomGreenHouseGraduateDesign/static/simPage/mushRoomMap.jsp" id="123" name="123">首页</a>
						</li>
						<li>
							<a href="#">信息发布<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-form.html">预留菜单</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-alert.html">预留菜单</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-order.html">预留菜单</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-1.html">预留菜单</a>
								</li>
								<li>
									<a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/find-2.html">预留菜单</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">监控中心<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-add.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-edit.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-del.html">预留菜单</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">系统管理<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/TemplatmushroomGreenHouseGraduateDesignaster-slave.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-collapse.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tabs.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tree.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-guide.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-tabs-list.html">预留菜单</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">关于<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">预留菜单<i class="tip-up"></i>
							</a>
							<ul class="kidc">
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/order.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">预留菜单</a>
								</li>
								<li>
									<b class="tip"></b><a target="Conframe"
										href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">预留菜单</a>
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
						<a class="one">数据报表统计</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/echarts_bingtu.jsp">饼图统计</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/echarts_duiji.jsp">统计分析</a>
							</li>
						</ul>
					</div>  
					<div>
						<a class="one" target="Conframe" href="/mushroomGreenHouseGraduateDesign/user/creditList.action?page=1">实时数据查询</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/user/form-collapse.action">空气温度</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/form-guide.html">土壤湿度</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-del.html">光照强度</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Maintain-del.html">二氧化碳含量</a>
							</li>
						</ul>
					</div>
					<div>
						<a class="one">预警规则管理</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预警规则制定</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">责任人指定</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/Alert.html">预留菜单</a>
							</li>
						</ul>
					</div>
					<div>
						<a class="one">远程设备管理</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/order.html">修改设备编号</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">修改设备名称</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">预留菜单</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">预留菜单</a>
							</li>
						</ul>
					</div>
						<div>
						<a class="one">系统后台管理</a>
						<ul class="kid">
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/order.html">查看管理员信息</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">修改个人信息</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">删除个人信息</a>
							</li>
							<li>
								<b class="tip"></b><a target="Conframe"
									href="/mushroomGreenHouseGraduateDesign/static/main/Template/formstyle.html">预留菜单</a>
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
				Copyright &copy;2017 韩奕昕 毕业设计专用
			</div>
			<!--底部结束-->
		</div>
		
	</body>
</html>
