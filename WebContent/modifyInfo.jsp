<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="yang.bean.UserInfoBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人信息</title>
</head>
<body background="images/topbg.jpg">
<%UserInfoBean userInfo =(UserInfoBean)session.getAttribute("userInfo");%> 
<form method="post" action="MainServlet" name="registerForm">
<input type="hidden" name="methodName" value="2" /><!-- 2 代表修改个人信息 -->
　　  <table width="569" border="0" align="center">
　　     <tr>
　　                    <th colspan="2">修改个人信息</th>
　　      </tr>
　　    <tr>
	<tr>
　　      <td><h3 align="right">姓名：</h3></td>
　　      <td><input type="text" name="userName" value="<%=userInfo.getUserName()%>"/></td>
　　    </tr>
	<tr>
　　      <td><h3 align="right">性别：</h3></td>
　　      <td>
	<input type="radio" name="userSex" value="男" <%= ("男".equals(userInfo.getUserSex()))?"checked":"" %>/>男
　　      <input type="radio" name="userSex" value="女"<%= ("女".equals(userInfo.getUserSex()))?"checked":"" %>/>女
	</td>
　　    </tr>
	<tr>
	<td><h3 align="right">出生年月:</h3></td>
	<td><input type="text" name="userBirthday" id='dateSelect' value="<%=userInfo.getUserBirthday() %>">
	<!--  <script>
	initDateSelect();	
	</script>-->	
	</td>
	</tr>
	<tr>
　　      <td><h3 align="right">民族：</h3></td>
　　      <td><input type="text" name="userNation"value="<%=userInfo.getUserNation() %> "/></td>
　　    </tr>
	<!--<tr>
　　        <td width="120"><h3 align="right" valign="center">用户名：</h3></td>
　　      <td width="170"><input type="text" name="loginName" value="<%=(String)session.getAttribute("loginName") %>"/></td>
　　    </tr>
-->
	<tr>
　　      <td><h3 align="right">电话号码:</h3></td>
　　      <td><input type="text" name="userTelephone" value="<%=userInfo.getUserTelephone() %>"/></td>
　　    </tr>
　    	<tr>
　　      <td><h3 align="right">邮箱地址:</h3></td>
　　      <td><input type="text" name="userEmail" value="<%=userInfo.getUserEmail() %>"/></td>
　　    </tr>
　　    <tr>
　　      <td><h3 align="right">家庭地址:</h3></td>
　　      <td><input type="text" name="userAddress"value="<%=userInfo.getUserAddress() %>"/></td>
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