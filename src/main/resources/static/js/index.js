$(function(){
    partalMenu();
});
function partalMenu() {
    $(document)
        .off("click",".portal-menu li a")
        .on("click",".portal-menu li a",function(){
        //处理选中事件
        var _portalMenu = $(".portal-menu");
        _portalMenu.find("li.firstMenu").removeClass("active");
        $(this).closest("li.firstMenu").addClass("active");
        //处理点击事件
        var _type = $(this).attr("data-type");
        if(_type == "custom"){//自定义
            ajaxGetCommon($(this).attr("data-url"),initPortalContent);
        }else if(_type == "info"){//详细页面
            ajaxGetCommon("contentInfo?id="+$(this).attr("data-url"),initPortalContent);
        }else if(_type == "list"){//列表页面
            ajaxGetCommon("contentList?type="+$(this).attr("data-url"),initPortalContent);
        }else if(_type == "external"){//外部
            window.open($(this).attr("data-url"));
        }
    });
}
function initPortalContent(data){
    $(".portal-content").html(data);
}