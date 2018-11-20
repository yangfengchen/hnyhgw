<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/ckeditor/ckeditor.js"></script>
    <script type="text/javascript" src="${ctx}/js/ckeditor/config.js"></script>
    <script>
        $(function(){
            CKEDITOR.replace('content',{
                height:'300'
            });
        });
    </script>
</head>
<body>
    <form action="${ctx}/test/save" method="post">
        <textarea id="content" name="content"></textarea>
        123
        <input type="text" name="name" value="123"/>
        <button type="submit" value="dfdsa">fkdsfj</button>
    </form>
</body>
</html>