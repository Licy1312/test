<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h3>你好，欢迎你注册该系统！</h3>
  	
	  <html:form action="/register.do" method="post">
	  	用户名:<html:text property="username"></html:text><br/>
	  	密&nbsp;码:<html:password property="password"></html:password><br/>
	  	邮&nbsp;箱:<html:text property="email"></html:text><br/>
	  	工作地点:<html:select property="workSpace">
	  			<html:option value="beijing">北京</html:option>
	  			<html:option value="shanghai">上海</html:option>
	  			<html:option value="chongqing">重庆</html:option>
	  			<html:option value="tianjin">天津</html:option>
	  			<html:option value="guangzhou">广州</html:option>
	  		  </html:select><br/>
	  	工作行业:<html:text property="workContent"></html:text><br/>
	  	<html:submit value="注册"></html:submit>
	  	<html:reset value="注销"></html:reset>
	  </html:form>
	  <font color=red>
	  	<c:out value="${errorInfo}"></c:out>
	  </font>
	  
  </body>
</html>
