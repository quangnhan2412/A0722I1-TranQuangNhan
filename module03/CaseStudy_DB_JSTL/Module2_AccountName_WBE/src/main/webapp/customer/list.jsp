<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/BootStrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">


</head>
<style>

    table.table.table-striped {
        width: 100%;
    }

    input.form-control.rounded {
        width: 30%;
        display: inline-block;
    }

    button.btn.btn-primary {
        position: absolute;
    }

    h2.fw-bold {
        width: 30%;
        float: left;
        margin-right: 470px;
    }

    .row.searchID {
        width: 100%;
        display: block;
    }

    img {
        /* width: 100px; */
        height: 50px;
        border-radius: 50%;
        margin-right: 10px;
    }

    input[type="checkbox"] {
        color: #f2f2f2;
        text-align: right;
        display: inline-block;
        width: 50px;
        height: 25px;
        margin: -2px 10px 0 0;
        vertical-align: middle;
    }
</style>
<body>

<div class="row">
    <div class="col-5">
    </div>
    <div class="col-3 ">
        <a href="http://localhost:8090/" class="header_logo">
            <img src="CSS_HomePage/img/Logo_furama.jpg" class="img-fluid" style="" alt="logo" width="50%" height="25px">
        </a>
    </div>
    <div class="col-4" >
        <h2 style="padding-top: 140px" class="img-fluid" width="100%">
            <a href="/customers?action=create" class="btn btn-success"><img src="/CSS_HomePage/img/addCustomer.jpg"></i>
                Add new Customer</a>
        </h2>
    </div>
</div>
<div class="row">
    <div class="col-9">
        <form action="/customers" style="height: 30px; line-height: 30px">
            <input type="hidden" name="action" value="search">
            <input type="text" name="searchName" placeholder="Full Name">
            <input type="text" name="searchIdCard" placeholder="ID Card">
            <input type="text" name="searchPhone" placeholder="Number Phone">

            <button type="submit">Search</button>
        </form>
    </div>
    <div class="col-3">
        <div class="row searchID">
            <form action="/customers" method="get" class="form-inline">
                <input type="text" class="form-control rounded " name="search" placeholder="Search" aria-label="Search"
                       aria-describedby="search-addon"/>
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
</div>
</div>
<div class="row">
    <div class="row searchID">
        <form  method="get" class="form-inline">
            <input type="hidden" name="action" value="search2">

            <input type="text" class="form-control rounded " name="searchABC" placeholder="Search" aria-label="Search"
                   aria-describedby="search-addon"/>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</div>
<form action="customers" method="get">
    <input type="hidden" name="action" value="deleteAll">

    <table class="table table-striped" id="example">
        <caption style="caption-side: top">
            <h2 class="fw-bold">List Of Customer
            </h2>

        </caption>
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
            <th>Click Delete</th>
        </tr>
        <c:forEach items="${customerList}" var="customer">
        <tr>
            <td><c:out value="${customer.getCustomerId()}"></c:out></td>
            <td><c:out value="${customer.getCustomerTypeId()}"></c:out></td>
            <td><c:out value="${customer.getFullName()}"></c:out></td>
            <td><c:out value="${customer.getDayOfBirth()}"></c:out></td>
            <td>
                <c:if test="${customer.isGender()}">Female</c:if>
                <c:if test="${!customer.isGender()}">Male</c:if>
            </td>
            <td><c:out value="${customer.getIdentityCard()}"></c:out></td>
            <td><c:out value="${customer.getPhoneNumber()}"></c:out></td>
            <td><c:out value="${customer.getEmail()}"></c:out></td>
            <td><c:out value="${customer.getAddress()}"></c:out></td>

            <td>
                <a href="/customers?action=delete&id=${customer.getCustomerId()} "class="btn btn-info">Delete</a>
                <button type="button" class="btn btn-info" data-bs-toggle="modal"
                        data-bs-target="#updateModal${customer.getCustomerId()}">
                    Update
                </button>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                        data-bs-target="#deleteModal${customer.getCustomerId()}">
                    Delete
                </button>
            </td>
            <td>
                <input type="checkbox" name="customerId" value="${customer.getCustomerId()}">
            </td>



            <!-- Modal Delete -->
            <div class="modal fade" id="deleteModal${customer.getCustomerId()}" data-bs-backdrop="static"
                 data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">Delete ? </h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure you want to delete <strong class="text-danger">${customer.getFullName()}</strong>?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <a href="/customers?action=delete&id=${customer.getCustomerId()}">
                                <button type="button" class="btn btn-warning">Confirm</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal Update -->
            <div class="modal fade" id="updateModal${customer.getCustomerId()}" data-bs-backdrop="static"
                 data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabelUpdate" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabelUpdate">Update ? </h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            Are you sure you want to update it?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <a href="/customers?action=update&id=${customer.getCustomerId()}">
                                <button type="button" class="btn btn-warning">Confirm</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            <div id="pagination"></div>
    </table>

    <!-- Modal Delete Click -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete ALL</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete all ?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <a href="#">
                        <button type="submit" class="btn btn-danger">Confirm</button>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal">Xoá Click</button>
</form>

<script src="/BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.js" ></script>
<script src="/BootStrap/bootstrap-5.3.0-alpha1-dist/js/bootstrap.min.js" ></script>

</body>
</html>


