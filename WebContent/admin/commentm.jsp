<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <style>
        .fixed-table-body{
            overflow:visible !important;
        }
    </style>
    <title>博客系统管理后台</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">博客系统管理后台</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">

                <ul class="dropdown-menu">
                    <li><a href="#">退出登录</a></li>
                    </li>
                </ul>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active1"><a href="../Userm?opt=query&uname=">用户管理</a></li>
                <li class="active2"><a href="#">博文管理</a></li>
                <li class="active"><a href="#">评论管理</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">评论管理</h1>
		<form class="form-inline" role="form" method="post" action="../Index">
            		<input type=text name="title" placeholder="请输入评论内容关键字">
            		<input type=submit class="btn btn-default">
            		</form>
					<br />
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>评论内容</th>
                        <th>发表时间</th>
                        <th>用户</th>
                    </tr>
                    </thead>

                    <tr>
                        <td>1</td>
                        <td>ssss</td>
                        <td>1月1日</td>
                        <td>王伟</td>

                        <td>
                            <a class="btn btn-warning" href="#" role="button" >删除</a>
                        </td>
                    </tr>



            </div>
        </div>
    </div>
    </div>


        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>