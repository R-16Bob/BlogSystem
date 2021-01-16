package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.CommentDao;
import dao.PostDao;
import entity.CommentView;
import entity.Post;

@WebServlet("/ShowPost")
public class ShowPostServlet extends HttpServlet {	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int pid=Integer.valueOf(request.getParameter("pid"));
		String author=request.getParameter("author");
		PostDao pdao=new PostDao();
		CommentDao cdao=new CommentDao();
		Post post=pdao.queryPostBypid(pid);
		List<CommentView> clist=cdao.queryCommentBypid(pid);
		//设置三个Session属性：post\author\clist
		request.getSession().setAttribute("post", post);
		request.getSession().setAttribute("author",author);
		request.getSession().setAttribute("clist", clist);
		//跳转到post.jsp
		response.sendRedirect("user/post.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
