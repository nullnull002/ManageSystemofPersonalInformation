<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="yang.bean.UserPlanBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看日程</title>
</head>
<body background="images/topbg.jpg">
<%UserPlanBean[] userPlan = (UserPlanBean[]) session.getAttribute("userPlan");%>
<table align="center" border="1" width="400">
　　                <tr>
　　                    <th colspan="2">个人日程</th>
　　                </tr>
		<tr>
		<td>日期</td>
		<td>计划</td>
		</tr>
		　<%for(int i = 0; i < (Integer)session.getAttribute("index");i++){%>
		<tr>
　　　		<td><%=userPlan[i].getDate()%></td>
　　　		<td><%=userPlan[i].getPlan()%></td>
		</tr>
		<%}%>
</table>

</body>
</html>