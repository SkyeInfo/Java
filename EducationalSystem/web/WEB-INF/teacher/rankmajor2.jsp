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

    <title>My JSP 'rankmajor2.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body bgcolor="#CCFFCC">
<%
    request.setCharacterEncoding("utf-8");
    String smajor = new String(request.getParameter("smajor").getBytes("iso-8859-1"),"UTF-8");
    String sid="",sname="",sclass="";
    double averagepoint=0.0;
%>
<br>
<center><font size="6" color="blue">学生排名情况</font></center>
<div align="center">
    <table width="60%"  border="1">
        <tr>
            <td align="center">学号</td>
            <td align="center">姓名</td>
            <td align="center">专业</td>
            <td align="center">班级</td>
            <td align="center">平均学分积点</td>
            <td align="center">名次</td>
        </tr>
        <%
            String sql="select student.id,student.sname,student.sclass,rank.averagepoint from student,rank where student.smajor='"+smajor+"' and rank.sid=student.id group by averagepoint DESC";
            sqlBean db = new sqlBean();
            ResultSet rs = db.executeQuery(sql);
            while(rs.next()){
                int row      = rs.getRow();
                sid          = rs.getString("id");
                sname        = rs.getString("sname");
                sclass       = rs.getString("sclass");
                averagepoint = rs.getDouble("averagepoint");
        %>
        <tr>
            <td align="center"><%=sid%></td>
            <td align="center"><%=sname%></td>
            <td align="center"><%=smajor%></td>
            <td align="center"><%=sclass %></td>
            <td align="center"><%=averagepoint%></td>
            <td align="center"><%=row%></td>
        </tr>
        <%}%>
    </table>
</div>
<br>
</body>
</html>
