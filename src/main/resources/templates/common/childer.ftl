<ul class="dropdown-menu">
    <#list menusList as childerMenuBarVo>
        <li>
            <a href="javaScript:void('0')" data-url="${childerMenuBarVo.url!}"
               data-type="${childerMenuBarVo.type!}">${childerMenuBarVo.name!}</a>
            <#if childerMenuBarVo.datas??&&(childerMenuBarVo.datas?size>0)>
                <#assign menusList=childerMenuBarVo.datas>
                <#include "childer.ftl">
            </#if>
        </li>
    </#list>
</ul>