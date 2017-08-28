<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 't2.jsp' starting page</title>

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
**********
&nbsp;&nbsp;<a href="./showTinfo.jsp" target="f2main"><font size="4">个人信息</font></a><br><br>
&nbsp;&nbsp;<a href="./updateTpassword.jsp" target="f2main"><font size="4">修改密码</font></a><br><br>
&nbsp;&nbsp;<a href="../exist.jsp" target="_top"><font size="4">退出登录</font></a><br><br>
**********
&nbsp;&nbsp;<a href="./showstudent.jsp" target="f2main"><font size="4">学生信息</font></a><br><br>
&nbsp;&nbsp;<a href="./rankcourse.jsp" target="f2main"><font size="4">课程排名</font></a><br><br>
&nbsp;&nbsp;<a href="./rankmajor.jsp" target="f2main"><font size="4">专业排名</font></a><br><br>
</body>
</html>
