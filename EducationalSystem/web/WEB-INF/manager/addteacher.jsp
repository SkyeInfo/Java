<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>My JSP 'addteacher.jsp' starting page</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
</head>
<body bgcolor="#CCFFCC">
<center><font color="blue" size="6" face="隶书">添加教师操作</font></center>
<form action="servlet/addteacher" method=post onSubmit="return isValid(this);">
  <table width="35%" border="1" align="center">
    <tr>
      <td width="25%" align="center">教师工号</td>
      <td width="35%"><input type="text" name=tid></td>
    </tr>
    <tr>
      <td align="center">教师姓名</td>
      <td><input type="text" name="tname"></td>
    </tr>
    <tr>
      <td align="center">教师密码</td>
      <td><input type="text" name="tpassword"></td>
    </tr>
  </table>
  <center><input type="submit" name="Submit" value="确定"></center>
</form>
</body>
</html>
