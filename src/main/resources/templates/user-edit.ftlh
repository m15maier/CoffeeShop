<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Edit user ${user.user_name} </H1>
<form action="/admin/user/edit" method="post">
<#list user.roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}></label>
    </div>
<#else>
    <h3>No items</h3>
</#list>
<input type="hidden" value="${user.userId}" name="userId">
    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />
<button type="submit">Save</button>

<h4> <-- <a href="/"> Back </a> </h4><hr>
</form>
</body>
</html>