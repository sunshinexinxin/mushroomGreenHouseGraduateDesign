<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'test.jsp' starting page</title>

    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <script src="/mushroomGreenHouseGraduateDesign/static/echarts/echarts.min.js"></script>

    <link rel="stylesheet" type="text/css"
          href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/admin-all.css"/>
    <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript"
            src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-ui-1.8.22.custom.min.js"></script>


</head>

<body>
<div class="alert alert-info">当前位置<b class="tip"></b>统计报表<b class="tip"></b>饼图统计</div>

<div id="main" style="width: 800px;height:600px;">
</div>


<script type="text/javascript"
        src="/mushroomGreenHouseGraduateDesign/static/js/sence/charts/echarts_bingtu.js"></script>

</body>
</html>

