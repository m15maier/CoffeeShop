<!DOCTYPE html>
<html lang="ENG">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Edit user ${user.user_name} </H1>
<form action="/admin/user/edit/" method="post">

    <b>Phone number: ${user.user_phone} </b><br>
    <b>Email: ${user.user_email} </b><br>
    <b>Address: ${user.user_address} </b><br><br>


    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} > ${role}></label>
    </div>
<#else>
    <h6> . . . . . .</h6>
</#list>


    <label><input type="hidden" value="${user.user_id}" name="userId" ></label>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <button type="submit">Save</button>


</form>

<h4> <-- <a href="/admin"> Back </a> </h4><hr>

</body>
</html>