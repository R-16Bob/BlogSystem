package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;
import dao.UserDao;
import entity.Post;

@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//与用户自己的uid和uname区分
		UserDao udao=new UserDao();
		PostDao pdao=new PostDao();
		List<Post> allplist=pdao.queryAllPosts();		
		request.getSession().setAttribute("allplist",pdao.getArray(allplist));
		request.getSession().setAttribute("alluname", pdao.queryUnamesByPlist(allplist));
		request.getSession().setAttribute("size", allplist.size()-1);
		response.sendRedirect("user/index.jsp");	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
