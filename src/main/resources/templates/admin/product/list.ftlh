<@layout>
    <h2>Products</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Title</th>
                <th scope="col">Price</th>
                <th scope="col">Size</th>
                <th scope="col">Description</th>
                <th scope="col">Preview</th>
                <th scope="col"></th>
            </tr>
        </thead>
        <tbody>
        <#list list as product>
            <tr>
                <td class="text-end text-dark">${product?index + 1}</td>
                <td>${product.title!}</td>
                <td class="text-end" nowrap>${product.price!"0.00"} €</td>
                <td nowrap>${product.size!}</td>
                <td><small>${product.description!}</small></td>
                <td><@image image=product.previewImage!/></td>
                <td class="text-end">
                    <a href="/admin/product/edit/${product.id}" type="button" class="btn btn-dark">Edit</a>
                    <a href="javascript:confirmDelete('/admin/product/delete/${product.id}')" type="button" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        <#else>
            <tr>
                <td colspan="99">No items</td>
            </tr>
        </#list>
        </tbody>
    </table>
    <a type="button" href="/admin/product/edit/0" class="btn btn-success">Add product</a>
</@layout>
