<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.sqlBean;"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>课程排名</title>

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
<%
    String cid = request.getParameter("cid");
    String sid="",sname="",cname="",smajor="";
    int grade;
    double jpa=0.0;
%>
<br>
<center><font size="6" color="blue">学生排名情况</font></center>
<div align="center">
    <table width="60%"  border="1">
        <tr>
            <td align="center">学号</td>
            <td align="center">姓名</td>
            <td align="center">专业</td>
            <td align="center">课程号</td>
            <td align="center">课程名</td>
            <td align="center">总成绩</td>
            <td align="center">学分积点</td>
            <td align="center">名次</td>
        </tr>
        <%
            String sql = "select student.id,student.sname,student.smajor,score.cname,score.grade,score.jpa from score,student where score.cid='"+cid+"' and score.sid=student.id group by jpa DESC";
            sqlBean db = new sqlBean();
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                int row    = rs.getRow();
                    sid    = rs.getString("id");
                    sname  = rs.getString("sname");
                    cname  = rs.getString("cname");
                    smajor = rs.getString("smajor");
                    grade  = rs.getInt("grade");
                    jpa    = rs.getDouble("jpa");
        %>
        <tr>
            <td align="center"><%=sid%></td>
            <td align="center"><%=sname%></td>
            <td align="center"><%=smajor%></td>
            <td align="center"><%=cid%></td>
            <td align="center"><%=cname%></td>
            <td align="center"><%=grade%></td>
            <td align="center"><%=jpa%></td>
            <td align="center"><%=row%></td>
        </tr>
        <%}%>
    </table>
</div>
<br>
<center><a href="javascript:history.back()">返回</a></center>
</body>
</html>
