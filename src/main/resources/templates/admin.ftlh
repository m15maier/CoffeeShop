<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<h1>Admin panel </h1>

<table>
    <tr>
        <th>List of users</th>

    </tr>
    <#list users as user>
        <tr>
            <th>${user.user_email}</th>
            <th><#list user.roles as role>${role}</#list></th>
            <th>
                <form action="/admin/user/ban/${user.userId}" method="post">
                    <input type="hidden" name="csrfToken" value="{{_csrf.token}}" />
                    <input type="submit" value="Ban">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.getUserId()}">Edit</a></th>
            <th><a href="/admin/user/${user.userId}">More information</a></th>
        </tr>


        <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>