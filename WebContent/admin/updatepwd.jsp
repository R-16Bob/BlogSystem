<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- 给网页加图标 -->
    <link rel="icon" href="">

    <title>修改密码</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form class="form-signin" action="../Userm" method=post>
        <h2 class="form-signin-heading">修改密码</h2>
        <input type="hidden" name="opt" value="update">
        <input type="hidden" name="theuid" value="${theuid}">
        <p align="center" color=red>${rerror}</p>
        <input type="text"  class="form-control" name=theuname value="${theuname}" disabled required autofocus>
        <input type="password"  class="form-control" name=upwd placeholder="新密码" required>

        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">修改</button>
    </form>

</div> <!-- /container -->

</body>
</html>