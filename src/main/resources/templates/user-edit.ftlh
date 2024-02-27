<!DOCTYPE html>
<html lang="EN">
<head>
    <title>Coffee shop</title>
</head>

<body>
<H1>Edit user ${user.getUsername()} </H1>
<form action="/admin/user/edit/" method="post">

    <b>Phone number: ${user.getPhone()} </b><br>
    <b>Email: ${user.getEmail()} </b><br>
    <b>Address: ${user.getAddress()} </b><br><br>

    <#list roles as role>
    <div>
        <label><input type="checkbox" name="${role}" ${roles?seq_contains(role)?string("checked", "")} > ${role}></label>
    </div>

</#list>

    <label><input type="hidden" value="${user.getId()}" name="userId" ></label>
    <input type="hidden" name="_csrf" value="{{_csrf.token}}" />
    <button type="submit">Save</button>


</form>

<h4> <-- <a href="/admin"> Back </a> </h4><hr>

</body>
</html>