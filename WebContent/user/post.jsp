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

    <title>${post.title}</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../css/blog.css" rel="stylesheet">

   <style>
   
           .commentTitle {
               height: 50px;
               width:860px;
               text-align: left;
               font-size: 32px;
               background-color:#eaeaea;
           }
   
   
       </style>
  </head>

  <body>

    <div class="blog-masthead">
      <div class="container">
        <nav class="blog-nav">
          <a class="blog-nav-item " href="../Index?title=">首页</a>
          <a class="blog-nav-item " href="../Blog?uid=${post.uid}">博文目录</a>
        </nav>
      </div>
    </div>


<div class="container">

    <div class="row">

        <div class="col-sm-8 blog-main">

            <div class="blog-post">
				<br>
                <h2 class="blog-post-title">${post.title}</h2>
                <p class="blog-post-meta">${post.created} by <a href="../Blog?uid=${post.uid}">${author}</a></p>

                <p>${post.pcontent}</p>
         
            <br>
			<hr>
			<div class="commentTitle" align="left">
			    评论：
				
			</div> <br>
            <ul class="list-group">
                <c:forEach var="comment" items="${clist}">
                <li class="list-group-item"><p>${comment.uname}: ${comment.ccontent}</p>
                <p>${comment.created}</p></li>
                </c:forEach>
            </ul>
			<hr>
            <div class="commentTitle" align="left">
                参与评论：
            </div> <br>
            <form action="../Comment" method="post">
            <input type="hidden" name="pid" value="${post.pid}">
            <input type="hidden" name="author" value="${author}">
            <textarea name="ccontent" cols="97" rows="10" ></textarea>
            <input type='submit'    value='提   交 ' />
            </form>
        </div><!-- /.blog-main -->





    </div><!-- /.row -->

</div><!-- /.container -->



<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>