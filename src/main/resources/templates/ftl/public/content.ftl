<!--主要内容区域  开始-->
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <div class="content-tabs">
        <button class="roll-nav roll-left tabLeft">
            <i class="fa fa-backward"></i>
        </button>
        <nav class="page-tabs menuTabs">
            <div class="page-tabs-content" style="margin-left: 0px;">
                <a href="javascript:;" id="LAZY-main-tab" class="menuTab active" data-id="${ctx}/basic/index/index">欢迎首页</a>
                <!--<a href="javascript:;" class="menuTab" data-id="indexIframe2.html" style="padding-right: 15px;">平台介绍 <i class="fa fa-remove"></i></a>-->
                <!--<a href="javascript:;" class="menuTab" data-id="/SystemManage/Organize/Index">机构管理 <i class="fa fa-remove"></i></a>-->
            </div>
        </nav>
        <button class="roll-nav roll-right tabRight">
            <i class="fa fa-forward" style="margin-left: 3px;"></i>
        </button>
        <div class="btn-group roll-nav roll-right">
            <button class="dropdown tabClose" data-toggle="dropdown">
                页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
            </button>
            <ul class="dropdown-menu dropdown-menu-right">
                <li><a class="tabReload" href="javascript:void(0);">刷新当前</a></li>
                <li><a class="tabCloseCurrent" href="javascript:void(0);">关闭当前</a></li>
                <li><a class="tabCloseAll" href="javascript:void(0);">全部关闭</a></li>
                <li><a class="tabCloseOther" href="javascript:void(0);">除此之外全部关闭</a></li>
            </ul>
        </div>
        <button class="roll-nav roll-right fullscreen"><i class="fa fa-arrows-alt"></i></button>
    </div>

    <div class="content-iframe" style="overflow: hidden;">

        <div class="mainContent" id="content-main" style="margin: 0; padding: 0;">
            <!--<div id="" style="cursor: progress; position: fixed;  width: 100%; height: 100%; background: #fff; overflow: hidden;margin: 0 auto;">-->
            <div id="ajax-loader-iframe" style="cursor: progress;position:fixed; width: 100%; height: 100%;overflow: hidden;display: none">
                <img style="position: absolute;top:40%;margin-left:38%;transform: translateY(20%);" src="${ctx}/static/img/ajax-loader.gif"/>
            </div>
            <iframe id="LAZY-main-iframe" class="LAZY-main-iframe" width="100%" height="100%" src="${ctx}/home/indexIframe" frameborder="0" data-id="${ctx}/basic/index/index"></iframe>
            <!--<iframe class="LAZY-main-iframe" style="display: none" width="100%" src="indexIframe2.html" frameborder="0" data-id="indexIframe2.html"></iframe>-->
        </div>
    </div>
</div>
<!-- /.content-wrapper -->
<!--主要内容区域  结束-->