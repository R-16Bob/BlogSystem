package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.collections.CaseInsensitiveKeyMap;
import org.omg.CORBA.IRObject;

import dao.PostDao;
import entity.Post;
import entity.User;


@WebServlet("/Post")
public class PostServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title=request.getParameter("title");
		String pcontent=request.getParameter("pcontent");
		String opt=request.getParameter("opt");
		int uid=1,pid=0;
		if(request.getSession().getAttribute("uid")!=null)
			uid=Integer.valueOf(request.getSession().getAttribute("uid").toString());
		if(request.getParameter("pid")!=null)
			pid=Integer.valueOf(request.getParameter("pid").toString());
		PostDao pdao=new PostDao();
		switch (opt) {
		case "add":
			if(pdao.addPost(title, pcontent, uid)>0) {
				request.getSession().setAttribute("message", "博文发表成功！");
				response.sendRedirect("user/message.jsp");
				return;
			}
			else {
				request.getSession().setAttribute("message", "博文发表失败！请保证正文不超过1000字。");
				response.sendRedirect("user/message.jsp");
				return;
			}
			
		case "delete":
			pdao.deletePostByPid(pid);
			response.sendRedirect("UserBlog?opt=queryAll");
			return;
		case "update":
			if(pdao.updatePost(pid, title, pcontent)>0) {
				request.getSession().setAttribute("message", "博文修改成功！");
				response.sendRedirect("user/message.jsp");
				return;
			}
			else {
				request.getSession().setAttribute("message", "博文修改失败！请保证正文不超过1000字。");
				response.sendRedirect("user/message.jsp");
				return;
			}
		case "edit":
			//先跳到一个编辑页面
			Post post=pdao.queryPostBypid(pid);
			request.getSession().setAttribute("title", post.getTitle());
			request.getSession().setAttribute("pcontent", post.getPcontent());
			request.getSession().setAttribute("pid", post.getPid());
			response.sendRedirect("user/updatepost.jsp");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
