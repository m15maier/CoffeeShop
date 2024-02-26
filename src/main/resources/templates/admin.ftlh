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
            <th>${user.getEmail()}</th>
            <th>${user.getUsername()}</th>
            <th>${user.getPhone()}</th>
            <th>${user.getAddress()}</th>
            <th>${user.getRole()}</th>


<#--            <th><#if user.active>true<#else>false</#if></th>-->
<#--            <th><#list users as user>${user}</#list></th>-->

<#--            <th><#list roles as userRole>${userRole}</#list></th>-->
            <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
            <th><a href="/admin/user/edit/${user.getId()}">More information</a></th>

        </tr>


        <#else>
        <h3>No users</h3>
    </#list>
</table>
</body>
</html>