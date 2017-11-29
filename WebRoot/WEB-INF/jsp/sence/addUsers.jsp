<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title></title>

    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/min/Styles/bootstrap.min.css"/>

    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/formui.css"/>
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/admin-all.css"/>
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/base.css"/>
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/ui-lightness/jquery-ui-1.8.22.custom.css"/>

    <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-ui-1.8.22.custom.min.js"></script>

</head>
<body>

<div class="alert alert-info">当前位置<b class="tip"></b>系统后台管理<b class="tip"></b>系统用户配置</div>
<div>
    <input type="hidden" id="status" value="${userBean.getStatus()}">
    <input type="hidden" id="userID" value="${userBean.getUserId()}">
</div>

<div>
    <table class="tbform list" id="top_table">
        <thead>
        <tr class="tr">
            <th colspan="100">当前系统用户 <i class="tip-up"></i></th>
        </tr>
        </thead>

        <thead>
        <tr>
            <th>用户ID</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>手机号</th>
            <th>家庭地址</th>
            <th>用户岗位</th>
            <th>用户状态</th>
            <th>备注</th>
            <th>添加时间</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>

<div style="display:none;" id="addUser">
    <table class="tbform list">
        <thead>
        <tr class="tr">
            <th colspan="100">添加系统用户 <i class="tip-up"></i></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>姓名</td>
            <td>用户密码</td>
            <td>年龄</td>
            <td>手机号</td>
            <td>家庭地址</td>
        </tr>
        <tr>
            <td><input type="text" class="ipt" id="ipt1" value="输入姓名"/></td>
            <td><input type="password" class="ipt" id="ipt2" value="输入密码"/></td>
            <td><input type="text" class="ipt" id="ipt3" value="输入年龄，1-99岁"/></td>
            <td><input type="text" class="ipt" id="ipt4" value=""/></td>
            <td><input type="text" class="ipt" id="ipt5"/></td>
        </tr>
        <br/>
        <tr>
            <td>用户岗位</td>
            <td>备注</td>
        </tr>
        <tr>
            <%--<td><input type="text" class="ipt" id="ipt6"/></td>--%>
        <td>
            <select id="ipt6">
                <option value="1">普通员工</option>
                <option value="2">管理人员</option>
            </select>

        </td>
            <td><input type="text" class="ipt" id="ipt7"/></td>
            <td><a class="btn btn-mini btn-danger" id="ipt8">取消</a></td>
            <td><input type="button"  value="提交" id="ipt9" class="btn btn-mini btn-primary" disabled="disabled"/></td>
        </tr>
        </tbody>
    </table>
</div>


<script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/js/sence/addUsers.js"></script>
</body>


</html>
