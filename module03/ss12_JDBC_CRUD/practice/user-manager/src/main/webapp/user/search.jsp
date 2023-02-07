<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search By Country</title>
</head>
<body>
<h1>Search By Country</h1>
<h2>
    <a href="/users?action=users">List All Users</a>
</h2>
<h2>
    <a href="users?action=users">List All ấdsadUsers</a>
</h2>
<form method="post" action="/users?action=search">
    <input type="hidden" name="action" value="search">
    <fieldset>
        <legend>Search box</legend>
        <table>
            <tr>
                <td>User's country:</td>
                <td><input type="text" name="country" id="country"></td>
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
