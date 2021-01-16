package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;
import entity.CommentView;


@WebServlet("/Commentm")
public class CommentmServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ccontent=request.getParameter("ccontent");
		String opt=request.getParameter("opt");
		CommentDao cdao=new CommentDao();
		switch (opt) {
		case "query":
			List<CommentView> clist=cdao.queryCommentbyContent(ccontent);
			request.getSession().setAttribute("clist", clist);
			response.sendRedirect("admin/commentm.jsp");
			return;
		case "delete":
			int cid=Integer.valueOf(request.getParameter("cid"));
			cdao.deleteCommentsByCid(cid);
			response.sendRedirect("Commentm?opt=query&ccontent=");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
