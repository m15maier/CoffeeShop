<!DOCTYPE html>
<html lang="EN" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Coffee Shop</title>
</head>

<#--<#if user.email??>-->
<#--    <h3>Hello <i>${user.user_name}</i></h3>-->
<#--    <form action="/logout" method="post">-->
<#--        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />-->
<#--        <input type="submit" value="Log out" /><br><br><br>-->
<#--    </form>-->
<#--    <#if user.isAdmin()>-->
<#--        <a href="/admin">Admin Panel</a>-->
<#--    </#if>-->
<#--<#else>-->
<#--    <a href="/login">Log in</a>-->
<#--</#if>-->
<hr>
<hr>

<body>


<h1>Please Log in</h1><hr>
<form action="/login" method="post">
    Email: <label><input type="email" name="email"></label><br><br>
    Password: <label><input type="password" name="password"></label><br><br>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Log in"/>
</form>

<a href="/registration">Sign up</a>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>