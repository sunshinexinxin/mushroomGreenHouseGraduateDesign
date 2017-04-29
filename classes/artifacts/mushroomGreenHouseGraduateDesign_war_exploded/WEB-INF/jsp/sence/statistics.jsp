<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort()+path + "/" ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
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
				    tooltip: {
				        trigger: 'axis'
				    },
				    title: {
				        left: 'center',
				        text: '大数据量折线图',
				    },
				    legend: {
				        top: 'bottom',
				        data:['意向']
				    },
				    toolbox: {
				        show: true,
				        feature: {
				            dataView: {show: true, readOnly: false},
				            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
				            restore: {show: true},
				            saveAsImage: {show: true}
				        }
				    },
				    xAxis: {
				        type: 'category',
				        boundaryGap: false,
				        data: date
				    },
				    yAxis: {
				        type: 'value',
				        boundaryGap: [0, '100%']
				    },
				    dataZoom: [{
				        type: 'inside',
				        start: 0,
				        end: 10
				    }, {
				        start: 0,
				        end: 10
				    }],
				    series: [
				        {
				            name:'模拟数据',
				            type:'line',
				            smooth:true,
				            symbol: 'none',
				            sampling: 'average',
				            itemStyle: {
				                normal: {
				                    color: 'rgb(255, 70, 131)'
				                }
				            },
				            areaStyle: {
				                normal: {
				                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
				                        offset: 0,
				                        color: 'rgb(255, 158, 68)'
				                    }, {
				                        offset: 1,
				                        color: 'rgb(255, 70, 131)'
				                    }])
				                }
				            },
				            data: data
				        }
				    ]
				};
		
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
    
  </body>
</html>
