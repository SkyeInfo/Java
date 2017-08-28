<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.coursescore"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'searchoneself1.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
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
</head>
<jsp:useBean id="a" scope="page" class="bean.coursescore"></jsp:useBean>
<body bgcolor="#CCFFCC"><br>
<%String id=request.getParameter("s_id").trim();%>
<center>学号为<font size=5 color="blue"><%=id%></font>的学生成绩为:</center>
<div>
    <table width="60%" border="1" align="center">
        <tr>
            <th align="center">课程号</th>
            <th align="center">课程名</th>
            <th align="center">学分</th>
            <th align="center">平时成绩</th>
            <th align="center">期末成绩</th>
            <th align="center">成绩</th>
            <th align="center">学分积点</th>
        </tr>
        <%
            ResultSet rs=a.getScoreone(id);
            while(rs.next()){
                String cno=rs.getString("cid");
                String cname=rs.getString("cname");
                double credit=rs.getDouble("credit");
                double pscore=rs.getDouble("pscore");
                double qscore=rs.getDouble("qscore");
                double grade=rs.getDouble("grade");
                double kpoint=rs.getDouble("jpa");
        %>
        <tr>
            <td align="center"><%=cno%>
            <td align="center"><%=cname%>
            <td align="center"><%=credit%>
            <td align="center"><%=pscore%>
            <td align="center"><%=qscore%>
            <td align="center"><%=grade%>
            <td align="center"><%=kpoint%>
        </tr>
        <%} %>
    </table></div>
<br>
<center><a href="javascript:history.back()"><font size=5>返回</font></a></center>
</body>
</html>
