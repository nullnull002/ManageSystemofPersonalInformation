<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="js/jquery-1.6.2.min.js" type="text/javascript"></script>
<script language="javascript" src="js/dateselect.js" type="text/javascript"></script>  
<title>增加日程</title>
</head>
<body background="images/topbg.jpg"><form method="post" action="MainServlet" name="findPassForm">
<input type="hidden" name="methodName" value="6" /><!--6代表 增加日程 -->
　　  <table width="569" border="0" align="center">
　　     <tr>
　　                    <th colspan="2">增加个人日程</th>
　　      </tr>
	<tr>
	 <td><h3 align="right">日期：</h3></td>
	 <td><input type="text" name="date" id='dateSelect'>
	<script>
	initDateSelect('dateSelect');	
	</script>	
	</td>
　　    </tr>
	<tr>
	 <td><h3 align="right">计划：</h3></td>
　　      <td><input type="text" name="plan" /></td>
　　    </tr>
	<tr>
　　      <td height="23">&nbsp;</td>
　　      <td><input type="submit" name="submit1" value="增加日程" />
　　      <a href="main.jsp" >取消</a></td>
　　    </tr>
</table>
</form>

</body>
</html>