<#if menuVoAll?? && (menuVoAll?size>0)>
    <ul class="nav nav-pills nav-stacked">
        <#list menuVoAll as menuVo>
            <li role="presentation" class="<#if menuVo_index==0>active</#if>">
                <a href="javaScript:void('0');" data-url="${menuVo.url}" class="menuVo-a">
                    ${menuVo.name}
                </a>
            </li>
        </#list>
    </ul>
</#if>