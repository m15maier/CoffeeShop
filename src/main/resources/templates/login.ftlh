<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Please Log in</H1>

<form action="/login" method="get">
    Email: <label><input type="email" name="username" /></label><br><br>
    Password: <label><input type="password" name="password" /></label><br><br>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Log in" />
</form>

<h3>Registration | <a href="/registration"> Registration </a> </h3><hr>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>