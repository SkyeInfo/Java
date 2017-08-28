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

    <title>My JSP 'updatecourse.jsp' starting page</title>

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

<script language=javascript>
    function isValid(){
        if(updateform.id.value==""){
            window.alert("学号不能为空！");
            return false;
        }
        if(updateform.name.value==""){
            window.alert("姓名不能为空！");
            return false;
        }
        if(updateform.password.value==""){
            window.alert("请为学生设置初始密码！");
            return false;
        }
    }
</script>
<body bgcolor="#CCFFCC">
<div align="center"><font color="blue" size="6" face="华文行楷">修改课程信息</font></div>
<%!String id,sql; %>
<%!ResultSet rs; %>
<%request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    id = request.getParameter("id");
    String sql = "select * from course where cid='"+id+"'";
    sqlBean db = new sqlBean();
    rs = db.executeQuery(sql);
    while(rs.next()){
%>
<form action="servlet/updatecourse?id=<%=id %>" method="post" name="updateform" onSubmit="return isValid()">
    <table width="55%" align="center" border="1">
        <tr>
            <td width="36%" align="center">课程号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="cid" value=<%=rs.getString("cid") %> size="16">(必填)</td>
        </tr>
        <tr>
            <td width="36%" align="center">课序号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="clnum" value=<%=rs.getString("clnum") %> size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">课程名</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="cname" value=<%=rs.getString("cname") %> size="16">(必填)</td>
        </tr>
        <tr>
            <td width="36%" align="center">学分</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="credit" value=<%=rs.getInt("credit") %> size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">课容量</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="capacity" value=<%=rs.getInt("capacity") %> size="16"></td>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;<input type="reset" value="重置">
            </td>
        </tr>
    </table><br><br>
    <center><a href="javascript:history.back()">返回</a></center>
</form>
<%}%>
</body>
</html>
