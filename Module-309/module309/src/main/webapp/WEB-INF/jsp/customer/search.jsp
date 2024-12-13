<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <!-- these 2 lines are needed to bring in bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

    <!-- jquery is always loaded at the top of the file because its needed by so many other libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


</head>
<body>
<h1 class="text-center">Customer Search</h1>

<div class="container">
    <form action="/customer/search">
        <div class="row pt-3 justify-content-center">
            <div class="col-6">
                <div class="mb-3">
                    <label for="firstNameId" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="firstNameId" name="firstName" value="${search}">
                </div>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-6">
                <button type="submit" class="btn btn-primary">Search</button>
            </div>
        </div>
    </form>
</div>

<c:if test="${customersKey.size() > 0 }">
    <section>
        <div class="container">
            <h2 class="text-center pt-5">Customers Found (${customersKey.size()})</h2>

            <table class="table mt-5">
                <tr>
                    <td>Contact First Name</td>
                    <td>Contact Last Name</td>
                    <td>id</td>
                    <td>Customer Name</td>
                </tr>
                <c:forEach var="customer" items="${customersKey}">
                    <tr>
                        <td>${customer.contactFirstname}</td>
                        <td>${customer.contactLastname}</td>
                        <td>${customer.id}</td>
                        <td>${customer.customerName}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>
</c:if>

</body>
</html>
