<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <link rel="stylesheet" href="BootStrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
</head>
<style>
</style>
<body>
<div>
    <div class="row col-12">
        <div class="col-5">
            <div class="input-group" style="padding-top: 140px">
                <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                <button type="button" class="btn btn-primary">search</button>
            </div>
        </div>
        <div class="col-3 ">
            <a href="http://localhost:8090/" class="header_logo">
                <img src="CSS_HomePage/img/Logo_furama.jpg" class="img-fluid"  style="" alt="logo" width="50%" height="25px">
            </a>
        </div>
        <div class="col-4"x>
                <h2 style="padding-top: 140px" class="img-fluid" width="100%">
                    <a href="/customers?action=create" class="btn btn-success">Add new Customer</a>
            </h2>
        </div>
    </div>
    <table class="table table-striped">
        <caption style="caption-side: top"><h2 class="fw-bold">List Of Customer</h2></caption>
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
        <c:forEach items="${customerList}" var="customer">
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
                    <a href="/customers?action=update&id=${customer.getCustomerId()} "class="btn btn-info">Update</a>
                    <a href="/customers?action=delete&id=${customer.getCustomerId()}" class="btn btn-danger">Delete</a>

                </td>
                <td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
