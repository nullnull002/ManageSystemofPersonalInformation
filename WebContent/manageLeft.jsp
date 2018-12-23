<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body background="images/topbg.jpg">
<ul id="menu">  
		<li><a href="main.jsp" target="right">首页</a></li> 
		<li>个人信息管理模块<ul><li><a href="searchInfo.jsp" target="right">查询个人信息</a></li>
						  <!--  <li><a href="modifyUserInfo.jsp" target="right">修改个人信息</a></li>-->
						  <li><a href="modifyInfo.jsp" target="right">修改个人信息</a>
						  <li><a href="modifyPass.jsp" target="right">修改密码</a></li>
					</ul>
		</li>
		<li>日程安排管理模块<ul><li><a href="searchSchedule.jsp" target="right">查看日程</a></li>
						  <li><a href="AddSchedule.jsp" target="right">增加日程</a></li>
						  <li><a href="modifySchedule.jsp" target="right">修改日程</a></li>
						  <li><a href="deleteSchedule.jsp" target="right">删除日程</a></li>
					  </ul>
		</li> 
		<li><a href="exit.jsp" target="_top">退出登陆</a></li>
	</ul> 
</body>
</html>