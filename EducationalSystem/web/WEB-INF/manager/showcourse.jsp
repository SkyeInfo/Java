<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'showcourse.jsp' starting page</title>

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

<jsp:useBean id="a" scope="page" class="bean.course"></jsp:useBean>
<body bgcolor="#CCFFCC">
<%
    String m_id = (String)session.getAttribute("id");
    String cno="",clnum="",cname="";
    double credit=0.0;  int capacity=0;
%><br>
<center><font size="6" color="blue">所有课程名单</font></center>
<div align="center">
    <table width="60%"  border="1">
        <tr>
            <td align="center">课程号</td>
            <td align="center">课序号</td>
            <td align="center">课程名</td>
            <td align="center">学分</td>
            <td align="center">课容量</td>
            <td align=center>更改</td>
            <td align=center>删除</td>
        </tr>
        <%
            ResultSet rs = a.getCourse();
            while(rs.next()){
                cno=rs.getString("cid");
                clnum=rs.getString("clnum");
                cname=rs.getString("cname");
                credit=rs.getDouble("credit");
                capacity=rs.getInt("capacity");
        %>
        <tr>
            <td align="center"><%=cno%></td>
            <td align="center"><%=clnum%></td>
            <td align="center"><%=cname%></td>
            <td align="center"><%=credit%></td>
            <td align="center"><%=capacity%></td>
            <td width=12% align=center><a href="./updatecourse.jsp?id=<%=cno%>" >修改</a></td>
            <td width=12% align=center><a href="servlet/delcourse?id=<%=cno%>">删除</a></td>
        </tr>
        <%}%>
    </table>
</div>
<br>
</body>
</html>
