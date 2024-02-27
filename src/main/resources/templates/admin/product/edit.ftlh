<@layout>
    <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">Edit product</h2>
        <div class="card my-5">
            <form method="post" enctype="multipart/form-data" class="card-body cardbody-color p-lg-5">
                <div class="mb-3">
                    <input type="text" class="form-control" name="title" placeholder="title" value="${product.title!}">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="description" placeholder="description" value="${product.description!}">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="size" placeholder="size" value="${product.size!}">
                </div>
                <div class="mb-3">
                    <input type="number" class="form-control" name="price" placeholder="price" value="${product.price!}">
                </div>
                <div class="mb-3">
                    <label for="previewImage" class="form-label">Preview image</label>
                    <@image image=product.previewImage!/>
                    <input type="file" id="previewImage" accept=".jpg,.jpeg,.gif,.png" class="form-control" name="file1" placeholder="file 1">
                </div>
                <div class="mb-3">
                    <input type="file" accept=".jpg,.jpeg,.gif,.png" class="form-control" name="file2" placeholder="file 2">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="/admin/product/list" type="button" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</@layout>
