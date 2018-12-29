<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
    <title>Greeting</title>
</head>
<body>
<h2>Greeting</h2>

<%--@elvariable id="greeting" type="java"--%>
<form:form class="form-horizontal" method="post" modelAttribute="greeting"
           action="${pageContext.request.contextPath}/greeting">
    <br/>
    <spring:bind path="id">
        <label>Id: </label>
        <form:input path="id" placeholder="Id "/>
    </spring:bind>
    <br/>

    <spring:bind path="content">
        <label>Content: </label>
        <form:input path="content" placeholder="My content"/>
    </spring:bind>

    <br/>

    <input type="submit" value="Submit">
</form:form>


</body>
</html>
