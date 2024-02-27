<#--<!DOCTYPE html>-->
<#--<html lang="EN" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"-->
<#--      xmlns="http://www.w3.org/1999/html">-->
<#--<head>-->
<#--    <title>Coffee shop</title>-->
<#--</head>-->

<#--<body>-->
<#--<a href="/admin">Admin Panel</a>-->
<#--<a href="/product-create">NEW Product Create</a>-->

<#--<br><br><br>-->

<#--<#if user.email??>-->
<#--    <h3>Hello <i>${user.getUsername()}</i></h3>-->
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

<#--<hr>-->
<#--<hr>-->
<#--<a href="/registration">Sign up</a>-->
<#--<br><br>-->
<#--<form action="/products" method="post">-->
<#--    Search by title: <label><input type="text" name="title"></label>-->
<#--    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />-->
<#--    <input type="submit" value="Search" /><br><br><br>-->
<#--</form>-->

<#--<h1>All products:</h1><hr>-->
<#--<#list products as product>-->
<#--    <div>-->
<#--        <p><b>${product.title}</b> ${product.price}€    |    <a href="/product/${product.id}"> Read more...</a></p>-->
<#--    </div>-->
<#--<#else>-->
<#--    <h3>No items</h3>-->
<#--</#list>-->
<#--<hr>-->


<#--</body>-->
<#--</html>-->