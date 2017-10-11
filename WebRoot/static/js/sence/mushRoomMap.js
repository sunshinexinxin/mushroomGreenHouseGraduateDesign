/**
 * Created by anke on 2017/9/11.
 */

// 百度地图API功能
window.onload = function () {
    // var data = document.getElementById('mushRoomList').value;
    var data = null;
    $(document).ready(function () {

        var result1 = $("#mushRoomList").val();
        alert("result1 = " + result1);
    });

    var map = new BMap.Map("allmap");    // 创建Map实例
    var point1 = new BMap.Point(114.198535, 38.857697);
    var point2 = new BMap.Point(114.199146, 38.857697);
    var point3 = new BMap.Point(114.198535, 38.857402);
    map.centerAndZoom(point1, 18);  // 初始化地图,设置中心点坐标和地图级别

    map.setCurrentCity("阜平县");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放

    addMarker(point1);
    addMarker(point2);
    addMarker(point3);

    创建标注
    function addMarker(point) {
        var marker = new BMap.Marker(point);// 创建标注
        map.addOverlay(marker);// 将标注添加到地图中
        marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
    }

}