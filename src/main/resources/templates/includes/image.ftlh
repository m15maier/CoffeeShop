<#macro image image>
    <#if image.id??>
        <img style="max-width: 240px; max-height: 240px; width: auto; height: auto"
             src="/images/${image.id!}">
    </#if>
</#macro>
