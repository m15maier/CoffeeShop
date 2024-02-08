<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Product Details</H1>

<b>Title: </b> ${product.title}<br>
<b>Description: </b> ${product.description}<br>
<b>Size: </b> ${product.size}<br>
<b>Price: </b> ${product.price}<br>
<#--<b>Author: </b> <a href="/user/{products.user_id}"> ${product.user.name}</a> <br>-->
<#--<hr>-->
<form action="/product/delete/${product.id}" method="post">
    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />
    <input type="submit" value="Delete"/>



<h4> <-- <a href="/"> Back </a> </h4><hr>
</form>
</body>
</html>