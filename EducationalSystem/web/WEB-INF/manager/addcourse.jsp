<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'addcourse.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
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
            if(addform.cid.value==""){
                window.alert("课序号不能为空！");
                return false;
            }
            if(addform.cname.value==""){
                window.alert("课程名不能为空！");
                return false;
            }
            if(addform.clnum.value==""){
                window.alert("教学班号不能为空！");
                return false;
            }
        }

    </script>
<body bgcolor="#CCFFCC">
<div align="center"><font color="blue" size="6" face="华文行楷">添加课程</font></div>
<form action="servlet/addcourse" method="post" name="addform" onSubmit="return isValid()">
    <table width="55%" align="center" border="1">
        <tr>
            <td width="36%" align="center">课程号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="cid" size="16">(必填)</td>
        </tr>
        <tr>
            <td width="36%" align="center">教学班号</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="clnum" size="16">(必填)</td>
        </tr>
        <tr>
            <td width="36%" align="center">课程名</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="cname" size="16">(必填)</td>
        </tr>
        <tr>
            <td width="36%" align="center">学分</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="credit" size="16"></td>
        </tr>
        <tr>
            <td width="36%" align="center">课容量</td>
            <td width="54%">&nbsp;&nbsp;&nbsp;<input type="text" name="capacity" size="16"></td>
        </tr>
        <tr align="center">
            <td colspan="2" align="center">
                <input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;<input type="reset" name="重置">
            </td>
        </tr>
    </table>
    <br><br>
    <p><b><br><center><a href="./showcourse.jsp">返回</a></center></b></p>
</form>
</body>
</html>
