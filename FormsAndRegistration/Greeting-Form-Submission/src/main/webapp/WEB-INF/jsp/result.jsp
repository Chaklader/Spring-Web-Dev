<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chaklader
  Date: 9/29/17
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

<h2>Result</h2>

<table class="table table-striped">
    <thead>
    <tr>
        <th>#ID</th>
        <th>Content</th>
    </tr>
    </thead>

    <c:forEach var="greet" items="${greeting}">
        <tr>
            <td>${greet.id}</td>
            <td>${greet.content}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
