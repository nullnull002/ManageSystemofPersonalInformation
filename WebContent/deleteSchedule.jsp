<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="yang.bean.UserPlanBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除日程</title>
</head>
<body background="images/topbg.jpg"><%UserPlanBean[] userPlan = (UserPlanBean[]) session.getAttribute("userPlan");%>
<form method="post" action="MainServlet" name="findPassForm">
<input type="hidden" name="methodName" value="7" /><!--7代表 删除日程 -->
<table align="center" border="1" width="400">
　　                <tr>
　　                    <th colspan="3">删除日程</th>
　　                </tr>
		<tr>
		<td>日期</td>
		<td>计划</td>
		<td>是否删除</td>
		</tr>
		　<%for(int i = 0; i < (Integer)session.getAttribute("index");i++){%>
		<tr>
　　　		<td><input type="text" value=<%=userPlan[i].getDate()%> name="date<%=i%>" readonly="readonly"></td>
　　　		<td><%=userPlan[i].getPlan()%></td>
		<td><input type="submit" value=<%=i %> name="delete"></td>
		</tr>
		<%}%>
</table>
</form>
</body>
</html>