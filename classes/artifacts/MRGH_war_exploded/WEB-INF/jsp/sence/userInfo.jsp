<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title> 个人中心</title>
    <link rel="shortcut icon" href="/mushroomGreenHouseGraduateDesign/static/image/favicon.ico"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/dpl-min.css" rel="stylesheet" type="text/css"/>
    <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/bui-min.css" rel="stylesheet" type="text/css"/>
    <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/page-min.css" rel="stylesheet" type="text/css"/>
    <!-- 下面的样式，仅是为了显示代码，而不应该在项目中使用-->
    <link href="/mushroomGreenHouseGraduateDesign/static/userInfo/css/prettify.css" rel="stylesheet" type="text/css"/>
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

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="breadcrumb">
                <li>
                    <a href="/mushroomGreenHouseGraduateDesign/user/mushRoomMap.action">首页</a>
                </li>
                <li class="active">
                    > 个人中心
                </li>
            </ul>
        </div>
    </div>
</div>

<div class="table table-bordered table-hover">
    <div class="detail-page">
        <%--<h2>用户信息</h2>--%>
        <div class="detail-section">
            <h3>基本信息</h3>
            <div class="row detail-row ">
                <div class="span8">
                    <label>编号：</label><span class="detail-text">${userBean.getUserId()}</span>
                </div>
                <div class="span8">
                    <label>姓名：</label><span class="detail-text">${userBean.getUserName()}</span>
                </div>
                <div class="span8">
                    <label>年龄：</label><span class="detail-text">${userBean.getUserAge()}</span>
                </div>
            </div>
            <div class="row detail-row">
                <div class="span8">
                    <label>手机号：</label><span class="detail-text">${userBean.getUserPhone()}</span>
                </div>
                <div class="span8">
                    <label>地址：</label><span class="detail-text">${userBean.getUserAdd()}</span>
                </div>
                <div class="span8">
                    <label>岗位：</label>
                    <span class="detail-text" id="detail-text">
                        <script type="text/javascript">
                            if (${userBean.getStatus()}==0){
                                document.getElementById("detail-text").innerHTML = "开发测试岗";
                            }else if (${userBean.getStatus()}==1) {
                                document.getElementById("detail-text").innerHTML = "管理员";
                            } else if (${userBean.getStatus()}==2) {
                                document.getElementById("detail-text").innerHTML = "普通用户";
                            }
                        </script>
                    </span>
                </div>
            </div>
            <div class="row detail-row">
                <div class="span8">
                    <label>备注：</label><span class="detail-text">${userBean.getMemo()}</span>
                </div>
                <div class="span8">
                    <label>入职时间：</label><span class="detail-text">${userBean.getCtime()}</span>
                </div>
            </div>
        </div>

        <div class="detail-section">
            <h3>
                大棚信息
            </h3>

            <div>
                <table class="table table-bordered table-hover" id="table">
                    <thead>
                    <tr bgcolor=#C1CDCD>
                        <th>大棚编号</th>
                        <th>中文名称</th>
                        <th>负责人ID</th>
                        <th>描述信息</th>
                        <th>监控状态</th>
                        <th>大棚经度</th>
                        <th>大棚纬度</th>
                        <th>大棚状态</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/userInfo/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/userInfo/js/bui-min.js"></script>
<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/userInfo/js/config-min.js"></script>

<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/js/sence/userInfo.js"></script>
<body>
</html>  

