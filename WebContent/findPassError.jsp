<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title >找回密码失败</title>
</head>
<body background="images/topbg.jpg">
<h3 align="center"><font color="red">找回登陆密码失败，请重新找回！</font></h3> 
<% response.setHeader("refresh","1;url=findPass.jsp");%>
</body>
</html>