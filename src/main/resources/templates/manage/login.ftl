<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#include "../common/script_common.ftl"/>
</head>
<body>
    <div class="container">
        <form action="${ctx}/manage/login" method="post">
            <div class="form-group">
                <label for="name">Email address</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入用户名...">
            </div>
            <div class="form-group">
                <label for="pwd">Email address</label>
                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入密码...">
            </div>
        </form>
    </div>
</body>
</html>