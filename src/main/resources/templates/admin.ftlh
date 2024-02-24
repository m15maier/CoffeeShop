<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<h1>Admin panel </h1>

<table>
    <tr>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.getEmail}</th>
            <th>${user.getUsername}</th>
            <th>${user.getPhone}</th>
            <th>${user.getAddress}</th>
            <th><#list user.roles as user_role>${user_role}</#list></th>
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <th><a href="/admin/user/edit/${user.getId}">Edit</a></th>

        </tr>


        <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>