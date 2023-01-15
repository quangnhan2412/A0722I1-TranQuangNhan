<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<%--<form action="/" method="post">--%>
<%--<form action="/DiscountServlet" method="post">--%>
<form action="/DiscountServlet" method="post">

    <label>
        <input type="text" name="product_description" placeholder="Product Description">
    </label>
    <label>
        <input type="text" name="list_price" placeholder="List Price">
    </label>
    <label>
        <input type="text" name="discount_percent" placeholder="Discount Percent">
    </label>
    <input type="submit" id="submit" value="Calculate Discount">
</form>
</body>
</html>