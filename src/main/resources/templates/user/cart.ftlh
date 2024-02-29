<@layout>
    <h2>Cart</h2>

    <#if !cart.isEmpty()>
        <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Price</th>
                    <th scope="col">Size</th>
                    <th scope="col">Preview</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Sum</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <#list cart.cartProducts as cartProduct>
                    <#assign product = cartProduct.product>
                    <form method="post" action="/user/cart/update/${product.id!}">
                        <tr>
                            <td class="text-end text-secondary">${cartProduct?index + 1}</td>
                            <td>${cartProduct.product.title!}</td>
                            <td class="text-end" nowrap>${product.price!"0.00"} €</td>
                            <td nowrap>${product.size!}</td>
                            <td><@image image=product.previewImage!/></td>
                            <td class="text-end" nowrap>
                                <input type="number" class="form-control" name="quantity" placeholder="1" value="${cartProduct.quantity}" step="1" style="width: 70px">
                            </td>
                            <td class="text-end">
                                <button type="submit" class="btn btn-primary">Set</button>
                                <a href="javascript:confirmDelete('/user/cart/delete/${product.id}')" type="button" class="btn btn-danger">Delete</a>
                            </td>
                            <td class="text-end" nowrap>${cartProduct.sum!} €</td>
                        </tr>
                    </form>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="row">
            <div class="col text-end">
                <strong>${cart.sum!"0.00"} €</strong>
            </div>
        </div>
    <#else>
        <div class="row">No items</div>
    </#if>
</@layout>
