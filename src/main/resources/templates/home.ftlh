<!DOCTYPE html>
<html lang="ENG" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <title>Coffee shop</title>
</head>

<body>


<h1>Main Page</h1>

<h4> <a href="/login"> Log in </a> </h4>
<h4> <a href="/registration"> Registration </a> </h4> <br><br>

<div> <a href="/admin"> Admin Panel       .</a>
    <a href="/cart"> Cart        .</a>
    <a href="/order"> Order       .</a></div>

<br><br>

<form action="/">
    Search by title: <label>
        <input type="text" name="title" >
    </label>
    <input type="submit" value="Search" /><br><br><br>
</form>

<h3>All products:</h3><hr>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price}€ | <a href="/products/${product.id}"> Read more...</a></p>
    </div>
    <#else>
    <h3>No items</h3>
</#list>
<hr>

<#--<#if user.email??>-->

<#--<h1> Create new item </h1>-->

<#--<form action="/products/create" method="post" enctype="multipart/form-data">-->
<#--    ID: <label>-->
<#--        <input type="text" name="id"/>-->
<#--    </label><br><br>-->
<#--    Title: <label>-->
<#--        <input type="text" name="title"/>-->
<#--    </label><br><br>-->
<#--    Description: <label>-->
<#--        <input type="text" name="description"/>-->
<#--    </label><br><br>-->
<#--    Size: <label>-->
<#--        <input type="text" name="size"/>-->
<#--    </label><br><br>-->
<#--    Price: <label>-->
<#--        <input type="number" name="price"/>-->
<#--    </label><br><br>-->
<#--    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />-->
<#--    <input type="submit" value="Add item" />-->

<#--</form>-->
<#--</#if>-->

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>