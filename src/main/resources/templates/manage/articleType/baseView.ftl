<script type="text/javascript" src="${ctx}/js/manage/articleType/edit.js"></script>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <form action="${ctx}/manage/articleType/edit" method="post" class="form-horizontal">
            <div class="val-display">
                <input type="hidden" name="id" value="${entity.id!}" />
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">文章类别名称：</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="name" name="name" value="${entity.name!}" placeholder="文章类别名称"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">是否启用：</label>
                <div class="col-sm-10 form-group-content-val">
                    <span>
                        ${entity.enable?string("是","否")}
                    </span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6 col-md-offset-3 option-btns">
                    <button type="button" class="btn btn-primary view-back-btn" data-url="manage/articleType/index">返回</button>
                </div>
            </div>
        </form>
    </div>
</div>