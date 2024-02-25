<!DOCTYPE html>
<html lang="EN">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Product Details</H1>


<b>Title: </b> ${product.title}<br>
<b>Description: </b> ${product.description}<br>
<b>Size: </b> ${product.size}<br>
<b>Price: </b> ${product.price}<br>

<#list images as img>
    <img src="/img/${img.id}" height="60px"/><br><br>
</#list>

<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Delete"/>
</form>


<h4> <-- <a href="/"> Back </a> </h4><hr>
</body>
</html>