<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'delteacher.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<center><font color="blue" size="6" face="隶书">删除教师</font></center><br>
<form name="form1" method="post" action="servlet/delteacher">
    <table width="35%" border="1" align="center">
        <tr>
            <td width="25%" align="center">工号</td>
            <td width="35%"><input type="text" name="tid" ></td>
        </tr>
    </table><br>
    <center><input type="submit" name="submit" value="确定"></center>
</form>
</body>
</html>
