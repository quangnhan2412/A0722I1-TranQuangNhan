<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seasoning Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Lettuce" id="flexCheckDefault" name="condiment">
        <label class="form-check-label" for="flexCheckDefault">
           Lettuce
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Tomato" id="flexCheckChecked1" name="condiment" >
        <label class="form-check-label" for="flexCheckChecked1">
            Tomato
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Mustard" id="flexCheckChecked" name="condiment">
        <label class="form-check-label" for="flexCheckChecked">
            Mustard
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Sprouts" id="flexCheckChecked4" name="condiment">
        <label class="form-check-label" for="flexCheckChecked4">
            Sprouts
        </label>
    </div>
    <input type="submit" value="Save">
    <h5 style="color: darkred">The spices you choose are: : ${result}</h5>
</form>
</body>
</html>
