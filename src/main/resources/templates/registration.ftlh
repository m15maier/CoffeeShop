<@layout>
    <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">Sign up form</h2>

        <!-- form -->
        <div class="card my-5">
            <form action="/registration" method="post" class="card-body cardbody-color p-lg-5">
                <div class="mb-3">
                    <input type="text" class="form-control" name="username" placeholder="name">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="email" placeholder="email">
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="password">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="phone" placeholder="phone number">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="address" placeholder="address">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary mb-3 w-100">Sign up</button>
                </div>
            </form>
        </div>

    </div>
</@layout>
