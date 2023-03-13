<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Email Box</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1 style="color: greenyellow">${message}</h1>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Languages</th>
        <th scope="col">Page Size</th>
        <th scope="col">Spams Filter</th>
        <th scope="col">Signature</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="email" items="${emailList}" varStatus="status">
        <tr>
            <th scope="row">${status.count}</th>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamFilter}</td>
            <td>${email.signature}</td>
                            <td><a class="btn btn-sm btn-secondary" href="/email/updateForm?id=${email.idMail}">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>