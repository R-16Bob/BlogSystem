package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;

@WebServlet("/UserBlog")
public class UserBlogServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt=request.getParameter("opt");
		int uid=Integer.valueOf(request.getSession().getAttribute("uid").toString());
		PostDao pdao=new PostDao();
		switch (opt) {
		case "queryAll":
			request.getSession().setAttribute("plist", pdao.queryPostsByUid(uid));
			response.sendRedirect("user/userblog.jsp");
			break;

		default:
			break;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
