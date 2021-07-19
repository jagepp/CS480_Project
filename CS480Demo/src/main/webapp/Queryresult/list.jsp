<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Character Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>class</th>
		<th>light level</th>
		<th>subclass</th>
		<th>id</th>
	</tr>
<c:forEach items="${CharacterList}" var="pChar">
	<tr>
		<td>${pChar.pClass }</td>
		<td>${pChar.lightLevel }</td>
		<td>${pChar.subclass }</td>
		<td>${pChar.id }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>