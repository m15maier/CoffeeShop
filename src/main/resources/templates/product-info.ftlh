<!DOCTYPE html>
<html>
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Product Info</H1>


<h3> Create new item </h3>


<b>Title: </b> ${product.title}<br>
<b>Description: </b> ${product.description}<br>
<b>Size: </b> ${product.size}<br>
<b>Price: </b> ${product.price}<br>


<hr>


<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Delete"/>


</form>
</body>
</html>