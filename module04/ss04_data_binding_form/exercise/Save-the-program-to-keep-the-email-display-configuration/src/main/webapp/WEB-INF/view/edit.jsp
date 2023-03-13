<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Email Box</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Settings</h1>
<form:form action="/email/update" method="post" modelAttribute="emailBox">
    <form:hidden path="idMail"/>

    <form:label path="language">Languages :</form:label>
    <form:select path="language" items="${languagesList}"></form:select>
    <br>
    <form:label path="pageSize">Page Size :</form:label>
    Show <form:select path="pageSize" items="${pageSizeList}"></form:select> emails per page
    <br>
    <form:label path="spamFilter">Spams Filter :</form:label>
    <form:checkbox path="spamFilter"></form:checkbox>
    <br>
    <form:label path="signature">Signature</form:label>
    <form:textarea path="signature"/>
    <br>
    <input type="submit" value="Update">
    <button><a href="/email" style="text-decoration: none">Cancel</a></button>
</form:form>
</body>
</html>