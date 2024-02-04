<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Log in</H1>



<form action="/login" method="post">
    Email: <input type="email" name="email"/><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Log in"/>
</form>

<a href="/registration">Registration</a>

</body>
</html>