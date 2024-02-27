<@layout>
    <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">Login form</h2>
        <!-- error/signUpOk -->
        <div id="error" class="alert alert-danger" role="alert" style="display: none">
            Login failed. Please check your email/password.
        </div>
        <div id="signUpOk" class="alert alert-success" role="alert" style="display: none">
            Sign up succeeded. Please login.
        </div>
        <script>
            function showIf(searchContains, elementId) {
                if(window.location.search.indexOf(searchContains) >= 0) {
                    document.getElementById(elementId).style.display = "block";
                }
            }
            showIf("?error", "error");
            showIf("?signUpOk", "signUpOk");
        </script>

        <!-- form -->
        <div class="card my-5">
            <form action="/login" method="post" class="card-body cardbody-color p-lg-5">
                <div class="mb-3">
                    <input type="text" class="form-control" name="username" placeholder="email">
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="password">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary mb-3 w-100">Login</button>
                </div>
            </form>
        </div>

    </div>
</@layout>
