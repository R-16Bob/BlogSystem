package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;

import dao.UserDao;
import entity.User;


@WebServlet("/Userm")
public class UsermServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String opt=request.getParameter("opt");
		UserDao udao=new UserDao();
		switch (opt) {
		case "query":
			List<User> ulist=udao.queryUsersByuname(uname);
			for(User u:ulist)
				System.out.println(u);
			request.getSession().setAttribute("ulist", ulist);
			response.sendRedirect("admin/userm.jsp");
			return;
		case "delete":
			int uid=Integer.valueOf(request.getParameter("uid"));
			udao.deleteUsersByUid(uid);
			response.sendRedirect("Userm?opt=query&uname=");
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
