<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/script_common.ftl"/>
    <style type="text/css">
        html,body,.container{
            height: 100%;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("#loginBtn").click(function () {
                ajaxPostCommon("manage/ajaxLogin",undefined,loginBack);
            });
        });
        function loginBack(data){
            if(data.status == "200"){
                window.location.href = $ctx+"/manage/index";
            }else{
                $("#error-content").html(data.message);
                $("#errorMsg").show();
                setTimeout(function () {
                    $("#error-content").html(data.message);
                    $("#errorMsg").hide();
                },3000);
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <form action="${ctx}/manage/login" method="post" style="width: 100%;height: 100%;display: table;">
            <div style="display: table-cell;vertical-align: middle;">
                <div  style="width: 300px;margin: 0 auto;">
                    <div class="form-group">
                        <div style="color:red;display: none;" id="errorMsg">
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <span id="error-content"></span>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" style="width: 70px;">用户名：</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名...">
                    </div>
                    <div class="form-group">
                        <label for="pwd"  style="width: 70px;">密码：</label>
                        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码...">
                    </div>
                    <div class="form-group">
                        <div style="text-align: right;">
                            <button type="button" id="loginBtn" class="btn btn-primary btn-sm">登录</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>
</html>