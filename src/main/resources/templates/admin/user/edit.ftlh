<@layout>
    <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">Edit user</h2>
        <div class="card my-5">
            <form method="post" class="card-body cardbody-color p-lg-5">
                <div class="mb-3">
                    <label for="username" class="form-label">Name</label>
                    <input type="text" class="form-control" name="username" value="${user.username!}">
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="text" class="form-control" name="phone" value="${user.phone!}">
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" name="address" value="${user.address!}">
                </div>
                <div class="mb-3">
                    <label for="role" class="form-label">Role</label>
                    <select class="form-select" aria-label="Role"name="role">
                        <#list Role as role>
                            <option value="${role}" <#if user.role == role>selected</#if>>${role}</option>
                        </#list>
                    </select>
                </div>

                <div class="mb-3">
                    <input class="form-check-input" type="checkbox" value="true" name="active" id="active" ${user.active? string('checked', '')}>
                    <label class="form-check-label" for="active">Active</label>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Save</button>
                    <a href="/admin/user/list" type="button" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>
    </div>
</@layout>
