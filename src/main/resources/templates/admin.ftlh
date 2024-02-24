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
            <th>${user.user_email}</th>
            <th>${user.user_name}</th>
            <th>${user.user_phone}</th>
            <th>${user.user_address}</th>
            <th><#list user.roles as user_role>${user_role}</#list></th>
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <th><a href="/admin/user/edit/${user.user_id}">Edit</a></th>

        </tr>


        <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>