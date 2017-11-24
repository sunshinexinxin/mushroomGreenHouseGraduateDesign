/**
 * Created by anke on 2017/11/22.
 */
window.onload = function () {

    $(document).ready(function () {
        var status = $("#status").val();
        var userID = $("#userID").val();
        $.ajax({
            url: "/mushroomGreenHouseGraduateDesign/user/getUsers.action",
            type: "GET",
            dataType: "JSON",
            data: {
                status: status,
                userID: userID
            },
            success: function (data, flag) {
                if (data.status == 200) {
                    $.each(data.data, function (index, value) {
                        var tab =
                            '<tr id=' + value.userId + '>'
                            + "<td>" + value.userId + "</td>"
                            + "<td>" + value.userName + "</td>"
                            + "<td>" + value.userAge + "</td>"
                            + "<td>" + value.userPhone + "</td>"
                            + "<td>" + value.userAdd + "</td>"
                            + "<td>" + value.status + "</td>"
                            + "<td>" + value.delFlag + "</td>"
                            + "<td>" + value.memo + "</td>"
                            + "<td>" + value.ctime + "</td>"
                            + "<td><a href='/usersManage.action?userId=" + value.userId + "' class='btn btn-mini btn-danger' id='ipt10'>删除</td>"
                            + '</tr>';
                        $('#top_table').append(tab);
                    });
                }
                var tab = '<tbody> <tr> <td colspan="100" align="right"> <a class="btn btn-mini btn-primary" id="showAddUser">添加</a> </td> </tr> <tbody>';
                $('#top_table').append(tab);
            },
            error: function (data, flag) {
                console.log(data);
            }
        });
    });

    //点击添加按钮，显示添加输入框
    $("#showAddUser").live('click', function () {
        $("#addUser").show();
    });

    //点击删除按钮，显示添加输入框
    $("#ipt10").live('click', function () {
        var url = this.href; //获取url中"?"符后的字串
        var userId = GetRequest(url).userId;
        $.ajax({
            url: "/mushroomGreenHouseGraduateDesign/user/deleteUsers.action",
            type: "GET",
            dataType: "JSON",
            async: false,
            data: {
                userID: userId
            },
            success: function (data, flag) {
                console.log(data);
                if (data.status == 200) {
                    $("#" + userId + "").hide();
                } else {
                    alert("删除失败！");
                }
            },
            error: function (data, flag) {
                console.log(data);
            }
        });
        return false;
    });

    function GetRequest(url) {
        console.log(url);
        var theRequest = new Object();
        if (url.indexOf("?") != -1) {
            var str = url.substr(url.indexOf("?") + 1);
            strs = str.split("&");
            for (var i = 0; i < strs.length; i++) {
                theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
            }
        }
        return theRequest;
    }

    //点击取消按钮，隐藏输入框
    $("#ipt8").on("click", function () {
        $("#addUser").hide();
        cleanVal();
    });

    function cleanVal() {
        $("#ipt1").val("");
        $("#ipt2").val("");
        $("#ipt3").val("");
        $("#ipt4").val("");
        $("#ipt5").val("");
        $("#ipt6").val("");
        $("#ipt7").val("");
    }

    //添加系统用户，填写完毕后点击提交
    $("#ipt9").on("click", function () {
        var ipt1 = $("#ipt1").val();
        var ipt2 = $("#ipt2").val();
        var ipt3 = $("#ipt3").val();
        var ipt4 = $("#ipt4").val();
        var ipt5 = $("#ipt5").val();
        var ipt6 = $("#ipt6").val();
        var ipt7 = $("#ipt7").val();
        $.ajax({
            url: "/mushroomGreenHouseGraduateDesign/user/addUsers.action",
            type: "POST",
            dataType: "JSON",
            data: {
                userName: ipt1,
                userPsd: ipt2,
                userAge: ipt3,
                userPhone: ipt4,
                userAdd: ipt5,
                status: ipt6,
                memo: ipt7
            },
            success: function (data, flag) {
                if (data.status == 200) {
                    $("#addUser").hide();
                    cleanVal();
                    var value = data.data;
                    var tab =
                        '<tr id=' + value.userId + '>'
                        + "<td>" + value.userId + "</td>"
                        + "<td>" + value.userName + "</td>"
                        + "<td>" + value.userAge + "</td>"
                        + "<td>" + value.userPhone + "</td>"
                        + "<td>" + value.userAdd + "</td>"
                        + "<td>" + value.status + "</td>"
                        + "<td>" + value.delFlag + "</td>"
                        + "<td>" + value.memo + "</td>"
                        + "<td>" + value.ctime + "</td>"
                        + "<td><a href='/test.test?userId=" + value.userId + "' class='btn btn-mini btn-danger' id='ipt10'>删除</td>"
                        + '</tr>';
                    $('#top_table').append(tab);
                }else if(data.status==400){
                    alert(data.message);
                }
            },
            error: function (data, flag) {
                console.log(data);
            }
        });
    });
}
