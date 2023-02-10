<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Management Application</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/users?action=create" class="btn btn-success">Add new User</a>
  </h2>
  <h2>
    <a href="/users?action=search" class="btn btn-success">Search User by Country</a>
  </h2>
  <h2>
    <a href="/users?action=sort" value="search" class="btn btn-success">Sort by Name</a>
  </h2>

</center>
<div align="center">
  <table border="1" cellpadding="5" class="table table-info table-striped-columns">
    <caption style="caption-side: top"> ><h2 class="text-bg-light p-3">List of Users</h2></caption>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Email</th>
      <th>Country</th>
      <th>Actions</th>
    </tr>
    <c:forEach var="user" items="${listUser}">
      <tr>
        <td><c:out value="${user.id}"/></td>
        <td><c:out value="${user.name}"/></td>
        <td><c:out value="${user.email}"/></td>
        <td><c:out value="${user.country}"/></td>
        <td>
          <a href="/users?action=edit&id=${user.id}" class="btn btn-success">Edit</a>
          <a href="/users?action=delete&id=${user.id}" class="btn btn-danger">Delete</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</html>
