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

    <title>博客系统登录</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="Login" method=post>
        <h2 class="form-signin-heading">博客系统登录</h2>
        <p align="center" color=red>${lerror}</p>
        <input type="hidden" name="opt" value="login">
        <input type="text"  class="form-control" name=uname placeholder="用户名" required autofocus>
        <input type="password"  class="form-control" name=upwd placeholder="密码" required>
        <br>
         <a  href="adminLogin.jsp" >管理员登录</a>&nbsp &nbsp &nbsp &nbsp &nbsp
         <a  href="register.jsp" >注册</a>
		<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>
