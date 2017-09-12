package com.member.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.MemberService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
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
		
		if ("logout".equals(action)) { // ����login.jsp��Ո��

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.����Ո�󅢔� - ݔ���ʽ���e�`̎��**********************/
				/***************************2.�_ʼ��ԃ�Y��*****************************************/
				/***************************3.��ԃ���,�ʂ��D��(Send the Success view)*************/
				HttpSession session = req.getSession();
				session.removeAttribute("memVO");
				res.sendRedirect("../index.jsp");

				/***************************�������ܵ��e�`̎��*************************************/
			} catch (Exception e) {
				errorMsgs.add("�o��ȡ���Y��:" + e.getMessage());
				req.setAttribute("errorMsgs", errorMsgs);
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/error.jsp");
				failureView.forward(req, res);
			}
		}
		
	}

}
