<!DOCTYPE html>
<html lang="EN">
<head>
    <title>Coffee Shop</title>
</head>
<body>
<h1>Log in</h1><hr>
<form action="/login">
    Email: <label><input type="email" name="username"></label><br><br>
    Password: <label><input type="password" name="password"></label><br><br>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}">
    <input type="submit" value="Log in"/>
</form>
<a href="/registration">Sign up</a>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>