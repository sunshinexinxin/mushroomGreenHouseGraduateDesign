/**
 * Created by anke on 2017/9/11.
 */

// 百度地图API功能
window.onload = function () {
    var map;
    var pointCent;


    $.ajax({
        url: "/mushroomGreenHouseGraduateDesign/user/mushRoomMapData.action",
        type: "GET",
        dataType: "JSON",
        data: {
            // userId: userId,
            // password: password
        },
        success: function (data, flag) {
            console.log(data.data);
            var obj1 = eval("(" + data.data + ")");
            map = new BMap.Map("allmap");    // 创建Map实例
            pointCent = new BMap.Point(114.2009851142, 38.8555280387);  //创建地图中心点位置，写死即可
            map.centerAndZoom(pointCent, 17);
            map.setCurrentCity("阜平县");          // 设置地图显示的城市 此项是必须设置的
            map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
            $.each(obj1, function (index, value) {
                // console.log("lat:" + value[1] + "\tlng:" + value[0]);
                addMarker(new BMap.Point(value[1], value[0]));
            });

        },
        error: function (data, flag) {
            console.log(flag);
            alert("error");
        }
    });


    //右键地图点事件
    function detailMarker(marker) {
        // alert(marker.lat + "\t" + marker.lng);
        window.location.href = "/mushroomGreenHouseGraduateDesign/user/echarts_bingtu.action?lat=" + marker.lat + "&lng=" + marker.lng;
    }

    //创建标注
    function addMarker(point) {
        //地图标注icon
        var myIcon = new BMap.Icon("/mushroomGreenHouseGraduateDesign/static/image/mushroom.ico", new BMap.Size(24, 24));
        var marker = new BMap.Marker(point, {icon: myIcon});  // 创建标注
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画

        //创建右键菜单
        var markerMenu = new BMap.ContextMenu();
        markerMenu.addItem(new BMap.MenuItem('查看详情', detailMarker.bind(marker)));
        map.addOverlay(marker);// 将标注添加到地图中

        marker.addContextMenu(markerMenu);
    }
}