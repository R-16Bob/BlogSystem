package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;
import dao.UserDao;
import entity.User;

@WebServlet("/Blog")
public class BlogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//与用户自己的uid和uname区分
		int otheruid=Integer.valueOf(request.getParameter("uid").toString());
		UserDao udao=new UserDao();
		String otheruname=udao.queryUnameByUid(otheruid);
		PostDao pdao=new PostDao();
		request.getSession().setAttribute("otherplist", pdao.queryPostsByUid(otheruid));
		request.getSession().setAttribute("otheruname", otheruname);
		response.sendRedirect("user/blog.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
