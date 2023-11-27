<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<jsp:forward page="/home"/>   <!--  redirection server -->
		<!--<c:redirect url="/home" />    <!-- redirection client -->
		<c:choose><c:when test="1"></c:when>
		</c:choose>
</body>
</html>