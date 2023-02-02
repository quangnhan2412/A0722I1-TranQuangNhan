<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>
    Edit Customer
</h1>
<p>
    <c:if test="${requestScope['message']!=null}">
        <span class="message">${requestScope["messege"]}</span>
    </c:if>
</p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form action="" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="name" id="name" value="${requestScope["customer"].getName()}">
                </td>
            </tr>
            <td>Email:</td>
            <td><input type="text" name="email" id="email" value="${requestScope["customer"].getEmail()}"></td>
            </tr>
            <tr>
                <td>Address:</td>
                <td><input type="text" name="address" id="address" value="${requestScope["customer"].getAddress()}">
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
