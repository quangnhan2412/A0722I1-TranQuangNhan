<%--
  Created by IntelliJ IDEA.
  User: Trần  Quang Nhân
  Date: 3/4/2023
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="trans" method="post">
<table border="1px">
    Enter Eng : <br>
    <input type="text" name="trans">
    <input type="submit"  >
    <h1 style="color: crimson">Result : ${searchWord.result}</h1>
</table>
</form>
</body>
</html>
