<!DOCTYPE html>
<html>
<head>
    <title>Coffee Shop</title>
</head>
<body>
<h1>Coffee Shop</h1><hr>
<h4>Sign up</h4>
<form action="/registration" method="post">
    Name: <input type="text" name="username"><br><br>
    Email: <input type="email" name="email"><br><br>
    Password: <input type="password" name="password"><br><br>
    Phone Number: <input type="text" name="phone"><br><br>
    Address: <input type="text" name="address"><br><br>
    <input type="hidden" name="_csrf" value={{_csrf.token}}">
    <input type="submit" value="Sign up"/>
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>