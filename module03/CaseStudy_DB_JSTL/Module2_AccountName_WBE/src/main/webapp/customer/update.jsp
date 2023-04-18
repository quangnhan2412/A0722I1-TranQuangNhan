<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h2>Customer Manager</h2>
</center>
<div align="center">
    <form method="post"  >
        <table border="1" cellpadding="5" >
            <caption>
                <h2>
                    Update Customer
                </h2>
            </caption
            <c:if test="${existingCustomer != null}">
                <input type="hidden" name="id" value="<c:out value='${existingCustomer.getCustomerId()}' />"/>
            </c:if>
            <tr>
                <th>Type ID:</th>
                <td>
                    <select name="typeId">
                        <option value=100>-Select-</option>
                        <option value="1">Diamond</option>
                        <option value="2">Platinum</option>
                        <option value="3">Gold</option>
                        <option value="4">Silver</option>
                        <option value="5">Member</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="fullName" size="45"
                           value="<c:out value='${existingCustomer.getFullName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="dateOfBirth" size="15"
                           value="<c:out value='${existingCustomer. getDayOfBirth()}' />"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select>
                        <option value=100>-Select-</option>
                        <option value="<c:out value='${existingCustomer. isGender()}' />">Nam</option>
                        <option value="<c:out value='${existingCustomer. isGender()}' />">Nữ</option>
                        <option value="<c:out value='${existingCustomer. isGender()}' />">Khác</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>id Card::</th>
                <td>
                    <input type="text" name="idCard" size="45"
                           value="<c:out value='${existingCustomer.getIdentityCard()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th> Number Phone:</th>
                <td>
                    <input type="text" name="phoneNumber" size="45"
                           value="<c:out value='${existingCustomer.getPhoneNumber()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email::</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${existingCustomer.getEmail()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" size="45"
                           value="<c:out value='${existingCustomer. getAddress()}' />"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit"value="update"/>
                    <button class="btn btn-danger" >
                        <a href="customers?action=customers">Hủy</a></button>
                    <%--                    <a class="btn btn-danger" href="customers?action=customers" role="button">Back to list Customer</a>--%>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
