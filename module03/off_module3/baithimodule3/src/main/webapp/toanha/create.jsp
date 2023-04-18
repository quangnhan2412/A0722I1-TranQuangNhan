<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create New Toà Nhà</title>
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
        <th>Mã MB Name:</th>
        <td>
          <input type="text" name="fullName" id="fullName"  size="45"/>
        </td>
        <th>DT:</th>
        <td>
          <input type="text" name="dt" id="dt"  size="45"/>
        </td>
      </tr>
      <tr>
        <th>Trạng Thái:</th>
        <td>
          <input type="text" name="dateOfBirth" id="dateOfBirth" size="20"/>
        </td>
      </tr>
      <tr>
        <th>Tầng :</th>
        <td>
          <input type="text" name="dateOfBirth" id="dateOfBirtha" size="20"/>
        </td>
      </tr>
      <tr>
        <th>Loại Văn Phòng:</th>
        <td>
          <input type="text" name="idCard" id="idCard" size="15"/>
        </td>
      </tr>
      <tr>
        <th>Giá Cho thuê:</th>
        <td>
          <input type="text" name="phoneNumber" id="phoneNumber" size="15"/>
        </td>
      </tr>
      </tr>
      <tr>
        <th>Ngày bắt đầu:</th>
        <td>
          <input type="date" name="email" id="email" size="45"/>
        </td>
      </tr>
      <tr>
        <th>Ngày Kết thúc:</th>
        <td>
          <input type="date" name="address" id="address" size="45"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type="submit" class="btn btn-success"value="Save"/>
          <a class="btn btn-danger" href="tComplexs?action=toanha" role="button">Back to list Customer</a>
        </td>
      </tr>
    </table>
  </form>
</div>

</body>
</html>
