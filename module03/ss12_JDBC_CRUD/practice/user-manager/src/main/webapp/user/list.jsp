<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Management Application</title>
</head>
<body>
<center>
  <h1>User Management</h1>
  <h2>
    <a href="/users?action=create">Add new User</a>
  </h2>
</center>
<div align="center">
  <table border="1" cellpadding="5">
    <caption>
      <h2>List of Users</h2>
    </caption>
    <tr>
      <td>ID</td>
      <td>Name</td>
      <td>Email</td>
      <td>Country</td>

    </tr>
    <tr>  <td>Actions</td></tr>
    <c:forEach var="user" items="${listUser}">
      <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.country}</td>

      </tr>
      <tr>
        <td>
          <a href="/users?action=edit&id=${user.getId()}">Edit</a>
          <a href="/users?action=delete&id=${user.getId()}">Delete</a>
        </td>
      </tr>

    </c:forEach>
  </table>
</div>
</body>
</html>
