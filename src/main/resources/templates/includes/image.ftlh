<#macro image image>
    <#if image.id??>
        <img style="max-width: 80px; max-height: 80px; width: auto; height: auto"
             src="/images/${image.id!}" width="80" height="80">
    </#if>
</#macro>
