<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chaklader
  Date: 10/3/17
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>

<jsp:include page="header.jsp"/>
<body>

<div class="container">

    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>

    <h1>All Users</h1>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>#ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>framework</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:forEach var="framework" items="${user.framework}" varStatus="loop">
                    ${framework}
                    <c:if test="${not loop.last}">,</c:if>
                </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
