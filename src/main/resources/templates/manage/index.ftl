<!DOCTYPE html>
<html lang="en">
<head>
    <#include "../common/script_common.ftl"/>
    <script type="text/javascript" src="${ctx}/js/manage/index.js"></script>
</head>
<body>
    <div class="container-fluid">
        <#include "../common/header.ftl"/>

        <div class="row main-content">
            <div class="col-md-3 col-xs-3">
                <div id="frame-menu" class="frame-menu border-common">

                </div>
            </div>
            <div class="col-md-9 col-xs-9 border-common">
                <div class="breadcrumb-content">
                    <ol class="breadcrumb">
                        <li class="active"></li>
                    </ol>
                </div>
                <div id="frame-content" class="frame-content ">

                </div>
            </div>
        </div>
        <#include "../common/footer.ftl"/>
    </div>
</body>
</html>