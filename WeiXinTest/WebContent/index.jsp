
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="respMessage.TextMessage" %>
<%@ page import="com.qp.service.CoreService" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" >
<meta   http-equiv=refresh   content=5;URL=index.jsp> 
<title>微信后台服务器</title>

</head>
<body style="background-color: cyan;">
<h1 align="center">微信后台服务器</h1>


	<div align="center">
		<% TextMessage textMessage = (TextMessage)CoreService.textMessage;
		//TextMessage reqMessage = (TextMessage)CoreService.reqMessage;
		CoreService coservice = null;
	%>
	
		<div>
			微信用户名：<%=textMessage.getToUserName() %>
	
		
		</div>
		
	
		<div>
			发送的时间：<%=CoreService.showDate%>
	
		
		</div>
		
		<div>
			<textarea rows="10" cols="30" >
				
				发送的信息：<%=
			
					CoreService.content%>
			</textarea>
			
	
		
		</div>
		
		<div>
			<textarea rows="20" cols="30">
				返回的消息：<%=textMessage.getContent() %>
			
			</textarea>
			
		
		</div>
	
	
	
	</div>
	
	
	

</body>
</html>