<script type="text/javascript" src="${ctx}/js/manage/articleContent/edit.js"></script>
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
        <form action="${ctx}/manage/articleContent/save" method="post" class="form-horizontal">
            <div class="val-display">
                <#if !(entity.id??)>
                    <input type="hidden" name="id" value="${entity.id!}" />
                </#if>
                <input type="hidden" name="createTime" value="${entity.createTime!?datetime}" />
                <input type="hidden" name="publishDate" value="${entity.publishDate!?date}" />
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
                <label for="title" class="col-sm-2 control-label">文章标题：</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="titleName" name="titleName" value="${entity.titleName!}" placeholder="文章类别名称"/>
                </div>
            </div>
            <div class="form-group">
                <label for="articleTypeId" class="col-sm-2 control-label">文章类型：</label>
                <div class="col-sm-10">
                    <select class="form-control option-select" id="articleTypeId" name="articleTypeId" data-value="${entity.articleTypeId!}">
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="sort" class="col-sm-2 control-label">排序：</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="sort" name="sort" value="${entity.sort?default("1")}" placeholder="排序"/>
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
                <label for="content" class="col-sm-2 control-label">内容：</label>
                <div class="col-sm-10">
                    <textarea id="content" name="content">${entity.content!}</textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6 col-md-offset-3 option-btns">
                    <button type="button" class="btn btn-primary view-editor-save-btn" data-url="manage/articleContent/save">保存</button>
                    <button type="button" class="btn btn-primary view-back-btn" data-url="manage/articleContent/index">返回</button>
                </div>
            </div>
        </form>
    </div>
</div>