<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页的头部</title>
</head>
<body background="images/topbg.jpg">
<center>
		<h3>
			<font color="#0000FF"><b>欢迎<%=(String)session.getAttribute("loginName")%>使用个人信息管理系统</b></font>
		</h3>
	</center>
</body>
</html>