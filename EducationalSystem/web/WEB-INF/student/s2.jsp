<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 's2.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<style type="text/css">
    a{
        color:blue;
        text-decoration:none;
    }
    a:hover{
        color:red;
        text-decoration:underline;
    }
</style>
<body bgcolor="#CCFFCC">
用户菜单:<br><br>
&nbsp;&nbsp;<a href="./updateSpassword.jsp" target="f3main"><font size="4">修改密码</font></a><br><br>
&nbsp;&nbsp;<a href="../exist.jsp" target="_top"><font size="4">退出登录</font></a><br><br>
成绩查询:<br><br>
&nbsp;&nbsp;<a href="./searchmyself.jsp" target="f3main"><font size="4">自己成绩</font></a><br><br>
&nbsp;&nbsp;<a href="./searchothers.jsp" target="f3main"><font size="4">他人成绩</font></a><br><br>
课程信息<br><br>
&nbsp;&nbsp;<a href="./showstucou.jsp" target="f3main"><font size="4">课表显示</font></a><br><br>
&nbsp;&nbsp;<a href="./selectcourse.jsp" target="f3main"><font size="4">选课</font></a><br><br>
</body>
</html>
