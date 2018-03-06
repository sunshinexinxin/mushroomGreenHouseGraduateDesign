/**
 * Created by anke on 2017/10/26.
 */
window.onload = function () {
    $("#userName").focus();
    $("#login").on("click", function () {
        if ($("#userName").val().trim() == "") {
            alert("用户名不能为空！");
            $("#userName").focus();
            return false;
        } else if ($("#userPwd").val().trim() == "") {
            alert("密码不能为空！");
            $("#userPwd").focus();
            return false;
        } else {
            $("#login").disable == true;
            return true;
        }

        //     var userName = $("#userName").val().trim().toString();
        //     var userPwd = $("#userPwd").val().trim().toString();
        //     $.ajax({
        //         url: "/mushroomGreenHouseGraduateDesign/user/login.action",
        //         type: "POST",
        //         dataType: "JSON",
        //         //是否异步执行，true异步；false同步
        //         async: false,
        //         data: {
        //             userName: userName,
        //             userPwd: userPwd
        //         },
        //         success: function (result) {
        //             if (result != null) {
        //                 console.log(result);
        //                 if (result.status == "200") {
        //                     alert("登录成功！")
        //                     // window.location = "http://wwww.baidu.com";
        //                 } else {
        //                     alert(result.message);
        //                 }
        //
        //             }
        //         },
        //         error: function (result) {
        //             console.log(result);
        //             alert("请求错误，请联系管理员");
        //         }
        //     })
    })
    // if ($("#data").val() == "0") {
    //     alert("密码错误");
    // } else if ($("#data").val() == "1") {
    //     alert("用户名错误");
    // }
}