<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改登陆密码</title>
</head>
<body background="images/topbg.jpg">
<form method="post" action="MainServlet" name="registerForm">
<input type="hidden" name="methodName" value="3" /><!-- 3代表修改密码-->
　　  <table width="569" border="0" align="center">
　　     <tr>
　　                    <th colspan="2">修改登陆密码</th>
　　      </tr>
	<tr>
	 <td><h3 align="right">密码：</h3></td>
　　      <td><input type="password" name="password" /></td>
　　    </tr>
	<tr>
　　      <td height="23">&nbsp;</td>
　　      <td><input type="submit" name="submit1" value="修改" />
　　      <a href="manage.jsp" target="_top">取消</a></td>
　　    </tr>
</table>
</form>
</body>
</html>