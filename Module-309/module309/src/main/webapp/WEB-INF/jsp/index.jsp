<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="include/header.jsp"/>

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