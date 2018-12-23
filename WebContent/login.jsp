<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息管理系统</title>
</head>
<body background="images/loginbg.jpg">
<center><h1><font color=""></font>欢迎进入个人信息管理系统</h1></center>
<hr><p><p>
<form action="MainServlet" name="loginForm" method="post">
<input type="hidden" name="methodName" value="0" />
  <table align="center">
  <tr>
 　     <td width="120"><h3 align="right" valign="center">用户名：</h3></td>
　　  <td width="170"><input type="text" name="loginName" /></td>
  </tr>
  <tr>
   <td><h3 align="right">密码：</h3></td>
　　  <td><input type="password" name="password" /></td>
  </tr>
  <tr>
  <td><h3 align="right"><input type="submit" value="登陆" name="login"></h3></td>
  <td><h3 align="right"><input type="button" value="退出" name="exit" onclick="window.close()"></h3></td>
  </tr>
  <tr>
  <td><h3 align="right"><a class="reg" href="register.jsp">立即注册</a></h3></td>
  <td><h3 align="right"><a class="forget" href="findPass.jsp">忘记密码</a></h3></td>
  </tr>
  </table>
</form>
 <hr width="400" size="3" color="#663300" align="right" />
　　<div align="right"><span >版权&copy;:版权所有，违者必究 </span>
　　  <address>
　　  <span>  E-mail:a1441772556@gmail.com  </span>
　　  </address></div>
</body>
</html>