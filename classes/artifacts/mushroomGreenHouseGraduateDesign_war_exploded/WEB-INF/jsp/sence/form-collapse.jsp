<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- Struts2标签引入 --%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/formui.css" />
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/base.css"/>
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/admin-all.css" />
    <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/mushroomGreenHouseGraduateDesign/static/main/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/mushroomGreenHouseGraduateDesign/static/main/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>信贷员管理<b class="tip"></b>添加信贷员</div>

    <table class="tbform list">
        <thead>
            <tr class="tr">
                <th colspan="6">信息输入 <i class="tip-up"></i></th>
            </tr>
        </thead>
        
        
       		<form action="/mushroomGreenHouseGraduateDesign/user/addCreditMessage.action" method="post">
				<input type="text" name="userId" value="" placeholder="编号" />
				<input type="text" name="userName" value="" placeholder="姓名"/>
				<input type="text" name="userGender" value="" placeholder="性别"/>
				<input type="submit" value="enter" />
			</form>
        
        <tbody>
            <tr>
                <td>编号 </td>
                <td>姓名 </td>
                <td>性别 </td>
                <td>生日 </td>
                <td>年龄 </td>
            </tr>
            <tr class="demo">
                <td>
                    <input type="text"  class="ipt" /></td>
                <td>
                    <input type="text"  class="ipt" /></td>
                <td>
                    <input type="text"  class="ipt" /></td>
                <td>
                    <input type="text"  class="ipt" /></td>
                <td>
                    <input type="text"  class="ipt" /></td>
                <td>
                    <a class="btn btn-mini btn-danger">删除</a></td>
            </tr>
              <tr>
                <td colspan="6"><a class="btn btn-mini btn-primary">添加</a></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
