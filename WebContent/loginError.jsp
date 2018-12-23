<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录失败</title>
</head>
<body background="images/errorbg.jpg">
<h3 align="center"><font color="red">密码或者用户名错误，正在返回登陆页面</font></h3> 
<% response.setHeader("refresh","1;url=login.jsp");%>
 <hr width="400" size="3" color="#663300" align="right" />
　　<div align="right"><span >版权&copy;:版权所有，违者必究 </span>
　　  <address>
　　  <span>  E-mail:a1441772556@gmail.com  </span>
　　  </address></div>
</body>
</html>