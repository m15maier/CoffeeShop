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
<#--            <th>-->
<#--                <form action="/admin/user/ban/${user.userId}" method="post">-->
<#--                    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />-->
<#--                    <input type="submit" value="Ban">-->
<#--                </form>-->
<#--            </th>-->
            <th><a href="/admin/user/edit/${user.userId}">Edit</a></th>

        </tr>


        <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>