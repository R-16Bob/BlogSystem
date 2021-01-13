<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

    <title>创建博文</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/starter-template/starter-template.css" rel="stylesheet">
<style>
.table>tbody>tr>td{
    border:0px;
}
</style>
<script type="text/javascript">
//取消
function cancel(){
 	history.go(-1);
 }
</script>
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
            <a class="navbar-brand" href="#">博客首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">我的博客</a></li>
                <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎，${user.uname}</a>

                    <ul class="dropdown-menu">
                        <li><a href="../Login?opt=logout">退出登录</a></li>
                        </li>
                    </ul>
            </ul>
        </div>
    </div>
</nav>

    <div class="container">

      		<form action="../Post" name="fm" method="post">
		<input type="hidden" name=opt value="add">
		<table width="100%" align="center"  class="table">
				<tbody>
					<tr>
						<td height="30"></td>
					</tr>
					<tr>
						<td align="center">
							<h2>创建博文</h2>
						</td>
					</tr>
				</tbody>
			</table>
			<table width="100%" align="center" class="table">
				<tr>
					<td height="30" width="80px" align="right">
						主题：
					</td>
					<td>
						&nbsp;
						<input type="text" name="title" style="width:350px" />
					</td>
				</tr>
				<tr>
					<td height="30" align="right">
						正文：
					</td>
					<td>
						&nbsp;
						<textarea name="pcontent" cols="120" rows="25" ></textarea>
					</td>
				</tr>

				<tr>
					<td height="30">
					</td>
					<td>
						&nbsp;
						<input type='submit'    value=' 发     表 ' />
						&nbsp;&nbsp;
						<input type="button"   onclick="cancel()" value=" 取    消 " />
					</td>
				</tr>
			</table>
		</form>

    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>