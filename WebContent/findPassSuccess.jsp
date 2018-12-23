<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.swing.JOptionPane" %>
    <%@ page import="yang.bean.UserInfoBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码成功</title>
</head>
<body background="images/topbg.jpg">
<body>
<h3 align="center"><font color="red">更改成功</font></h3>
<%	UserInfoBean userInfo = (UserInfoBean)session.getAttribute("userInfo");%>
<% String msg= "你的密码是"+userInfo.getPassword()+"请重新登陆";
					int type=JOptionPane.YES_NO_OPTION;
					String title="信息提示";
					JOptionPane.showMessageDialog(null,msg,title,type); %>
<script>top.location="login.jsp"</script>
</body>
</html>