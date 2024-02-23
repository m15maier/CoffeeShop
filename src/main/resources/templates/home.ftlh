<!DOCTYPE html>
<html lang="EN" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">



    <title>Coffee shop</title>

<div class="container">
    <div class="row">
        <div class="col-xs-12 col xxl-5">
            <div class="goods_box" id="goods">
                <div class="menu">
                     <input type="text" placeholder="Search" class="search">
                     <button class="add btn-success" data-bs-toggle="model" data-bs-target="#exampleMpdal">&#10010;</button>
                </div>



            </div>
        </div>
        <div class="col-xs-12 col xxl-7"></div>
    </div>
</div>






<body>
<script src="/js/bootstrap.bundle.min.js"></script>
<script src="/js/sweetalert2.all.min.js"></script>
<script src="/js/list.min.js"></script>
<script src="/js/main.js"></script>








<h1>Coffee Shop</h1>

<h2>Home Page</h2>

<#--<#if user.email??>-->
<#--    <h3>Hello <i>${user.user_name}</i></h3>-->
<#--    <form action="/logout" method="post">-->
<#--        <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />-->
<#--        <input type="submit" value="Log out" /><br><br><br>-->
<#--    </form>-->
<#--<#else>-->
<#--    <a href="/login"> Log in</a>-->
<#--</#if>-->
<#--<hr>-->

<#--&lt;#&ndash;<h4> <a href="/login"> Log in </a> </h4>&ndash;&gt;-->
<#--<a href="/registration"> Registration </a>  <br><br>-->

<#--<div> <a href="/admin"> Admin Panel       .</a>-->
<#--    <a href="/product-create"> NEW Product Create        .</a>-->


<#--<br><br>-->

<#--<form action="/">-->
<#--    Search by title: <label>-->
<#--        <input type="text" name="title" >-->
<#--    </label>-->
<#--    <input type="submit" value="Search" /><br><br><br>-->
<#--</form>-->

<#--<h3>All products:</h3><hr>-->
<#--<#list products as product>-->
<#--    <div>-->
<#--        <p><b>${product.title}</b> ${product.price}€ | <a href="/products/ ${product.id}"> Read more...</a></p>-->
<#--    </div>-->
<#--    <#else>-->
<#--    <h3>No items</h3>-->
<#--</#list>-->
<#--<hr>-->

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
    <h4> <-- <a href="/"> Back </a> </h4>

</body>



</html>