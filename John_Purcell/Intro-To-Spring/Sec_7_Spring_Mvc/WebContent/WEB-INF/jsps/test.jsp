<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<title>The Test Page</title>		
	</head>

	<body>
		The Test Body

		<sql:query var="rs" dataSource="jdbc/spring">
			select id, name, email, text from offers
		</sql:query>

		<c:forEach var="row" items="{rs.rows}">
			Id : ${row.id}</br>
			Name : ${row.name}</br>
			Email : ${row.email}</br>
			Text : ${row.text}</br>
		</c:forEach>
	</body>

</html>