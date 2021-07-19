<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Add Character</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Add Character</h1>


<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/CharacterServletRegister'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	Class      :<input type="text" name="pClass" value="${form.pClass }"/>
	<span style="color: red; font-weight: 900">${errors.pClass }</span>
	<br/>
	Light Level：<input type="text" name="lightLevel" value="${form.lightLevel }"/>
	<span style="color: red; font-weight: 900">${errors.lightLevel }</span>
	<br/>
	Subclass   ：<input type="text" name="subclass" value="${form.subclass }"/>
	<span style="color: red; font-weight: 900">${errors.subclass }</span>
	<br/>	
	<input type="submit" value="Add Character"/>
</form>
  </body>
</html>
