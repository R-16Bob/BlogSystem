package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.PostDao;
import entity.User;


@WebServlet("/Post")
public class PostServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String pcontent=request.getParameter("pcontent");
		String opt=request.getParameter("opt");
		int uid=Integer.valueOf(request.getSession().getAttribute("uid").toString());
		PostDao pdao=new PostDao();
		switch (opt) {
		case "add":
			pdao.addPost(title, pcontent, uid);
			response.sendRedirect("user/userblog.jsp");
			break;
		
		}
		System.out.println("hello");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
