<script type="text/javascript" src="${ctx}/js/manage/articleType/edit.js"></script>
<#if message??>
    <div class="val-display edit-option-message">
        <div class="edit-option-message-content">
            <div class="option-tips-icon"></div>
            <div class="option-tips-content">${message}</div>
        </div>
    </div>
</#if>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <form action="${ctx}/manage/articleType/save" method="post" class="form-horizontal">
            <div class="val-display">
                <#if !(entity.id??)>
                    <input type="hidden" name="id" value="${entity.id!}" />
                </#if>
                <input type="hidden" name="createTime" value="${entity.createTime!?datetime}" />
                <input type="hidden" name="sort" value="${entity.sort?default("1")}" />
                <input type="hidden" name="type" value="${(entity.type)?default("DEF")}" />
            </div>
            <#if (entity.id??)>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">唯一标识：</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" readonly id="id" name="id" value="${entity.id!}" />
                    </div>
                </div>
            </#if>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">文章类别名称：</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${entity.name!}" placeholder="文章类别名称"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">是否启用：</label>
                <div class="col-sm-10 form-group-content-val">
                   <input type="radio" name="enable" value="true" ${entity.enable?string("checked"," ")}/>是
                    <input type="radio" name="enable" value="false" ${entity.enable?string("","checked")}/>否
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6 col-md-offset-3 option-btns">
                    <button type="button" class="btn btn-primary view-save-btn" data-url="manage/articleType/save">保存</button>
                    <button type="button" class="btn btn-primary view-back-btn" data-url="manage/articleType/index">返回</button>
                </div>
            </div>
        </form>
    </div>
</div>