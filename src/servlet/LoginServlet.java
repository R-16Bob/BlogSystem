package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import entity.User;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		String opt=request.getParameter("opt");
		UserDao udao=new UserDao();
		List<User> uList;
		switch (opt) {
		case "login":
			//从数据库查用户
			uList=udao.queryUsersByType(1);
			if(udao.verify(uname,upwd,uList)) {
				request.getSession().removeAttribute("lerror");
				//进入登录页面,并设置Session属性uname、uid
				User user=udao.queryUserByuname(uname);
				request.getSession().setAttribute("uname",user.getUname());
				request.getSession().setAttribute("uid",user.getUid());
				response.sendRedirect("UserBlog?opt=queryAll");
				return;
			}
			else {
				request.getSession().setAttribute("lerror", "用户名或密码错误");
				response.sendRedirect("login.jsp");
			}
			break;
		case "adminlogin":
			//从数据库查管理员
			uList=udao.queryUsersByType(2);
			if(udao.verify(uname,upwd,uList)) {
				request.getSession().removeAttribute("aerror");
				//进入管理后台页面
				User user=udao.queryUserByuname(uname);
				request.getSession().setAttribute("admin",user.getUname());
				response.sendRedirect("Userm?opt=query&uname=");
			}
			else {
				request.getSession().setAttribute("aerror", "用户名或密码错误");
				response.sendRedirect("adminLogin.jsp");
			}
			break;
		case "register":
			String pwdagain=request.getParameter("pwdagain");
			if(!pwdagain.equals(upwd)) {
				request.getSession().setAttribute("rerror", "两次密码不一致");
				response.sendRedirect("register.jsp");
				return;
			}
			//从数据库查所有用户，判断是否重名
			uList=udao.queryAllUsers();
			for(User u:uList) {
				if(u.getUname().equals(uname)) {
					request.getSession().setAttribute("rerror", "该用户名已注册");
					response.sendRedirect("register.jsp");
					return;
				}
			}
			udao.addUser(uname, upwd);
			request.getSession().setAttribute("lerror", "注册成功！");
			response.sendRedirect("login.jsp");
			break;
		case "logout":
			//退出登录
			request.removeAttribute("user");
			request.removeAttribute("admin");
			response.sendRedirect("login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
