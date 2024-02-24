<!DOCTYPE html>
<html lang="EN" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <title>Coffee shop</title>
</head>

<body>
<a href="/admin">Admin Panel</a>
<#--<a href="/product-create">NEW Product Create</a>-->

<br><br><br>

<#if user.email??>
    <h3>Hello <i>${user.getUsername}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Log out" /><br><br><br>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Admin Panel</a>
    </#if>
<#else>
    <a href="/login">Log in</a>
</#if>
    <hr>
<hr>
<a href="/registration">Sign up</a>
<br><br>
<form action="/products" method="post">
    Search by title: <label><input type="text" name="title"></label>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Search" /><br><br><br>
</form>

<h1>All products:</h1><hr>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price}€    |    <a href="/product/${product.id}"> Read more...</a></p>
    </div>
    <#else>
    <h3>No items</h3>
</#list>
<hr>

    <h1> Create new item </h1>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        ID: <label><input type="text" name="id" /></label><br><br>
        Title: <label><input type="text" name="title" /></label><br><br>
        Description: <label><input type="text" name="description" /></label><br><br>
        Size: <label><input type="text" name="size" /></label><br><br>
        Price: <label><input type="number" name="price"/></label><br><br>
        File1: <label><input type="file" name="file1"/></label><br><br>
        File2: <label><input type="file" name="file2"/></label><br><br>
        <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
        <input type="submit" value="Add item" />

    </form>



    <#--<#if user.email??>-->

</body>
</html>