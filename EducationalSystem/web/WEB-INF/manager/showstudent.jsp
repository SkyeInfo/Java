<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'showstudent.jsp' starting page</title>

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
<jsp:useBean id="a" scope="page" class="bean.student"></jsp:useBean>
<body bgcolor="#CCFFCC">
<%
    String m_id = (String)session.getAttribute("id");
    String id="",sname="",password="",sclass="",smajor="";
%><br>
<center><font size="6" color="blue">所有学生名单</font></center>
<div align="center">
    <table width="60%"  border="1">
        <tr>
            <td align="center">学号</td>
            <td align="center">姓名</td>
            <td align="center">密码</td>
            <td align="center">专业</td>
            <td align="center">班级</td>
            <td align="center">修改</td>
            <td align="center">删除</td>
            <td align="center">课程</td>
            <td align="center">成绩</td>
        </tr>
        <%
            ResultSet rs = a.getStudent();
            while(rs.next()){
                id=rs.getString("id");
                sname=rs.getString("sname");
                password=rs.getString("password");
                sclass=rs.getString("sclass");
                smajor=rs.getString("smajor");
        %>
        <tr>
            <td align="center"><%=id%></td>
            <td align="center"><%=sname%></td>
            <td align="center"><%=password%></td>
            <td align="center"><%=smajor%></td>
            <td align="center"><%=sclass%></td>
            <td align="center"><a href="./updatestudent.jsp?s_id=<%=id%>" title="修改信息">修改</a></td>
            <td align="center"><a href="servlet/delstudent?s_id=<%=id%>" title="删除学生">删除</a></td>
            <td align="center"><a href="./showstucou.jsp?s_id=<%=id%>" title="课程">课程</a></td>
            <td align="center"><a href="./searchonescore.jsp?s_id=<%=id%>" title="成绩">成绩</a></td>
        </tr>
        <%}%>
    </table>
</div>
<br><br><br>
</body>
</html>
