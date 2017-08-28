<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page import="bean.sqlBean"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'updatestudent.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
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
<div align="center"><font color="blue" size="6" face="华文行楷">修改学生信息</font></div>
<%!String sid,sql,sex; %>
<%!ResultSet rs; %>
<%request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    sid=request.getParameter("s_id");
    String sql = "select * from student where id='"+sid+"'";
    sqlBean db = new sqlBean();
    rs = db.executeQuery(sql);
    while(rs.next()){
%>
<form action="servlet/updatestudent?sid=<%=sid %>" method="post" name="updateform" onSubmit="return isValid()">
    <table width="55%" align="center" border="1">
        <tr>
            <td width="36%" align="center">学号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="sid" value=<%=rs.getString("id") %> size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">姓名</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="sname" value=<%=rs.getString("sname") %> size="16">(必填)</td>
        </tr>
        <tr>
            <td width="36%" align="center">专业</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="smajor" value=<%=rs.getString("smajor") %> size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">班级</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="sclass" value=<%=rs.getString("sclass") %> size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">初始密码</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="password" value=<%=rs.getString("password") %> size="16">(必填)</td>
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
