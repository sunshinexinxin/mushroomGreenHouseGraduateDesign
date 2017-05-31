/**
 * Created by anke on 2017/5/1.
 */


// document.write('<script src="/mushroomGreenHouseGraduateDesign/static/echarts/echarts.min.js"></script>');

// 基于准备好的dom，初始化echarts实例
document.write('<script src="/mushroomGreenHouseGraduateDesign/static/echarts/esl.js"></script>');

require(
    [
        'echarts',
        'echarts/chart/pie'
    ],
    //回调函数内执行图表对象的初始化
    function(ec) {
        var myChart = ec.init(document.getElementById('main_echarts_temp_wet_display'));
        myChart.setOption(option);
    }
);
// var myChart = require('echarts').init(document.getElementById('main_echarts_temp_wet_display'));
// var myChart = echarts.init(document.getElementById('main_echarts_temp_wet_display'));

option = {
    title: {
        text: '折线图堆叠'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['室内温度', '室内湿度', '土壤温度', '土壤湿度', 'CO2浓度']
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
            name: '室内温度',
            type: 'line',
            stack: '总量',
            data: [120, 132, 101, 134, 90, 230, 210]
        },
        {
            name: '室内湿度',
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
            name: 'CO2浓度',
            type: 'line',
            stack: '总量',
            data: [80, 92, 91, 94, 190, 130, 320]
        }
    ]
};

// 使用刚指定的配置项和数据显示图表。
// myChart.setOption(option);
// </script>


