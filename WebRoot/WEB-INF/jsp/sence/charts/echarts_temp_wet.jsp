
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Title</title>


    <script src="/mushroomGreenHouseGraduateDesign/static/echarts/echarts.min.js"></script>

    <link rel="stylesheet" type="text/css"
          href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/admin-all.css"/>

    <%--<script src="/mushroomGreenHouseGraduateDesign/static/echarts/echarts_temp_wet_display.js"--%>
    <%--type="text/javascript"></script>--%>
</head>
<body>

<div class="alert alert-info">首页<b class="tip"></b>数据报表统计<b class="tip"></b>温度展示</div>

<div id="main_echarts_temp_wet" style="width: 900px;height:600px;"></div>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main_echarts_temp_wet'));

    option = {
        title: {
            text: '折线图堆叠'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['空气温度', '空气湿度', '土壤温度', '土壤湿度', '光照强度','二氧化碳浓度']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: '空气温度',
                type: 'line',
                stack: '总量',
                data: [120, 132, 101, 134, 90, 230, 210]
            },
            {
                name: '空气湿度',
                type: 'line',
                stack: '总量',
                data: [220, 182, 191, 234, 290, 330, 310]
            },
            {
                name: '土壤温度',
                type: 'line',
                stack: '总量',
                data: [150, 232, 201, 154, 190, 330, 410]
            },
            {
                name: '土壤湿度',
                type: 'line',
                stack: '总量',
                data: [320, 332, 301, 334, 390, 330, 320]
            },
            {
                name: '光照强度',
                type: 'line',
                stack: '总量',
                data: [80, 92, 91, 94, 190, 130, 320]
            },
            {
                name: '二氧化碳浓度',
                type: 'line',
                stack: '总量',
                data: [80, 92, 91, 94, 190, 130, 320]
            }
        ]
    };
    myChart.setOption(option);
</script>
</body>
</html>
