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

    <title>My JSP 'updatescore.jsp' starting page</title>

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
<div align="center"><font color="blue" size="6" face="华文行楷">修改学生成绩</font></div>
<%!String sid,sql,cid,cname; %>
<%!int pscore,qscore,score;
    double credit; %>
<%!ResultSet rs; %>
<%request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    sid = request.getParameter("s_id");
    cid = request.getParameter("c_id");
    String sql = "select * from score where sid ='"+sid+"' and cid='"+cid+"'";
    sqlBean db = new sqlBean();
    rs=db.executeQuery(sql);
    while(rs.next()){
%>
<form action="servlet/updatescore?sid=<%=sid %>&cid=<%=cid %>" method="post" name="updateform" onSubmit="return isValid()">
    <table width="55%" align="center" border="1">
        <tr>
            <td width="36%" align="center">学号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<%=rs.getString("sid") %><size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">课序号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<%=rs.getString("cid") %> <size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">课程名</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<%=rs.getString("cname") %> <size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">学分</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<%=rs.getString("credit") %> <size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">平时成绩</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="pscore" value=<%=rs.getString("pscore") %> size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">期末成绩</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="qscore" value=<%=rs.getString("qscore") %> size="16"></td>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
            </td>
        </tr>
        <%} %>
    </table><br><br>
    <center><a href="javascript:history.back()">返回</a></center>
</form>
</body>
</html>
