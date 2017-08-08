<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <s:debug />      <!-- 输出上下文值栈信息 -->
 	<s:property value="exception.message"/>  <!-- 输出throw抛出的异常对象 -->
     <s:property value="exceptionStack"/>     <!-- 输出异常堆栈详细信息，利于调试 --> 
</body>
</html>