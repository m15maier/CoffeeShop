<!DOCTYPE html>
<html lang="EN">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Registration</H1>

<form action="/registration" method="post">
    Name: <label><input type="text" name="name" /></label><br><br>
    Email: <label><input type="email" name="email" /></label><br><br>
    Phone Number: <label><input type="text" name="phone" /></label><br><br>
    Password: <label><input type="password" name="password" /></label><br><br>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Sign In" />

</form>

<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>