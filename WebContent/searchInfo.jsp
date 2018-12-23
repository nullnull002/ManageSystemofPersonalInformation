<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yang.bean.UserInfoBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看个人信息</title>
</head>
<body background="images/topbg.jpg">
<%UserInfoBean userInfo = (UserInfoBean)session.getAttribute("userInfo");%>
  <table align="center" border="1" width="400">
　　                <tr>
　　                    <th colspan="2">个人信息</th>
　　                </tr><tr>
　　                    <td>姓名</td>
　　                    <td><%=userInfo.getUserName()%></td>
　　                </tr>
　　                <tr>
　　                    <td>性别</td>
　　                    <td><%=userInfo.getUserSex()%></td>
　　                </tr><tr>
　　                    <td>出生日期</td>
　　                    <td><%=userInfo.getUserBirthday()%></td>
　　                </tr><tr>
　　                    <td>民族</td>
　　                    <td><%=userInfo.getUserNation()%></td>
　　                </tr> <tr>
　　                    <td>用户名</td>
　　                    <td><%=(String)session.getAttribute("loginName")%></td>
　　                </tr>
　　                <tr>
　　                     <td>电话</td>
　　                     <td><%=userInfo.getUserTelephone() %></td>
　　                </tr> <tr>
　　                    <td>邮箱地址</td>
　　                    <td><%=userInfo.getUserEmail()%></td>
　　                </tr><tr>
　　                    <td>家庭住址</td>
　　                    <td><%=userInfo.getUserAddress()%></td>
　　                </tr>
</table>
</body>
</html>