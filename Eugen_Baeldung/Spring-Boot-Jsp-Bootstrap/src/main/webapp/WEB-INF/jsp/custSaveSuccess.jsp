<%--
  Created by IntelliJ IDEA.
  User: Chaklader
  Date: 10/9/17
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>
<html>
<head>
    <title>Customer Saved Successfully</title>
</head>
<body>
<div class="container">

    <h3>Customer Saved Successfully.</h3>

    <div id="customer">
        <strong>Customer Name:${customer.name}</strong><br>
        <strong>Customer Email:${customer.email}</strong><br>
        <strong>Customer Age:${customer.age}</strong><br>
        <strong>Customer Gender:${customer.gender}</strong><br>
        <strong>Customer Birthday:<fmt:formatDate value="${customer.birthday}" type="date"/></strong><br>
        <strong>Phone#:${customer.phone}</strong><br>
    </div>
</div>

</body>
</html>
