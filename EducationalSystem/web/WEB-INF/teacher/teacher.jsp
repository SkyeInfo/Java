<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'teacher.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>
<frameset rows="15%,*">
    <frame src="./t1.jsp" name="f2top">
    <frameset cols="15%,*">
        <frame src="./t2.jsp" name="f2left">
        <frame src="./t3.jsp" name="f2main">
    </frameset>
</frameset>
<body>
<%String tid = (String)session.getAttribute("id");%><br><br><br>
</body>
</html>
