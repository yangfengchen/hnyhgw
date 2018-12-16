<script type="text/javascript" src="${ctx}/js/portal/contentList.js"></script>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <form action="${ctx}/contentRest" method="post" class="form-inline">
            <input type="hidden" name="articleTypeId" id="articleTypeId" value="${type!}"/>
        </form>
    </div>
</div>
<div class="row">
    <div class="col-md-12 col-xs-12">
        <table id="tb_departments" data-url="contentRest"></table>
    </div>
</div>

