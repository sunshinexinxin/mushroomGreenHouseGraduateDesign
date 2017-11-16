<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html>
<head>
<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/simPage/yibiaopanJs/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/simPage/yibiaopanJs/jquery-ui"></script>
<link href="/mushroomGreenHouseGraduateDesign/static/simPage/yibiaopanJs/bootstrap-combined.min.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/simPage/yibiaopanJs/bootstrap.min.js"></script>
</head>
<body >
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-9 col-sm-offset-3 col-md-15 col-md-offset-0 main">
						<h1 class="page-header"> 信贷经理 </h1>
						<div class="row placeholders">
							<div class="col-xs-6 col-sm-3 placeholder">
								<a href="#"><img alt="统计报表" class="img-responsive" src="/mushroomGreenHouseGraduateDesign/static/image/app-recommend.png" 
									style="width: 150px; height: 150px;" /></a>
								<h4>
									<b>可视化交互分析</b>
								</h4> <span class="text-muted">
										<br>可视化直观的展示数据结果，让数据自己说话，让用户听到结果。
									  </span>
							</div>
							<div class="col-xs-6 col-sm-3 placeholder">
								<a href="/mushroomGreenHouseGraduateDesign/user/creditList.action?page=1"><img alt="200x200" class="img-responsive" src="/mushroomGreenHouseGraduateDesign/static/image/app-health.png" 
									style="width: 150px; height: 150px;" /></a>
								<h4>
									人员管理
								</h4> <span class="text-muted">预留</span>
							</div>
							<div class="col-xs-6 col-sm-3 placeholder">
								<a href="#"><img alt="200x200" class="img-responsive" src="/mushroomGreenHouseGraduateDesign/static/image/app-device.png" 
									style="width: 150px; height: 150px;" /></a>
								<h4>
									消息发布
								</h4> <span class="text-muted">预留</span>
							</div>
							<div class="col-xs-6 col-sm-3 placeholder">
								<a href="#"><img alt="200x200" class="img-responsive" src="/mushroomGreenHouseGraduateDesign/static/image/githubIcon.png" 
									style="width: 150px; height: 150px;" /></a>
								<h4>
									菜单预留
								</h4> <span class="text-muted">预留</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>