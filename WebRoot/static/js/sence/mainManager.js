/**
 * Created by anke on 2017/10/11.
 */
window.onload = function () {
    document.getElementById("homePage").onclick = function () {
        //发送 ajax 请求并处理
        var request = new XMLHttpRequest();
        request.open("GET", "/mushroomGreenHouseGraduateDesign/user/mushRoomMap.action");
        request.send();

        request.onreadystatechange = function () {
            if (request.readyState === 4) {
                if (request.status === 200) {
                    alert(request.response);
                } else {
                    alert("发生错误:" + request.status);
                }
            }
        }
    }
}