<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'rankmajor.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body bgcolor="#CCFFCC">
<center><font color="blue" size="6" face="华文行楷">请输入要查询学生排名的专业</font></center><br><br>
<form name="form1"  action="./rankmajor2.jsp">
    <center><input type="text" name="smajor"></center><br><br>
    <center><input type="submit" name="submit" value="确定"></center>
</form>
</body>
</html>
