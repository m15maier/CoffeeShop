<@layout>
    <div class="row">
        <br>
        <h1>All Products</h1>
        <br>
        <#list products as product>
            <div class="col">
                <div class="card" style="width: 18rem;">
                    <div class="p-3">
                        <@image image=product.previewImage!/>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title">${product.title!}</h5>
                        <p class="card-text"><small>${product.description!}</small></p>
                        <div class="row p-4">
                            <div class="col">
                                ${product.size!}
                            </div>
                            <div class="col text-end">
                                ${product.price!"0.00"}€
                            </div>
                        </div>
                        <form method="post" action="/user/cart/add/${product.id!}" class="row">
                            <div class="col">
                                <input type="number" class="form-control" name="quantity" placeholder="1" value="1" step="1">
                            </div>
                            <div class="col">
                                <button type="submit" class="btn btn-dark">Add to cart</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        <#else>
            No items
        </#list>
    </div>
</@layout>
