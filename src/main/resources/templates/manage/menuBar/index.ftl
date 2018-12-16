<script type="text/javascript" src="${ctx}/js/manage/menuBar/index.js"></script>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <form action="${ctx}/manage/menuBar/index" method="post" class="form-inline">

        </form>
    </div>
</div>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <div class="option-menu">
            <textarea id="menuTypes" style="display: none;">${menuTypes!}</textarea>
            <button type="button" class="btn btn-link glyphicon glyphicon-plus view-create-btn" data-url="manage/menuBar/create">新增</button>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <table id="tb_departments" data-url="manage/menuBar"></table>
    </div>
</div>

