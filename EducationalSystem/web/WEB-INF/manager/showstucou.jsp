<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>My JSP 'showstucou.jsp' starting page</title>

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

<jsp:useBean id="a" scope="page" class="bean.studentcourse"></jsp:useBean>
<body bgcolor="#CCFFCC">
<%
  String sid = request.getParameter("s_id");
  String cid="",cname="",clnum="";
  int capacity;
  double credit;
%><br>
<center><font size="6" color="blue">你的课程名单为</font></center>
<div align="center">
  <table width="60%"  border="1">
    <tr>
      <th align="center">课程号</th>
      <th align="center">课程名</th>
      <th align="center">教学班号</th>
      <th align="center">课容量</th>
      <th align="center">学分</th>
      <th align="center">删除课程</th>
    </tr>
    <%ResultSet rs = a.getstucouone(sid);
      while(rs.next()){
        cid=rs.getString("cid");
        cname=rs.getString("cname");
        clnum=rs.getString("clnum");
        capacity=Integer.parseInt(rs.getString("capacity"));
        credit=Double.parseDouble(rs.getString("credit"));
    %>
    <tr>
      <td align="center"><%=cid%></td>
      <td align="center"><%=cname%></td>
      <td align="center"><%=clnum%></td>
      <td align="center"><%=capacity%></td>
      <td align="center"><%=credit%></td>
      <td align="center"><a href="servlet/delstucou?s_id=<%=sid%>&c_id=<%=cid %>" title="删除课程">删除课程</a></td>
      <%} %>
    </tr>
  </table>
</div>
<center><a href="./addstucourse.jsp?s_id=<%=sid%>" title="添加课程">添加课程</a></center>
<br><br><br>
<center><a href="./showstudent.jsp"><font size=5>返回</font></a></center>
</body>
</html>
