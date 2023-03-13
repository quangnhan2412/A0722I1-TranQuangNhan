<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create a new Employee</title>
</head>
<body>
<h3>Welcome, Enter the Employee Details</h3>
<form:form method="post" action="addEmployee" modelAttribute="employee">
    <table>
        <tr>
            <td><form:label path="id">Employee ID :</form:label></td>
            <td><form:input path="id"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Employee's name :</form:label></td>
            <td><form:input path="name"></form:input></td>
        </tr>
        <tr>
            <td><from:label path="contactNumber">Contact Number :</from:label></td>
            <td><from:input path="contactNumber"></from:input></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
