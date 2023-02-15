<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Search By ID Customer</title>
</head>
<body>
<h1>Search By ID Customer</h1>
<h2>
  <a href="/customers?action=customers">List All Customer</a>
</h2>
<form method="post" action="/customers?action=search">
  <input type="hidden" name="action" value="search">
  <fieldset>
    <legend>Search box</legend>
    <table>
      <tr>
        <td>Search Customer By ID:</td>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="search"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
