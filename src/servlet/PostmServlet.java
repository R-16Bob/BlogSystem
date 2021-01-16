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

@WebServlet("/Postm")
public class PostmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao udao=new UserDao();
		PostDao pdao=new PostDao();
		String opt=request.getParameter("opt");
		switch (opt) {
		case "query":
			String title=request.getParameter("title");
			List<Post> allplist=pdao.queryPostBytitle(title);		
			request.getSession().setAttribute("allplist",pdao.getArray(allplist));
			request.getSession().setAttribute("alluname", pdao.queryUnamesByPlist(allplist));
			request.getSession().setAttribute("size", allplist.size());
			response.sendRedirect("admin/postm.jsp");	
			return;
		case "delete":
			int pid=Integer.valueOf(request.getParameter("pid"));
			pdao.deletePostByPid(pid);
			response.sendRedirect("Postm?opt=query&title=");
			return;
		default:
			break;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
