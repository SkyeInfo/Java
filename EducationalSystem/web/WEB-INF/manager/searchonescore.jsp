<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.coursescore;"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'searchonescore.jsp' starting page</title>

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
<%String id = request.getParameter("s_id").trim();%>
<center>学号为<font size=5 color="blue"><%=id%></font>的学生成绩为:</center>
<div>
    <table width="60%" border="1" align="center">
        <tr>
            <th align="center">课程号</th>
            <th align="center">课程名</th>
            <th align="center">学分</th>
            <th align="center">平时成绩</th>
            <th align="center">期末成绩</th>
            <th align="center">总成绩</th>
            <th align="center">学分积点</th>
            <th align="center">修改成绩</th>
        </tr>
        <%
            ResultSet rs = a.getScoreone(id);
            while(rs.next()){
                String cno=rs.getString("cid");
                String cname=rs.getString("cname");
                double credit=rs.getDouble("credit");
                int pscore=rs.getInt("pscore");
                int qscore=rs.getInt("qscore");
                int grade=rs.getInt("grade");
                double jpa=rs.getDouble("jpa");
        %>
        <tr>
            <td align="center"><%=cno%>
            <td align="center"><%=cname%>
            <td align="center"><%=credit%>
            <td align="center"><%=pscore%>
            <td align="center"><%=qscore%>
            <td align="center"><%=grade%>
            <td align="center"><%=jpa%>
            <td align="center"><a href="./updatescore.jsp?s_id=<%=id%>&c_id=<%=cno%>" title="修改成绩">修改成绩</a></td>
        </tr>
        <%}%>
    </table></div>
<br>
<center><a href="./showstudent.jsp"><font size=5>返回</font></a></center>
</body>
</html>
