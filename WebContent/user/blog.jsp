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
    <title>${otheruname}的博客</title>

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
            <a class="navbar-brand" href="../Index?title=">博客首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                    <li><a href="../Blog?uid=${uid}">我的博客</a></li>
                        <li><a href="../UserBlog?opt=queryAll">我的博客管理</a></li>
                        <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎，${uname}</a>
        
                            <ul class="dropdown-menu">
                                <li><a href="../Login?opt=logout">退出登录</a></li>
                                </li>
                            </ul>
                    </ul>
                </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">

        <div class="col-sm-11 col-sm-offset-1  main">
            <h1 class="page-header">${otheruname}的博客</h1>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>主题</th>
                        <th>发表时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="post" items="${otherplist}">
                    <tr>
                        <td>${post.pid}</td>
                        <td><a href="../ShowPost?author=${otheruname}&pid=${post.pid}" target="_blank">${post.title} </a></td>
                        <td>${post.created}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
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