<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Registration</H1>


<form action="/registration" method="post">
    Name: <input type="text" name="name" /><br><br>
    Email: <input type="email" name="email" /><br><br>
    Phone Number: <input type="text" name="numberPhone" /><br><br>
    Password: <input type="password" name="password" /><br><br>
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}" />-->
    <input type="submit" value="Registration" />

</form>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>