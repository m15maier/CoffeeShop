<!DOCTYPE html>
<html lang="EN" xmlns:form="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html"
      xmlns="http://www.w3.org/1999/html">
<head>
    <title>Coffee shop</title>
</head>

<body>

<h1> Create new item </h1>

<form action="/product/create" method="post" enctype="multipart/form-data">
    ID: <label><input type="text" name="id" value="0"/></label><br><br>
    Title: <label><input type="text" name="title" value="0"/></label><br><br>
    Description: <label><input type="text" name="description" value="0"/></label><br><br>
    Size: <label><input type="text" name="size" value="0"/></label><br><br>
    Price: <label><input type="number" name="price" value="0"/></label><br><br>
    File1: <label><input type="file" name="file1" value="0"/></label><br><br>
    File2: <label><input type="file" name="file2" value="0"/></label><br><br>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <input type="submit" value="Add item" />

</form>



<h4> <-- <a href="/"> Back </a> </h4><hr>

</body>
</html>