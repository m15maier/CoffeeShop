<!-- https://getbootstrap.com/docs/5.3/components/alerts/ -->

<!-- error(s) -->
<#if errorMessage??>
    <div id="errorMessage" class="alert alert-danger" role="alert">
        ${errorMessage}
    </div>
</#if>
<#if errors??>
    <div id="errorMessage" class="alert alert-danger" role="alert">
        <#list errors as error>
            <li>${error.field}: ${error.defaultMessage}</li>
        </#list>
    </div>
</#if>

<!-- info -->
<#if infoMessage??>
    <div id="infoMessage" class="alert alert-successr" role="alert">
        ${infoMessage}
    </div>
</#if>

<!-- confirmDelete Modal -->
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="confirmDeleteModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Confirm delete</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Please confirm deletion
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" onclick="javascript:submitDeleteAction()">Delete</button>
            </div>
        </div>
    </div>
</div>
<form id="deleteForm" method="post" style="display: none">
</form>
<script>
    var confirmDeleteModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'));
    var deleteForm = document.getElementById('deleteForm')

    function confirmDelete(deleteAction) {
        deleteForm.action = deleteAction;
        confirmDeleteModal.show();
    }

    function submitDeleteAction() {
        deleteForm.submit();
    }
</script>
