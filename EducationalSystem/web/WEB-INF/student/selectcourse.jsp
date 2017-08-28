<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.course;"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'selectcourse.jsp' starting page</title>

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
<% String sid = (String)session.getAttribute("id");%>
<%!ResultSet rs; %>
<p align="center"><font size="6" color="blue" face="华文行楷">可选课程信息</font></p>
<table width="90%" border="1" cellspacing="1" cellpadding="1" align="center">
    <tr>
        <th width=12% align=center>课序号</th>
        <th width=12% align=center>教学班号</th>
        <th width=18% align=center>课程名</th>
        <th width=8% align=center>学分</th>
        <th width=8% align=center>课容量</th>
        <th width=8% align=center>选课</th>
            <%course co=new course();
	rs=co.getCourse();
	while(rs.next()){
	 String cid=rs.getString("cid");
   %>
    <tr>
        <td width=12% align=center><%=cid%></td>
        <td width=18% align=center><%=rs.getString("clnum")%></td>
        <td width=8% align=center><%=rs.getString("cname")%></td>
        <td width=8% align=center><%=rs.getDouble("credit")%></td>
        <td width=8% align=center><%=rs.getInt("capacity")%></td>
        <td width=12% align=center><a href="servlet/selectcourse?cid=<%=cid %>">选定</a></td>
    </tr>
    <%} %>
</table>
</body>
</html>
