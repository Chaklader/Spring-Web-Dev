<%--
  Created by IntelliJ IDEA.
  User: Chaklader
  Date: 10/9/17
  Time: 10:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="form"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Save Page</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>

<form:form method="POST" commandName="employee"
                 action="save.do">
    <table>
        <tr>
            <td>Employee ID:</td>
            <td><form:input path="id" /></td>
            <td><form:errors path="id" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Employee Name:</td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Employee Role:</td>
            <td><form:select path="role">
                <form:option value="" label="Select Role" />
                <form:option value="ceo" label="CEO" />
                <form:option value="developer" label="Developer" />
                <form:option value="manager" label="Manager" />
            </form:select>
            </td>
            <td>
                <form:errors path="role" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="Save"></td>
        </tr>
    </table>

</form:form>

</body>
</html>