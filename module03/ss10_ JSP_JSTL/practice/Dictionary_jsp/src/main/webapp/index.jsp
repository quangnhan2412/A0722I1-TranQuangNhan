<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Simple dictionary</title>
</head>
<body>
<h2 style="color: red"> Vietnamese Dictionnary</h2>
<br/>
<form action="/dictionary.jsp" method="post ">
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type="submit" id="submit" value="Search" />
</form>

</body>
</html>