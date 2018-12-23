<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="yang.bean.UserPlanBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改个人日程</title>
</head>
<body background="images/topbg.jpg">
<%UserPlanBean[] userPlan = (UserPlanBean[]) session.getAttribute("userPlan");%>
<form method="post" action="MainServlet" name="registerForm">
<input type="hidden" name="methodName" value="5" /><!-- 5代表修改个人日程 -->
　　  <table width="569" border="0" align="center">
　　                <tr>
　　                    <th colspan="2">修改个人日程</th>
　　                </tr>
		<tr>
		<td>日期</td>
		<td>计划</td>
		</tr>
		　<%for(int i = 0; i < (Integer)session.getAttribute("index");i++){%>
		<tr>
　　　		<td><input type="text" value=<%=userPlan[i].getDate()%> name="date<%=i%>"></td>
　　　		<td><input type="text" value=<%=userPlan[i].getPlan()%> name="plan<%=i%>"></td>
		</tr>
		<%}%>
		<tr>
　　      <td height="23">&nbsp;</td>
　　      <td><input type="submit" name="submit1" value="修改" />
　　      <a href="main.jsp">取消</a></td>
　　    </tr>
</table>
</form>
</body>
</html>