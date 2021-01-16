package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;

@WebServlet("/Comment")
public class CommentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author=request.getParameter("author");
		String ccontent=request.getParameter("ccontent");
		int uid=Integer.valueOf(request.getSession().getAttribute("uid").toString());
		int pid=Integer.valueOf(request.getParameter("pid").toString());
		CommentDao cdao=new CommentDao();
		cdao.addComment(ccontent, uid, pid);
		response.sendRedirect("ShowPost?author="+author+"&pid="+pid);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
