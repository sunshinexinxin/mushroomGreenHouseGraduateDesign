/**
 * Created by anke on 2017/9/11.
 */

// 百度地图API功能
window.onload = function () {

    var map = new BMap.Map("allmap");    // 创建Map实例
    var pointCent = new BMap.Point(114.2009851142, 38.8555280387);  //创建地图中心点位置，写死即可
    map.centerAndZoom(pointCent, 17);

    $(document).ready(function () {
        var result = $("#mushRoomList").val();
        if (result) {
            var resultJSON = JSON.parse(result);
            map.setCurrentCity("阜平县");          // 设置地图显示的城市 此项是必须设置的
            map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

            var point
            $.each(resultJSON[0], function (index, value) {
                console.log("value.mushroomLong=" + value.mushroomLong + ",mushroomLat=" + value.mushroomLat);
                point = new BMap.Point(value.mushroomLong, value.mushroomLat);
                addMarker(point);
            })
        }
    });

    //移除地图点
    function removeMarker(marker) {
        alert(marker.lat + "\t" + marker.lng);
    }

    //创建标注
    function addMarker(point) {
        console.log(point);

        //地图标注icon
        var myIcon = new BMap.Icon("/mushroomGreenHouseGraduateDesign/static/image/mushroom.ico", new BMap.Size(24, 24));
        var marker = new BMap.Marker(point, {icon: myIcon});  // 创建标注
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画

        //创建右键菜单
        var markerMenu = new BMap.ContextMenu();
        markerMenu.addItem(new BMap.MenuItem('查看详情', removeMarker.bind(marker)));
        map.addOverlay(marker);// 将标注添加到地图中

        marker.addContextMenu(markerMenu);
    }
}