<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.student;"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'searchmyself.jsp' starting page</title>

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

<jsp:useBean id="a" scope="page" class="bean.coursescore"/>
<jsp:useBean id="b" scope="page" class="bean.course"></jsp:useBean>
<body bgcolor="#CCFFCC">&nbsp;
<%
    String sid = (String)session.getAttribute("id");
    String cno="",cname="";
    int pscore=0,qscore=0,grade=0;
    double credit=0.0,kpoint=0.0;
%>
<center><font size=6 color="blue">你的成绩为：</font></center>
<div align="center">
    <table width="75%"  border="1">
        <tr>
            <td align="center">课程号</td>
            <td align="center">课程名</td>
            <td align="center">学分</td>
            <td align="center">平时成绩</td>
            <td align="center">期末成绩</td>
            <td align="center">成绩</td>
            <td align="center">学分积点</td>
            <td align="center">查看排名</td>
        </tr>
        <%
            student st=new student();
            ResultSet rs1 = st.getSname(sid);
            ResultSet rs = a.getScoreone(sid);
            while(rs.next()){
                cno=rs.getString("cid");
                cname=rs.getString("cname");
                credit=rs.getDouble("credit");
                pscore=rs.getInt("pscore");
                qscore=rs.getInt("qscore");
                grade=rs.getInt("grade");
                kpoint=rs.getDouble("jpa");
        %>
        <tr>
            <td align="center"><%=cno%></td>
            <td align="center"><%=cname%></td>
            <td align="center"><%=credit%></td>
            <td align="center"><%=pscore%></td>
            <td align="center"><%=qscore%></td>
            <td align="center"><%=grade%></td>
            <td align="center"><%=kpoint%></td>
            <td align="center"><a href="../teacher/rankcourse2.jsp?cid=<%=cno%>" title="查看排名">查看排名</a></td>
        </tr>
        <%}%>
    </table>
</div>
<br>
<center><a href="javascript:history.back()">返回</a></center>
</body>
</html>
