<%--
  Created by IntelliJ IDEA.
  User: Trần  Quang Nhân
  Date: 15/01/2023
  Time: 1:42 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  String description = request.getParameter("product_description");
  float listPrice = Float.parseFloat(request.getParameter("list_price"));
  float discount = Float.parseFloat(request.getParameter("discount_percent"));

  double discountAmount = listPrice * discount * 0.01;
%>
<h2><%=discountAmount%></h2>
</body>
</html>
