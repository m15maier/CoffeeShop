<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Log in</H1>

<form action="/" method="post">
    Email: <input type="email" name="username" /><br><br>
    Password: <input type="password" name="password" /><br><br>
<#--    <input type="hidden" name="csrfToken" value="${_csrf.token}" />-->
    <input type="submit" value="Log in" />
</form>


<h4> <a href="/registration"> Registration </a> </h4><hr>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>