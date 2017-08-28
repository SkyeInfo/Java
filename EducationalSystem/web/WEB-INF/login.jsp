<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="errorpage.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="Login page">
</head>
<title>学生成绩管理系统</title>
<script type="text/javascript">
    function valid()
    {
        if(nameform.id.value == "")
        {
            window.alert("您必须完成帐号的输入!");
            document.isValid.elements(0).focus();
            return false;
        }

        if(nameform.password.value == "")
        {
            window.alert("您必须完成密码的输入!");
            document.isValid.elements(1).focus();
            return false;
        }
        nameform.submit();
    }
</script>

<body background="./public/image/2.jpg">
<center>
    <font size=6 color="red">欢迎使用学生成绩管理系统<br><br><br></font>
    <form action="servlet/check" method=post name="nameform" onSubmit="return valid(this);">
        <p>用户名：<input type="text" name="id" size="15" maxlength="18" ><br><br></p>
        <p>密码：&nbsp;&nbsp;<input type="password" name="password" size="10" ><br><br></p>
        <p>身份：
            <input type="radio" name="kind" value="manager">管理员
            <input type="radio" name="kind" value="teacher">教师
            <input type="radio" name="kind" checked value="student">学生<br><br>
        </p>
        <input name=b1 type="submit" value="确定">
        <input name=b2 type="reset" value="重置">
    </form>
</center>
<br><br><br><br><br>
<p id="time" align="right">
    <script>
        setInterval("time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay())", 1000);
    </script>
</p>
</body>
</html>
