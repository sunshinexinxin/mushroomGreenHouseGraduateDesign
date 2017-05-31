<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
    
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/admin-all.css" />
  
    <script type="text/javascript">
        $(function () {
            $(".datepicker").datepicker();

            $('#find').click(function () {
                 $.dialog({
                    title: '查询结果',
                    content: 'url:Template/griddatalist.html',
                    lock: true,
					width:650,
					height:450
            			})
            })
        })

    </script>
	

  </head>
  
  <body>
  <div class="alert alert-info">当前位置<b class="tip"></b>统计报表<b class="tip"></b>饼图统计</div>
  
    <div id="main" style="width: 800px;height:600px;"></div>
        <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

       // 指定图表的配置项和数据
        /* myChart.showLoading(); */
		
		var base = +new Date(1968, 9, 3);
				var oneDay = 24 * 3600 * 1000;
				var date = [];
				
				var data = [Math.random() * 300];
				
				for (var i = 1; i < 20000; i++) {
				    var now = new Date(base += oneDay);
				    date.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('-'));
				    data.push(Math.round((Math.random() - 0.5) * 20 + data[i - 1]));
				}
				
				option = {
					    title : {
					        text: '贷款主要用途分布',
					        subtext: '饼图',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c} ({d}%)"
					    },
					    legend: {
					        orient: 'vertical',
					        left: 'left',
					        data: ['畜牧服务','农业服务','市场零售','种植加工','农副产品加工']
					    },
					    series : [
					        {
					            name: '访问来源',
					            type: 'pie',
					            radius : '55%',
					            center: ['50%', '60%'],
					            data:[
					                {value:335, name:'畜牧服务'},
					                {value:310, name:'农业服务'},
					                {value:234, name:'市场零售'},
					                {value:135, name:'种植加工'},
					                {value:1548, name:'农副产品加工'}
					            ],
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
					};

		
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
  </body>
</html>

