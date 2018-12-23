<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script language="javascript" src="js/jquery-1.6.2.min.js" type="text/javascript"></script>
<script language="javascript" src="js/dateselect.js" type="text/javascript"></script>  
</head>
<body background="images/registerbg.jpg">
<form method="post" action="MainServlet" name="registerForm">
<input type="hidden" name="methodName" value="1" />
　　  <table width="569" border="0" align="center">
　　    <tr>
　　      <td colspan="2"><h1 align="center">注册</h1></td>
　　    </tr>
　　    <tr>
	<tr>
　　      <td><h3 align="right">姓名：</h3></td>
　　      <td><input type="text" name="userName"/></td> <!--  placeholder="请输入姓名"-->
　　    </tr>
	<tr>
　　      <td><h3 align="right">性别：</h3></td>
　　      <td><input type="radio" name="userSex" value="" />男
　　      <input type="radio" name="userSex" value="" />女
	</td>
　　    </tr>
	<tr>
	<td><h3 align="right">出生年月:</h3></td>
	<td><input type="text" name="userBirthday" id='dateSelect'>
	<script>
	initDateSelect('dateSelect');	
	</script>	
	</td>
	</tr>
	<tr>
　　      <td><h3 align="right">民族：</h3></td>
　　      <td><input type="text" name="userNation" /></td>
　　    </tr>
	<tr>
　　      <td width="120"><h3 align="right" valign="center">用户名：</h3></td>
　　      <td width="170"><input type="text" name="loginName" /></td>
　　    </tr>
　　    <tr>
　　      <td><h3 align="right">密码：</h3></td>
　　      <td><input type="password" name="password" /></td>
　　    </tr>
	<tr>
　　      <td><h3 align="right">电话号码:</h3></td>
　　      <td><input type="text" name="userTelephone" /></td>
　　    </tr>
　    	<tr>
　　      <td><h3 align="right">邮箱地址:</h3></td>
　　      <td><input type="text" name="userEmail" /></td>
　　    </tr>
　　    <tr>
　　      <td><h3 align="right">家庭地址:</h3></td>
　　      <td><input type="text" name="userAddress" /></td>
　　    </tr> 
	<tr>
　　      <td height="23">&nbsp;</td>
　　      <td><input type="submit" name="submit1" value="注册" />
　　      <input type="reset" name="submit2" value="重置" /></td>
　　    </tr></table>
</form>
 <hr width="400" size="3" color="#663300" align="right" />
　　<div align="right"><span >版权&copy;:版权所有，违者必究 </span>
　　  <address>
　　  <span>  E-mail:a1441772556@gmail.com</span>
　　  </address></div>
</body>
</html>