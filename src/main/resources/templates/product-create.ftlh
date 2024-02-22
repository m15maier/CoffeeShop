<!DOCTYPE html>
<html lang="ENG" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <title>Coffee shop</title>
</head>

<body>

<h1> Create new item </h1>

<form action="/products/create" method="post" enctype="multipart/form-data">
    ID: <label><input type="text" name="id"/></label><br><br>
    Title: <label><input type="text" name="title"/></label><br><br>
    Description: <label><input type="text" name="description"/></label><br><br>
    Size: <label><input type="text" name="size"/></label><br><br>
    Price: <label><input type="number" name="price"/></label><br><br>
    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />
    <input type="submit" value="Add item" />

</form>



<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>