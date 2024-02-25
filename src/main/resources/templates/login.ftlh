
<!DOCTYPE html>
<html>
<head>
    <title>Coffee shop</title>
</head>
<body>
<h1>Coffee shop</h1><hr>
<h4>Log in</h4>
<form action="/login" method="post">
    Email: <input type="email" name="username" placeholder="some@some.com"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}">
    <input type="submit" value="Log in"/>
</form>
<a href="/registration">Sing up</a>
</body>
</html>