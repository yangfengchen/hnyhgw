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