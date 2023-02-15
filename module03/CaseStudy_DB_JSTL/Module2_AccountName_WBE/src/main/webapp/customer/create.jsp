<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Customer</title>
    <link rel="stylesheet" href="BootStrap/bootstrap-5.3.0-alpha1-dist/css/bootstrap.min.css">
</head>
<style>
    h2{
        text-align: center;
    }
</style>
<body>
<div class="header">
    <div class="row col-12">
            <h2 class="text-success align-content-center" >Add New Customer</h2>
    </div>
</div>
<div align="center" class="row col-12 ">
    <form method="post" >
        <input type="hidden" name="action" value="create">
        <table class="table-success  ">
            <tr class="form-group">
                <th>Customer type id:</th>
                <td>
                    <select name="typeId" >
                        <option value=100>-Select-</option>
                        <option value=1>Diamond</option>
                        <option value=2>Platinum</option>
                        <option value=3>Gold</option>
                        <option value=4>Silver</option>
                        <option value=5>Member</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="fullName" id="fullName"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input type="date" name="dateOfBirth" id="dateOfBirth" size="20"/>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <select>
                        <option value=100>-Select-</option>
                        <option value=0>Nam</option>
                        <option value=1>Nữ</option>
                        <option value=2>Khác</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>id Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="15"/>
                </td>
            </tr>
            <tr>
                <th>Number Phone:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="15"/>
                </td>
            </tr>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="btn btn-success"value="Save"/>
                    <a class="btn btn-danger" href="customers?action=customers" role="button">Back to list Customer</a>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
