package filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.*;

public class MemPrivFilter implements Filter {

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
		// ��ȡ�� ԓ���T�[˽�O����
		String memID = req.getParameter("memID");
		if(memID!=null){
			MemberService memSvc = new MemberService();
			MemberVO memVO = memSvc.getOneMember(Integer.valueOf(memID));
			Integer memPriv = memVO.getMemPriv();
			// ���� �[˽�O��������P�S�Д��Ƿ����_���Y�ϲ�ԃ��
			HttpSession session = req.getSession();
			//0���_��1����2���_
			if(memPriv==0){
				session.setAttribute("guestPriv", 0);
				chain.doFilter(request, response);
			}else if(memPriv==1 && memID!=null){
				session.setAttribute("guestPriv", 1);
				chain.doFilter(request, response);
			}else if (memPriv==2){
				session.setAttribute("guestPriv", 1);
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}

		
	}
}