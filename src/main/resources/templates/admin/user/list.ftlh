<@layout>
    <h2>Users</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone</th>
                <th scope="col">Address</th>
                <th scope="col">Active</th>
                <th scope="col">Role</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
        <#list list as user>
            <tr>
                <td class="text-end text-secondary">${user?index + 1}</td>
                <td>${user.username!}</td>
                <td>${user.email!}</td>
                <td>${user.phone!}</td>
                <td>${user.address!}</td>
                <td>${user.active ? string('✓', '')}</td>
                <td>${user.role!}</td>
                <td class="text-end">
                    <a href="/admin/user/edit/${user.id}" type="button" class="btn btn-primary">Edit</a>
                    <a href="javascript:confirmDelete('/admin/user/delete/${user.id}')" type="button" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        <#else>
            <tr>
                <td colspan="99">No items</td>
            </tr>
        </#list>
        </tbody>
    </table>
<#--    <a type="button" href="/admin/product/edit/0" class="btn btn-success">Add product</a>-->
</@layout>
