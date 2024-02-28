<#macro image image>
    <#if image.id??>
        <img style="max-width: 100px; max-height: 100px; width: auto; height: auto"
             src="/images/${image.id!}">
    </#if>
</#macro>
