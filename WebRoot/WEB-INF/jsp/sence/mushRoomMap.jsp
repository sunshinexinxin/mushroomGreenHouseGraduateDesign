<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript"
            src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-ui-1.8.22.custom.min.js"></script>

    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=bYpmt0vDGAMytit9flwnIH6G1hhiNckh"></script>

    <%--<title>地图展示</title>--%>

    <style type="text/css">
        body, html, #allmap {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
        }
    </style>

</head>
<body>
<div id="allmap">

</div>
<input type="hidden" id="mushRoomList" value='${mushRoomList}' />
<%--<input type="hidden" id="mushRoomList" value=""/>--%>
<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/js/sence/mushRoomMap.js"></script>
</body>
</html>


