<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
</head>
<body background="images/topbg.jpg">
<form method="post" action="MainServlet" name="findPassForm">
<input type="hidden" name="methodName" value="4" /><!--4代表 找回登陆密码 -->
　　  <table width="569" border="0" align="center">
　　     <tr>
　　                    <th colspan="2">找回登陆密码</th>
　　      </tr>
	<tr>
	 <td><h3 align="right">用户名：</h3></td>
　　      <td><input type="text" name="loginName" /></td>
　　    </tr>
	<tr>
	 <td><h3 align="right">邮箱：</h3></td>
　　      <td><input type="text" name="userEmail" /></td>
　　    </tr>
	<tr>
　　      <td height="23">&nbsp;</td>
　　      <td><input type="submit" name="submit1" value="找回密码" />
　　      <a href="login.jsp" target="_top">取消</a></td>
　　    </tr>
</table>
</form>
</body>
</html>