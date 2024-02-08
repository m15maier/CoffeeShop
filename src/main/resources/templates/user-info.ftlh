<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Items added user ${user.name} </H1>
<b>User phone number: ${user.phoneNumber} </b>
<b>User email: ${user.email} </b>

   <#list products as product>
       <div>
           <p><b>${product.title}</b> ${product.price}€ | <a href="/products/${product.id}"> Read more...</a></p>
       </div>
       <#else>
       <h3>No items</h3>
   </#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>

<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>