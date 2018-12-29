<%--
  Created by IntelliJ IDEA.
  User: Chaklader
  Date: 10/3/17
  Time: 11:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<head>
    <title>Spring MVC Form Handling Example</title>

    <spring:url value="resources/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <spring:url value="resources/css/style.css" var="coreCss"/>

    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<spring:url value="/" var="urlHome"/>
<spring:url value="/users/add" var="urlAddUser"/>

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${urlHome}">Spring MVC Form</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${urlAddUser}">Add User</a></li>
            </ul>
        </div>
    </div>
</nav>