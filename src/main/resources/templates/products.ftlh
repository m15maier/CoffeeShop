<!DOCTYPE html>
<html>
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Coffee shop</H1>




<form action="/" method="get">
    Search by title: <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>


<hr>



<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} | <a href="/product/${product.id}"> Read more...</a></p>
    </div>
</#list>



<hr>




<h3> Create new item </h3>

<form action="/product/create" method="post">
    Title: <input type="text" name="title"/><br><br>
    Description: <input type="text" name="description"/><br><br>
    Size: <input type="text" name="size"/><br><br>
    Price: <input type="number" name="price"/><br><br>

    <input type="submit" value="Add"/>




</form>
</body>
</html>