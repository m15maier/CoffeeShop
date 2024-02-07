<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Log in</H1>



<form action="/login" method="post">
    Email: <input type="email" name="username" /><br><br>
    Password: <input type="password" name="password" /><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" value="Log in" />
</form>

<h3>Registration | <a href="/registration"> Registration </a> </h3><hr>

</body>
</html>