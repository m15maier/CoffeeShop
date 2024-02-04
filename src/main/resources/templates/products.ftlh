<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<h1>Coffee shop | <a href="/login"> Log in </a> </h1><hr>

<form action="/" method="get">
    Search by title: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>



<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price}€ | <a href="/product/${product.id}"> Read more...</a></p>
    </div>
    <#else>
    <h3>No items</h3>
</#list>
<hr>



<h3> Create new item </h3>

<form action="/product/create" method="post" enctype="multipart/form-data">
    ID: <input type="text" name="id"/><br><br>
    Title: <input type="text" name="title"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    Size: <input type="text" name="size"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Add item"/>




</form>
</body>
</html>