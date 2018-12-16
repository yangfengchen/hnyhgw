
$(function () {
    editOptionMessage();
    var _option = {ansyc:false,callBack:initArticleTypes};
    ajaxPostOption("manage/articleType/selectAll",_option);
    CKEDITOR.replace('content',{
        height:'300'
    });
    initEditorSaveBtn();
});
function initArticleTypes(data){
    var _html = "";
    var _articleTypeId = $("#articleTypeId");
    if(data.status == "200"){
        var _data_value = _articleTypeId.attr("data-value");
        $.each(data.data,function(i,val){
            if(_data_value == i){
                _html += "<option value='"+i+"' selected>"+val+"</option>";
            }else{
                _html += "<option value='"+i+"'>"+val+"</option>";
            }
        });
        _articleTypeId.html(_html);
    }
    _articleTypeId.chosen({no_results_text: "找不到选项"});
}

function initEditorSaveBtn(){
    $(document).off("click",".view-editor-save-btn").on("click",".view-editor-save-btn",function () {
        $("#content").text(CKEDITOR.instances.content.getData());
        var _formData = $(this).closest("form").serializeJson();
        ajaxPostCommon($(this).attr("data-url"),_formData,changeFrameContent);
    });
}
