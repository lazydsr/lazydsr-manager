<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLazy v2.0.0 | 控制面板</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<#include "public/publicstatic_css.ftl"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--&lt;!&ndash;[if lt IE 9]>-->
    <!--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
    <!--<![endif]&ndash;&gt;-->

    <!-- Google Font -->
    <!--<link rel="stylesheet"-->
    <!--href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">-->
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
<div id="ajax-loader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #fff; z-index: 10000; overflow: hidden;">
    <img src="../../static/img/ajax-loader.gif" style="position: absolute; top: 0; left: 0; right: 0; bottom: 0; margin: auto;"/>
</div>
<div class="wrapper">

    <!--头部-->
<#include "public/header.ftl"/>
    <!-- Left side column. contains the logo and sidebar -->
    <!--菜单-->
<#include "public/left.ftl"/>
    <!-- Content Wrapper. Contains page content -->
    <!--内容-->
<#include "public/content.ftl"/>
    <!-- /.content-wrapper -->

    <!-- Control Sidebar -->
    <!--右部菜单-->
<#include "public/right.ftl"/>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
         immediately after the control sidebar -->
</div>
<!-- ./wrapper -->

<#include "public/publicstatic_js.ftl"/>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="${ctx}/static/js/adminlazy.js?v=1.0"></script>
<script src="${ctx}/static/js/index.js?v=1.1"></script>
<script src="${ctx}/static/js/indextab.js?v=1.0"></script>
</body>
</html>
