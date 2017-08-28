<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'showTinfo.jsp' starting page</title>

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
<jsp:useBean id="a" scope="page" class="bean.teacher"></jsp:useBean>
<body bgcolor="#CCFFCC">
<%
    String tid=(String)session.getAttribute("id");
%>
<center><font size=6 color="blue">您的个人信息如下</font></center>
<div align="center">
    <table width="60%" border="1">
        <tr>
            <td align="center">教工号</td>
            <td align="center">教师名</td>
            <td align="center">密码</td>
        </tr>
        <%
            ResultSet rs = a.getTeaOne(tid);
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("tname");
                String password=rs.getString("password");
        %>
        <tr>
            <td align="center"><%=id%></td>
            <td align="center"><%=name%></td>
            <td align="center"><%=password%></td>
        </tr>
        <%}%>
    </table>
</div>
</body>
</html>
