<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Log in</H1>

<form action="/login" >
    Email: <div><label><input type="email" name="username" /></label></div><br><br>
    Password: <div><label><input type="password" name="password" minlength="5" required/></label></div><br><br>
    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />
    <input type="submit" value="Log in" />
</form>

<hr>

<h4> <a href="/registration"> Registration </a> </h4><hr>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>