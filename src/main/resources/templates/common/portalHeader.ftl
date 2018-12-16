<div class="row">
    <div class="col-md-12 col-xs-12">
        <div style="position: relative;">
            <div style="height: 120px;"></div>
            <div class="hearder-content">
                <img src="${ctx}/img/index.png" class="index-img">
                <div class="hearder-title">湖南引航教育咨询有限公司</div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <div class="portal-menu">
            <#if menuBarVos??>
                <ul class="nav nav-tabs nav-pills">
                    <#list menuBarVos as menuBarVo>
                            <li role="presentation" class="firstMenu <#if menuBarVo_index==0> active </#if>
                                <#if menuBarVo.datas??&&(menuBarVo.datas?size>0)> dropdown</#if>"
                            >
                                <a href="javaScript:void('0')" data-url="${menuBarVo.url!}"
                                   data-type="${menuBarVo.type}"
                                   class="<#if menuBarVo.datas??&&(menuBarVo.datas?size>0)> dropdown</#if>"
                                   <#if menuBarVo.datas??&&(menuBarVo.datas?size>0)> data-toggle="dropdown" </#if>
                                >${menuBarVo.name!}</a>
                                <#if menuBarVo.datas??&&(menuBarVo.datas?size>0)>
                                    <#assign menusList=menuBarVo.datas>
                                    <#include "childer.ftl">
                                </#if>
                            </li>

                    </#list>
                </ul>
            </#if>
        </div>
    </div>
</div>