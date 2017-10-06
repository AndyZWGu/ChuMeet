package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {

	private FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// ��ȡ�� session��
		HttpSession session = req.getSession();
		// ���� session �Д��user�Ƿ�����^��
		Object account = session.getAttribute("account");
		Object memVO = session.getAttribute("memVO");
		if (account == null || memVO == null) {
			session.setAttribute("location", req.getRequestURI());
			res.sendRedirect(req.getContextPath() + "/front-end/member/login.jsp");
			return;
		} else {
			chain.doFilter(request, response);
		}
	}
}