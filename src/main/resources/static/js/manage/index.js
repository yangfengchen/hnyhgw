$(function () {
    initMenu();
    initViewBackAndCreateBtn();
    initViewSaveBtn();
    initTableEditBtn();
    initTableDelBtn();
});
//填充菜单右边内容
function initMenuData(data) {
    $("#frame-menu").html('').append(data);
    initMenuClick();
    $("#frame-menu li.active a").click();
}
//初始化菜单
function initMenu(){
    ajaxPostCommon("manage/initMenu",undefined,initMenuData);
}
//初始化菜单点击事件
function initMenuClick(){
    $(document).off("click","#frame-menu a").on("click","#frame-menu a",function(){
        var _parent = $(this).parent();
        _parent.addClass("active").siblings().removeClass("active");
        $(".breadcrumb-content li").html($(this).html());
        ajaxPostCommon($(this).attr("data-url"),undefined,changeFrameContent,undefined,changeFrameError);
    });
}

function initViewBackAndCreateBtn(){
    $(document).on("click",".view-back-btn,.view-create-btn",function () {
        ajaxGetCommon($(this).attr("data-url"),changeFrameContent);
    });
}
var enableFormater = function(value,row,index){
    if(value == true){
        return "<span class='label label-success'>启用</span>";
    }else{
        return "<span class='label label-default'>关闭</span>";
    }
}

var optionFormater = function(value,row,index){
    //var _html = '<button type="button" class="btn btn-link glyphicon glyphicon-search view-create-btn" data-url="/baseView?id='+row.id+'">查看</button>';
    var _html = '<button type="button" class="btn btn-link glyphicon glyphicon-pencil view-edit-btn" data-url="/edit?id='+row.id+'">编辑</button>';
    _html += '<button type="button" class="btn btn-link glyphicon glyphicon-minus view-del-btn" data-url="/delete?id='+row.id+'">删除</button>';
    return _html;
}
function initTableEditBtn(){
    $(document).off("click",".view-edit-btn").on("click",".view-edit-btn",function () {
        var _url = $(this).closest("table").attr("data-url");
        ajaxGetCommon(_url + $(this).attr("data-url"),changeFrameContent);
    });
}
function initTableDelBtn(){
    $(document).off("click",".view-del-btn").on("click",".view-del-btn",function () {
        var _table = $(this).closest("table")
        var _url = _table.attr("data-url")+$(this).attr("data-url")+"&tableName="+_table.attr("id");
        ajaxGetCommon(_url,delOptionStatusFun);
    });
}
function htmlOptionCellStyle(value, row, index, field){
    return {
        classes: 'html-option-css',
    };
}
function delOptionStatusFun(data){
    if(data.status=="200"){
        $("#"+data.data).bootstrapTable('refresh');
    }else{
        layer.alert('系统错误，请联系管理员！^--^')
    }
}
function initViewSaveBtn(){
    $(document).on("click",".view-save-btn",function () {
        var _formData = $(this).closest("form").serializeJson();
        ajaxPostCommon($(this).attr("data-url"),_formData,changeFrameContent);
    });
}
function editOptionMessage(){
    if($(".edit-option-message").length>0){
        layer.open({
            type: 1,
            title:"操作提示信息",
            skin: 'layui-layer-demo', //样式类名
            closeBtn: 0, //不显示关闭按钮
            anim: 2,
            shadeClose: true, //开启遮罩关闭
            content: $(".edit-option-message").html()
        });
    }
}


