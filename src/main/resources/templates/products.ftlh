<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<h3>Login | <a href="/login"> Log in </a> </h3><hr>
<h3>Registration | <a href="/registration"> Registration </a> </h3><hr>

<form action="/products" method="get">
    Search by title: <input type="text" name="title" /><br>
    <input type="submit" value="Search" />
</form>



<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price}€ | <a href="/products/${product.id}"> Read more...</a></p>
    </div>
    <#else>
    <h3>No items</h3>
</#list>
<hr>



<h1> Create new item </h1>

<form action="/products/create" method="post" enctype="multipart/form-data">
    ID: <input type="text" name="id" /><br><br>
    Title: <input type="text" name="title" /><br><br>
    Description: <input type="text" name="description" /><br><br>
    Size: <input type="text" name="size" /><br><br>
    Price: <input type="number" name="price" /><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" value="Add item" />




</form>
</body>
</html>