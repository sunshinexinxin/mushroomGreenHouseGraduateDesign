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
                        var stat;
                        var del;
                        if (value.status == 0) {
                            stat = '开发测试岗';
                        } else if (value.status == 1) {
                            stat = '普通用户';
                        } else if (value.status == 2) {
                            stat = '管理员';
                        }
                        if (value.delFlag == 0) {
                            del = "在岗";
                        } else if (value.delFlag == 1) {
                            del = '离职';
                        }
                        var tab =
                            '<tr id=' + value.userId + '>'
                            + "<td>" + value.userId + "</td>"
                            + "<td>" + value.userName + "</td>"
                            + "<td>" + value.userAge + "</td>"
                            + "<td>" + value.userPhone + "</td>"
                            + "<td>" + value.userAdd + "</td>"
                            + "<td>" + stat + "</td>"
                            + "<td>" + del + "</td>"
                            + "<td>" + value.memo + "</td>"
                            + "<td>" + value.ctime + "</td>"
                            + "<td><a href='/usersManage.action?userId=" + value.userId + "' class='btn btn-mini btn-danger' id='ipt10'>删除</td>"
                            + '</tr>';
                        $('#top_table').append(tab);
                    });
                }
                var tab = '<tbody> <tr> <td colspan="100" align="right"> <input type="button" class="btn btn-mini btn-primary" value="添加" id="showAddUser"/> </td> </tr> <tbody>';
                $('#top_table').append(tab);
            },
            error: function (data, flag) {
                console.log(data);
            }
        });
    });

    //点击添加按钮，显示添加输入框
    $(function () {
        $("#showAddUser").live('click', function () {
            $("#showAddUser").attr('disabled', true);
            $("#ipt9").attr('disabled', true);
            $("#addUser").show();
        });
    })

    //点击删除按钮，显示添加输入框
    $(function () {
        $("#ipt10").live('click', function () {
            if (!del()) {
                return false;
            }
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
    })

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
        $("#showAddUser").attr('disabled', false);
        $("#ipt9").attr('disabled', true);
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
                    $("#showAddUser").attr('disabled', false);
                    cleanVal();
                    var value = data.data;
                    var stat;
                    var del;
                    if (value.status == 0) {
                        stat = '开发测试岗';
                    } else if (value.status == 1) {
                        stat = '普通用户';
                    } else if (value.status == 2) {
                        stat = '管理员';
                    }
                    if (value.delFlag == 0) {
                        del = "在岗";
                    } else if (value.delFlag == 1) {
                        del = '离职';
                    }
                    var tab =
                        '<tr id=' + value.userId + '>'
                        + "<td>" + value.userId + "</td>"
                        + "<td>" + value.userName + "</td>"
                        + "<td>" + value.userAge + "</td>"
                        + "<td>" + value.userPhone + "</td>"
                        + "<td>" + value.userAdd + "</td>"
                        + "<td>" + stat + "</td>"
                        + "<td>" + del + "</td>"
                        + "<td>" + value.memo + "</td>"
                        + "<td>" + value.ctime + "</td>"
                        + "<td><a href='/test.test?userId=" + value.userId + "' class='btn btn-mini btn-danger' id='ipt10'>删除</td>"
                        + '</tr>';
                    $('#top_table').append(tab);
                } else if (data.status == 400) {
                    alert(data.message);
                }
            },
            error: function (data, flag) {
                console.log(data);
            }
        });
    });


    //处理姓名输入框获得焦点和失去焦点
    $(function () {
        $('#ipt1').focus(function () {
            var ip1 = $('#ipt1').val();
            if ($.trim(ip1) == '输入姓名') {
                $('#ipt1').val('');
            }
        });
        $('#ipt1').blur(function () {
            var str = $(this).val();
            str = $.trim(str);
            if (str == '') {
                $('#ipt1').val('输入姓名');
            }
            validateUserMessage();
        });
    })

    //处理密码输入框获得焦点和失去焦点
    $(function () {
        $('#ipt2').focus(function () {
            var ip2 = $('#ipt2').val();
            if ($.trim(ip2) == '输入密码') {
                $('#ipt2').val('');
            }
        });
        $('#ipt2').blur(function () {
            var str = $(this).val();
            str = $.trim(str);
            if (str == '') {
                $('#ipt2').val('输入密码');
            }
            validateUserMessage();
        });
    })

    //处理年龄输入框获得焦点和失去焦点
    $(function () {
        $('#ipt3').focus(function () {
            var ip3 = $('#ipt3').val();
            if ($.trim(ip3) == '输入年龄，1-99岁') {
                $('#ipt3').val('');
            }
        });
        $('#ipt3').blur(function () {
            var str = $(this).val();
            str = $.trim(str);
            if (!validateUserAge(str)) {
                $('#ipt3').val('输入年龄，1-99岁');
            }
            validateUserMessage();
        });
    })

    //处理手机号输入框获得焦点和失去焦点
    $(function () {
        $('#ipt4').focus(function () {
            var ip4 = $('#ipt4').val();
            if ($.trim(ip4) == '输入正确手机号') {
                $('#ipt4').val('');
            }
        });
        $('#ipt4').blur(function () {
            var str = $(this).val();
            str = $.trim(str);
            if (!validateUserPhone(str)) {
                $('#ipt4').val('输入正确手机号');
            }
            validateUserMessage();
        });
    })

    //处理家庭地址和备注输入框获得焦点和失去焦点
    $(function () {
        $('#ipt5').blur(function () {
            validateUserMessage();
        });
        $('#ipt7').blur(function () {
            validateUserMessage();
        });
    })

    //验证年龄为0-99的两位数
    function validateUserAge(age) {
        var regNum = /^[0-9]{1,2}$/;
        if (regNum.test(age)) {
            return true;
        } else {
            return false;
        }
    }

    //验证130-139,150-159,180-189号码段的手机号码
    function validateUserPhone(phone) {
        var regNum = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
        if (regNum.test(phone)) {
            return true;
        } else {
            return false;
        }
    }

    //判断输入框是否都填写正确
    function validateUserMessage() {
        var ip1 = $('#ipt1').val();
        var ip2 = $('#ipt2').val();
        var ip3 = $('#ipt3').val();
        var ip4 = $('#ipt4').val();
        var ip5 = $('#ipt5').val();
        var ip7 = $('#ipt7').val();
        if ((ip1 == '输入姓名') | (ip2 == '输入密码') | (ip3 == '输入年龄，1-99岁') |
            (ip4 == '输入正确手机号') | ($.trim(ip4) == '') | ($.trim(ip5) == '')
            | ($.trim(ip7) == '')) {
            return false;
        } else {
            $("#ipt9").attr('disabled', false);
            return true;
        }
    }

    function del() {
        if (!confirm("确定要删除吗？删除后将不可恢复！")) {
            return false;
        } else {
            return true;
        }
    }

}
