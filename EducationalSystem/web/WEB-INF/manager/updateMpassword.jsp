<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'updateMpassword.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body bgcolor="#CCFFCC">
<%String m_id=(String)session.getAttribute("id");%>
<br>
<center><font size=6 color="blue" face="华文行楷">修改密码</font></center><br>
<form name="form1" method="post" action="servlet/updateMpassword">
    <input type="hidden" name="id" value="<%=m_id %>">
    <table width="40%" border="1" align="center">
        <tr>
            <td width="25%"><center>原始密码:</center></td>
            <td width="30%"><input type="password" name="oldpassword" id="oldpassword"></td>
        </tr>
        <tr>
            <td><center>新密码:</center></td>
            <td><input name="password1" type="password" id="password1"></td>
        </tr>
        <tr>
            <td><center>确认密码:</center></td>
            <td><input name="password2" type="password" id="password2"></td>
        </tr>
    </table><br><br>
    <center><input type="submit" name="Submit" value="提取"></center>
</form>
</body>
</html>
