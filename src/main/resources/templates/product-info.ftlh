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

<form action="/product/delete-from-cart/${product.id}" method="post">
<#--    <input type="hidden" name="csrfToken" value="{% csrf_token %}" />-->
    <input type="submit" value="Delete"/>
</form>

<form action="/product/add-to-cart/${product.id}" method="post">
<#--    <input type="hidden" name="csrfToken" value="{% csrf_token %}" />-->
    <input type="submit" value="Add to cart"/>
</form>


<h4> <-- <a href="/"> Back </a> </h4><hr>
</body>
</html>