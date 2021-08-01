<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Add Armor</title>
    
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
  <h1>Add Armor</h1>


<p style="color: red; font-weight: 900"> ${msg}</p>
<form action="<c:url value='/ArmorServletRegister'/>" method="post">
	<input type="hidden" name="method" value="regist"/>
	Armor name:<input type="text" name="armorName" value="${form.armorName }"/>
	<span style="color: red; font-weight: 900">${errors.armorName }</span>
	<br/>
	Light Level：<input type="text" name="lightLevel" value="${form.lightLevel }"/>
	<span style="color: red; font-weight: 900">${errors.lightLevel }</span>
	<br/>
	Armor Type：<input type="text" name="armorType" value="${form.armorType }"/>
	<span style="color: red; font-weight: 900">${errors.armorType }</span>
	<br/>
	Rarity Type：<input type="text" name="rarity" value="${form.rarity }"/>
	<span style="color: red; font-weight: 900">${errors.rarity }</span>
	<br/>	
	Slot Type：<input type="text" name="slot" value="${form.slot }"/>
	<span style="color: red; font-weight: 900">${errors.slot }</span>
	<br/>		
	<input type="submit" value="Add Armor"/>
</form>
  </body>
</html>
