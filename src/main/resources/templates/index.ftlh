<@layout>
    <#list products as product>
        <div class="card" style="width: 18rem;">
            <div class="p-3">
                <@image image=product.previewImage!/>
            </div>
            <div class="card-body">
                <h5 class="card-title">${product.title!}</h5>
                <p class="card-text">${product.description!}</p>
                <td class="text-end">${product.price!"0.00"}€</td>
                <form method="post">
                    <input type="number" class="form-control" name="amount" placeholder="1" value="1" size="2">
                    <button type="submit" class="btn btn-primary">Add to cart</button>
                </form>
            </div>
        </div>
    <#else>
        No items
    </#list>
</@layout>
