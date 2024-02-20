<!DOCTYPE html>
<html lang="ENG" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <title>Coffee shop</title>
</head>

<body>


<#--<h1>All products</h1>-->


<#--<#if user.email??>-->
<#--    <h3>Hello <i>${user.name}</i></h3>-->
<#--    <form action="/logout" method="post">-->
<#--        <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />-->
<#--    <input type="submit" value="Log out" /><br><br><br>-->
<#--    </form>-->
<#--<#else>-->
<#--    <a href="/login"> Log in</a>-->
<#--</#if>-->
<#--<hr>-->

<h4> <a href="/login"> Log in </a> </h4>
<h4> <a href="/registration"> Registration </a> </h4> <br><br>

<div> <a href="/admin"> Admin Panel       .</a>
    <a href="/cart"> Cart        .</a>
    <a href="/order"> Order       .</a></div>

<br><br>


<#--<#if user.email??>-->

<h1> Create new item </h1>

<form action="/product-create" method="post" enctype="multipart/form-data">
    ID: <label>
        <input type="text" name="id"/>
    </label><br><br>
    Title: <label>
        <input type="text" name="title"/>
    </label><br><br>
    Description: <label>
        <input type="text" name="description"/>
    </label><br><br>
    Size: <label>
        <input type="text" name="size"/>
    </label><br><br>
    Price: <label>
        <input type="number" name="price"/>
    </label><br><br>
    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />
    <input type="submit" value="Add item" />

</form>
<#--</#if>-->


<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>