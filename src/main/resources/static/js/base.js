$.fn.serializeJson=function(){
    var serializeObj={};
    $(this.serializeArray()).each(function(){
        serializeObj[this.name]=this.value;
    });
    return serializeObj;
};
$.fn.serializeJsonStr=function(){
    var serializeObj={};
    $(this.serializeArray()).each(function(){
        serializeObj[this.name]=this.value;
    });
    return JSON.stringify(serializeObj);
};

if(!String.prototype.splitSign){ //判断下浏览器是否自带有splitSign方法
    String.prototype.splitSign = function() {

    };
}
function splitSign(val){
    if(val){
        var _typeOfVal = typeof(val);
        if(_typeOfVal == "String" || _typeOfVal == "string"){
            return val.replace(/\"/g,"”").replace(/</g,"《").replace(/>/g,"》").replace(/\r\n/g,"<br/>").replace(/\n/g,"<br/>").replace(/\r/g,"<br/>");
        }else{
            return val;
        }
    }else{
        return "";
    }
}
if(!String.prototype.trim){ //判断下浏览器是否自带有trim()方法
    String.prototype.trim = function() {
        return this.replace(/^\s+|\s+$/g, '');
    };
    String.prototype.ltrim = function() {
        return this.replace(/^\s+/g, '');
    };
    String.prototype.rtrim = function() {
        return this.replace(/\s+$/g, '');
    };
}
var ajaxGetCommon = function(url,callBack,callData,errorBack){
    $.ajax({
        url:$ctx+"/"+url,
        type:"get",
        success:function (data) {
            if(callBack && typeof(callBack) == 'function'){
                if(callBack){
                    callBack(data,callData);
                }else{
                    callBack(data);
                }
            }
        },
        error:function () {
            if(errorBack && typeof(errorBack) == 'function'){
                errorBack();
            }else{
                errorContent();
            }
        }
    });
};
var ajaxPostCommon = function(url,data,callBack,callData,errorBack){
    var _option = {
        data:data,
        callBack:callBack,
        callData:callData,
        errorBack:errorBack
    }
    ajaxPostOption(url,_option);
};
var ajaxPostOption = function(url,_option){
    if(!_option.data){
        _option.data={};
    }
    if(_option.ansyc == undefined){
        _option.ansyc = false;
    }
    $.ajax({
        url:$ctx+"/"+url,
        data:_option.data,
        type:"post",
        ansyc:_option.ansyc,
        success:function (data) {
            if(typeof(_option.callBack) == 'function'){
                if(_option.callData){
                    _option.callBack(data,_option.callData);
                }else{
                    _option.callBack(data);
                }
            }
        },
        error:function (data) {
            if(_option.errorBack && typeof(_option.errorBack) == 'function'){
                _option.callBack(data);
            }else{
                errorContent();
            }
        }
    });
}

var changeFrameContent = function(data){
 $("#frame-content").html(data);
}
function changeFrameError(data) {
    $("#frame-content").html();
    errorContent();
}
var errorContent = function(){
    layer.alert('系统错误，请联系管理员！^--^');
}
var initVal = function(_val,_defVal){
    if(_val){
        return _val;
    }else{
        if(_defVal){
            return _defVal;
        }else{
            return "";
        }
    }
}

//转换日期格式(时间戳转换为datetime格式)
function changeDateFormat(cellval, row, index) {
    if(cellval.indexOf(":") != -1){
        return cellval.substring(0,10);
    }else{
        return cellval;
    }
}