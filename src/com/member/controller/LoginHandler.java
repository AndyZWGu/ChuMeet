package com.member.controller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.MemberService;
import com.member.model.MemberVO;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Loginhandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		List<String> errorMsgs = new LinkedList<String>();
		req.setAttribute("errorMsgs", errorMsgs);
		// ��ȡ��ʹ���� ��̖(account) �ܴa(password)��
		String memEmail = req.getParameter("memEmail");
		String memPw = req.getParameter("memPw");

		// �Y�ϸ�ʽ��C
		if (memEmail == null || (memEmail.trim()).length() == 0) {
			errorMsgs.add("Ոݔ����T��̖");
		}
		if (memPw == null || (memPw.trim()).length() == 0) {
			errorMsgs.add("Ոݔ����T�ܴa");
		}
		if (!errorMsgs.isEmpty()) {
			RequestDispatcher failureView = req.getRequestDispatcher("register.jsp");
			failureView.forward(req, res);
			return;
		}

		// ���z��ԓ��̖ , �ܴa�Ƿ���Ч��
		if (!allowUser(memEmail, memPw)) { // ����̖ , �ܴa�oЧ�r��
			errorMsgs.add("��o��̖���ܴa�e�`,Ո���µ���");
			RequestDispatcher failureView = req.getRequestDispatcher("login.jsp");
			failureView.forward(req, res);
			return;
		} else { // ����̖ , �ܴa��Ч�r, �������¹�����
			MemberService memSvc = new MemberService();
			MemberVO memVO = memSvc.getMemberByMemEmail(memEmail);
			//��վ��+1
			memSvc.updateLoginNumMember(memVO);
			HttpSession session = req.getSession();
			session.setAttribute("account", memEmail); // *����1:
														// ����session�����ѽ������^�Ę��R
			session.setAttribute("memVO", memVO);
			try {
				String location = (String) session.getAttribute("location");
				if (location != null) {
					session.removeAttribute("location"); // *����2: �����Пo��Դ�W�
															// (-->���Ё�Դ�W�:�t�،�����Դ�W�)(��)(��������)
//					res.sendRedirect(location);
					res.sendRedirect(req.getContextPath() + "/front-end/index.jsp");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			res.sendRedirect(req.getContextPath() + "/front-end/index.jsp"); // *����3:
																				// (-->��o��Դ�W�:�t�،���index.jsp)
		}
	}
	// ���z��ʹ����ݔ��Ď�̖(account) �ܴa(password)�Ƿ���Ч��
	// �����H�ϑ����Y�ώ��ь��Ȍ���
	protected boolean allowUser(String memEmail, String memPw) {
		MemberService memSvc = new MemberService();
		MemberVO memEmailVO = memSvc.getMemberByMemEmail(memEmail);
		if (memEmailVO != null && memEmailVO.getMemEmail().equals(memEmail) && memEmailVO.getMemPw().equals(memPw)) {
			return true;
		} else
			return false;
	}
	
}