<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>My JSP 'm2.jsp' starting page</title>

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
<body bgcolor="#00FF66">
用户菜单<br>
&nbsp;&nbsp;<a href="./updateMpassword.jsp" target="f1main"><font size="2">修改密码</font></a><br>
&nbsp;&nbsp;<a href="../exist.jsp" target="_top"><font size="2">退出登陆</font></a><br>
学生管理<br>
&nbsp;&nbsp;<a href="./showstudent.jsp" target="f1main"><font size="2">显示学生信息</font></a><br>
&nbsp;&nbsp;<a href="./addstudent.jsp" target="f1main"><font size="2">添加学生</font></a><br>
教师管理<br>
&nbsp;&nbsp;<a href="./showteacher.jsp" target="f1main"><font size="2">显示教师信息</font></a><br>
&nbsp;&nbsp;<a href="./addteacher.jsp" target="f1main"><font size="2">添加教师</font></a><br>
课程管理<br>
&nbsp;&nbsp;<a href="./showcourse.jsp" target="f1main"><font size="2">显示课程信息</font></a><br>
&nbsp;&nbsp;<a href="./addcourse.jsp" target="f1main"><font size="2">添加课程</font></a><br>
成绩排名查询<br>
&nbsp;&nbsp;<a href="../teacher/rankcourse.jsp" target="f1main"><font size="2">按课程查询</font></a><br>
&nbsp;&nbsp;<a href="../teacher/rankmajor.jsp" target="f1main"><font size="2">按专业查询</font></a><br>
</body>
</html>
