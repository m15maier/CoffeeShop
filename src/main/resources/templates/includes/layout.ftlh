<#import "/spring.ftl" as spring/>
<#include '/includes/image.ftlh'>
<#assign known = SPRING_SECURITY_CONTEXT??>
<#if known>
    <#assign user = SPRING_SECURITY_CONTEXT.authentication.principal>
</#if>

<#macro layout>

    <!doctype html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <title>CoffeeShop</title>
        <!-- bootstrap 5: https://getbootstrap.com/ -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
              rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
                crossorigin="anonymous"></script>
    </head>
    <body>

    <!-- https://getbootstrap.com/docs/5.0/components/navbar/ -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container">
            <a class="navbar-brand" href="#">CoffeeShop</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="/">Home</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Admin
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <li><a class="dropdown-item" href="/admin/product/list">Products</a></li>
                            <li><a class="dropdown-item" href="/admin/user/list">Users</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="d-flex">
                    <#if known>
                        <div class="navbar-brand" href="#">${user.getUsername()} : ${user.getRole()}</div>
                        <#if user.isAdmin()>
                            <a href="/admin" class="btn btn-light ms-3">Admin Panel</a>
                        </#if>
                        <a href="/logout" class="btn btn-light ms-3">Logout</a>
                    <#else>
                        <a href="/login" class="btn btn-light ms-3">Login</a>
                        <a href="/registration" class="btn btn-light ms-3">Sign up</a>
                    </#if>
                </div>
            </div>
        </div>
    </nav>

    <div class="container" style="padding-top: 10px">
        <#include "/includes/messages.ftlh">
        <#nested>
    </div>
    </body>
    </html>
</#macro>
