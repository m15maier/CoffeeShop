<#macro image image>
    <#if image.id??>
        <img style="max-width: 120px; max-height: 120px; width: auto; height: auto"
             src="/images/${image.id!}">
    </#if>
</#macro>
