<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.swing.JOptionPane" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改登陆密码成功</title>
</head>
<body background="images/topbg.jpg">
<h3 align="center"><font color="red">更改成功</font></h3>
<% String msg="登陆密码修改成功，请重新登陆！";
					int type=JOptionPane.YES_NO_OPTION;
					String title="信息提示";
					JOptionPane.showMessageDialog(null,msg,title,type); %>
<script>top.location="login.jsp"</script>
 <hr width="400" size="3" color="#663300" align="right" />
</body>
</html>