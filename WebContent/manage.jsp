<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">alert("即将进入主页面！");</script>
<title>管理页面</title>
</head>
<frameset rows="25%,*">        
<frame src="manageTop.jsp"/>        
<frameset cols="30%,*">            
<frame src="manageLeft.jsp"/>            
<frame src="main.jsp" name="right"/>      
</frameset>   
 </frameset>
</html>