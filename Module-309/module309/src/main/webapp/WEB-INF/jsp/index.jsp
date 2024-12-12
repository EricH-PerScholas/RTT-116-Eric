<%@ page import="com.example.module309.database.entity.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<h1>First Page</h1>
<table border="1">
    <tr>
        <td>Contact First Name</td>
        <td>Contact Last Name</td>
        <td>id</td>
        <td>Customer Name</td>
    </tr>
    <c:forEach var="name" items="${names}">
        <tr>
            <td>${name.contactFirstname}</td>
            <td>${name.contactLastname}</td>
            <td>${name.id}</td>
            <td>${name.customerName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>