<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet" href="BootStrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=create">Add new Customer</a>
    </h2>
    <h2>
        <a href="/customers?action=search">Search User by Country</a>
    </h2>

</center>
<div align="center">
    <table border="1" cellpadding="5" class="table table-dark table-striped-columns">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Type ID</th>
            <th>Name</th>
            <th>Birth Day</th>
            <th>Gender</th>
            <th>ID Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td><c:out value="${customer.getCustomerId()}"></c:out></td>
                <td><c:out value="${customer.getCustomerTypeId()}"></c:out></td>
                <td><c:out value="${customer.getFullName()}"></c:out></td>
                <td><c:out value="${customer.getDayOfBirth()}"></c:out></td>
                <td><c:out value="${customer.isGender()}"></c:out></td>
                <td><c:out value="${customer.getIdentityCard()}"></c:out></td>
                <td><c:out value="${customer.getPhoneNumber()}"></c:out></td>
                <td><c:out value="${customer.getEmail()}"></c:out></td>
                <td><c:out value="${customer.getAddress()}"></c:out></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/customers?action=delete&id=${customer.getCustomerId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script src="BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.bundle.min.js"></script>

</html>
