<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">CS480</h1>
<div style="font-size: 10pt;">
	<a href="<c:url value='/jsps/character/regist.jsp'/>" target="_parent">Add Character</a>|&nbsp;
	<a href="<c:url value='/jsps/character/update.jsp'/>" target="_parent">Update Character</a> |&nbsp;
	<a href="<c:url value='/jsps/character/del.jsp'/>" target="_parent">Delete Character</a> |&nbsp;
	<a href="<c:url value='/jsps/character/list.jsp'/>" target="_parent">List Characters</a> 	 		
</div>

<div style="font-size: 10pt;">
	<a href="<c:url value='/jsps/weapon/regist.jsp'/>" target="_parent">Add Weapon</a>|&nbsp;
	<a href="<c:url value='/jsps/weapon/update.jsp'/>" target="_parent">Update Weapon</a> |&nbsp;
	<a href="<c:url value='/jsps/weapon/del.jsp'/>" target="_parent">Delete Weapon</a> |&nbsp;
	<a href="<c:url value='/jsps/weapon/list.jsp'/>" target="_parent">List Weapon</a> 	
</div>

<div style="font-size: 10pt;">
	<a href="<c:url value='/jsps/armor/regist.jsp'/>" target="_parent">Add Armor</a>|&nbsp;
	<a href="<c:url value='/jsps/armor/update.jsp'/>" target="_parent">Update Armor</a> |&nbsp;
	<a href="<c:url value='/jsps/armor/del.jsp'/>" target="_parent">Delete Armor</a> |&nbsp;
	<a href="<c:url value='/jsps/armor/list.jsp'/>" target="_parent">List Armor</a> 	
</div>

  </body>
</html>
