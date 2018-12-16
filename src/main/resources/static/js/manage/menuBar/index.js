
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        var $table =  $('#tb_departments');
        $table.bootstrapTable({
            url: $ctx+'/manage/menuBar/list',         //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            striped: true,                      //是否显示行间隔色
            idField: "id",
            columns: [{
                field:'ck',
                checkbox: true
            }, {
                field: 'name',
                title: '导航名称'
            }, {
                field: 'type',
                title: '菜单类型',
                formatter:'menuBarTypeFormater',
            }, {
                field: 'enable',
                title: '是否启用',
                formatter:'enableFormater',
            },{
                field:'htmlOption',
                title:'操作',
                formatter:'menuBarOptionFormater',
                cellStyle:{
                    classes: 'html-tree-option-css',
                },
            }]/*,
            onDblClickRow:function(row){
                ajaxGetCommon("manage/articleType/edit?id="+row.id,changeFrameContent);
            }*/
            ,
            //每一行的唯一标识，一般为主键列
            //在哪一列展开树形
            treeShowField: 'name',
            parentIdField: 'parentId',
            onLoadSuccess: function(data) {
                // jquery.treegrid.js
                $table.treegrid({
                    // initialState: 'collapsed',
                    treeColumn: 1,
                    // expanderExpandedClass: 'glyphicon glyphicon-minus',
                    // expanderCollapsedClass: 'glyphicon glyphicon-plus',
                    onChange: function() {
                        $table.bootstrapTable('resetWidth');
                    }
                });
            }
        });
    };
    return oTableInit;
}();
function menuBarOptionFormater(value,row,index){
    var _html = '<button type="button" class="btn btn-link glyphicon glyphicon-pencil view-edit-btn" data-url="/edit?id='+row.entityId+'">编辑</button>';
    _html += '<button type="button" class="btn btn-link glyphicon glyphicon-plus view-edit-btn" data-url="/addChilder?id='+row.entityId+'">添加子项</button>';
    _html += '<button type="button" class="btn btn-link glyphicon glyphicon-minus view-del-btn" data-url="/delete?id='+row.entityId+'">删除</button>';
    return _html;
}
function menuBarTypeFormater(value,row,index) {
    return initVal($menuTypes[value]);
}
var $menuTypes;
$(function(){
    $menuTypes = JSON.parse($("#menuTypes").text());
    TableInit.Init();
});
