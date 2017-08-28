<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'addstudent.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body bgcolor="#CCFFCC">
<%String m_id = (String)session.getAttribute("id"); %><br>
<center><font color="blue" size="6" face="隶书">添加学生信息</font></center><br>
<form name="form1" method="post" action="servlet/addstudent">
    <table width="35%" border="1" align="center">
        <tr>
            <td width="25%" align="center">学号</td>
            <td width="35%"><input type="text" name="sid" id="sid"></td>
        </tr>
        <tr>
            <td  align="center">姓名</td>
            <td ><input type="text" name="sname" id="sname"></td>
        </tr>
        <tr>
            <td align="center">密码</td>
            <td><input type="text" name="password" id="password"></td>
        </tr>
        <tr>
            <td align="center">班级</td>
            <td><input type="text" name="sclass" id="sclass"></td>
        </tr>
        <tr>
            <td align="center">专业</td>
            <td><input type="text" name="smajor" id="smajor"></td>
        </tr>
    </table>
    <center><input type="submit" name="Submit" value="提交"></center>
</form>
</body>
</html>
