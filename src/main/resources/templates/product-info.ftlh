<!DOCTYPE html>
<html lang="EN">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Product Details</H1>

<img src="/images/${product.images.get(0)?if_exists}" height="60px/"><br><br>
<img src="/images/${product.images.get(1)?if_exists}" height="60px/"><br><br>
<b>Title: </b> ${product.title}<br>
<b>Description: </b> ${product.description}<br>
<b>Size: </b> ${product.size}<br>
<b>Price: </b> ${product.price}<br>

<form action="/product/delete/${product.id}" method="post">
<#--    <input type="hidden" name="csrfToken" value="${_csrf.token}" />-->
    <input type="submit" value="Delete"/>
</form>


<h4> <-- <a href="/"> Back </a> </h4><hr>
</body>
</html>