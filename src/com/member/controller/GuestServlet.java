package com.member.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.model.MemberService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
//		String action = "login";
		
		if ("login".equals(action)) { // ����login.jsp��Ո��

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.����Ո�󅢔� - ݔ���ʽ���e�`̎��**********************/
				String memEmail = req.getParameter("memEmail");
				String memPw = req.getParameter("memPw");
//				String memEmail = "adm@gmail";
//				String memPw = "Master";
				if (memEmail == null || (memEmail.trim()).length() == 0) {
					errorMsgs.add("Ոݔ����T��̖");
				}
				if (memPw == null || (memPw.trim()).length() == 0) {
					errorMsgs.add("Ոݔ����T�ܴa");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/login.jsp");
					failureView.forward(req, res);
					return;//��ʽ�Д�
				}
				
				String formatMemEmail = null;
				String formatMemPw = null;
				try {
					formatMemEmail = new String();
					formatMemPw = new String();
				} catch (Exception e) {
					errorMsgs.add("ݔ���ʽ�����_");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/emp/select_page2.jsp");
					failureView.forward(req, res);
					return;//��ʽ�Д�
				}
				
				/***************************2.�_ʼ��ԃ�Y��*****************************************/
				MemberService memSvc = new MemberService();
				MemberVO memVO = memSvc.getMemberByMemEmail(memEmail);
				if (memVO == null) {
					errorMsgs.add("��o��̖���ܴa,Ո���µ���");
				}
				MemberVO memVO2 = memSvc.getMemberByMemPw(memPw);
				if (memVO2 == null) {
					errorMsgs.clear();
					errorMsgs.add("��ݔ����ܴa���`,Ո�_�J");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/login.jsp");
					failureView.forward(req, res);
					return;//��ʽ�Д�
				}
				
				/***************************3.��ԃ���,�ʂ��D��(Send the Success view)*************/
				req.setAttribute("memVO", memVO); // �Y�ώ�ȡ����empVO���,����req
				String url = "/member/memHome.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ɹ��D�� listOneEmp.jsp
				successView.forward(req, res);

				/***************************�������ܵ��e�`̎��*************************************/
			} catch (Exception e) {
				errorMsgs.add("�o��ȡ���Y��:" + e.getMessage());
				req.setAttribute("errorMsgs", errorMsgs);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/login.jsp");
				failureView.forward(req, res);
			}
		}else{
			RequestDispatcher failureView = req
					.getRequestDispatcher("/member/login.jsp");
			failureView.forward(req, res);
		}
		
	}

}
