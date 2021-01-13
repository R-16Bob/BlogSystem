package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq=(HttpServletRequest)req;
		HttpServletResponse hres=(HttpServletResponse)res;
		hreq.setCharacterEncoding("UTF-8");
		hres.setCharacterEncoding("UTF-8");
		chain.doFilter(hreq, hres);
	}

}
