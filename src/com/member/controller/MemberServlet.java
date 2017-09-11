package com.member.controller;

import java.io.*;
import java.sql.Date;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.member.model.*;

public class MemberServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // �Ӧ�select_page.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				String str = req.getParameter("memID");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("�п�J�|���s��");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				Integer memID = null;
				try {
					memID = new Integer(str);
				} catch (Exception e) {
					errorMsgs.add("���u�s���榡�����T");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************2.�}�l�d�߸��*****************************************/
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.getOneMember(memID);
				if (memberVO == null) {
					errorMsgs.add("�d�L���");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/select_page.jsp");
					failureView.forward(req, res);
					return;//�{�����_
				}
				
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // ��Ʈw���X��memberVO����,�s�Jreq
				String url = "/member/listOneMember.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // ���\��� listOnemember.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/select_page.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("getOne_For_Update".equals(action)) { // �Ӧ�listAllmember.jsp���ШD

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.�����ШD�Ѽ�****************************************/
				Integer memID = new Integer(req.getParameter("memID"));
				
				/***************************2.�}�l�d�߸��****************************************/
				MemberService memberSvc = new MemberService();
				MemberVO memberVO = memberSvc.getOneMember(memID);
								
				/***************************3.�d�ߧ���,�ǳ����(Send the Success view)************/
				req.setAttribute("memberVO", memberVO);         // ��Ʈw���X��memberVO����,�s�Jreq
				String url = "/member/update_member_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// ���\��� update_member_input.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�L�k���o�n�ק諸���:" + e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/listAllmember.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("update".equals(action)) { // �Ӧ�update_member_input.jsp���ШD
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
			try {
				/***************************1.�����ШD�Ѽ� - ��J�榡�����~�B�z**********************/
				Integer memID = new Integer(req.getParameter("memID").trim());
				String memEmail = req.getParameter("memEmail").trim();
				String memEPw = req.getParameter("memPw").trim();
				String mem = req.getParameter("memEmail").trim();
				Integer memEVerType = new Integer(req.getParameter("memVerType").trim());
				Integer memLv = new Integer(req.getParameter("memLv").trim());
				Integer memExp = new Integer(req.getParameter("memLv").trim());
				Integer memPt = new Integer(req.getParameter("memPt").trim());
				String memName = req.getParameter("memEmail").trim();
				String memEGender = req.getParameter("memEmail").trim();
				String memBd = req.getParameter("memEmail").trim();
				String memPhone = req.getParameter("memEmail").trim();
				String memAvatar = req.getParameter("memEmail").trim();
				String memJoinDate = req.getParameter("memEmail").trim();
				String memLoginDate = req.getParameter("memEmail").trim();
				String memLoginNum = req.getParameter("memEmail").trim();
				String memLocBOrn = req.getParameter("memEmail").trim();
				String memLocLive = req.getParameter("memEmail").trim();
				String memInt = req.getParameter("memEmail").trim();
				String memPriv = req.getParameter("memEmail").trim();
				String memStatus = req.getParameter("memEmail").trim();
				
				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}

				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("�~���ж�Ʀr.");
				}

				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("�����ж�Ʀr.");
				}

				Integer deptno = new Integer(req.getParameter("deptno").trim());

				MemberVO memberVO = new MemberVO();
//				memberVO.setmemID(memID);
//				memberVO.setEname(ename);
//				memberVO.setJob(job);
//				memberVO.setHiredate(hiredate);
//				memberVO.setSal(sal);
//				memberVO.setComm(comm);
//				memberVO.setDeptno(deptno);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO); // �t����J�榡���~��memberVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/update_member_input.jsp");
					failureView.forward(req, res);
					return; //�{�����_
				}
				
				/***************************2.�}�l�ק���*****************************************/
				MemberService memberSvc = new MemberService();
//				memberVO = memberSvc.updateMember(memID,memEmail,memberPw,memVerType,memLv,memExp,mmembert,memName,memGender,memBD,mmemberhone,memAvatar,memJoinDate,memLoginNum,memLocBorn,memLocLive,memInt,mmemberriv,memStatus);
				
				/***************************3.�ק粒��,�ǳ����(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // ��Ʈwupdate���\��,���T����memberVO����,�s�Jreq
				String url = "/member/listOnemember.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �ק令�\��,���listOnemember.jsp
				successView.forward(req, res);

				/***************************��L�i�઺���~�B�z*************************************/
			} catch (Exception e) {
				errorMsgs.add("�ק��ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/update_member_input.jsp");
				failureView.forward(req, res);
			}
		}

        if ("insert".equals(action)) { // �Ӧ�addmember.jsp���ШD  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/***********************1.�����ШD�Ѽ� - ��J�榡�����~�B�z*************************/
				String ename = req.getParameter("ename").trim();
				String job = req.getParameter("job").trim();
				
				java.sql.Date hiredate = null;
				try {
					hiredate = java.sql.Date.valueOf(req.getParameter("hiredate").trim());
				} catch (IllegalArgumentException e) {
					hiredate=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("�п�J���!");
				}
				
				Double sal = null;
				try {
					sal = new Double(req.getParameter("sal").trim());
				} catch (NumberFormatException e) {
					sal = 0.0;
					errorMsgs.add("�~���ж�Ʀr.");
				}
				
				Double comm = null;
				try {
					comm = new Double(req.getParameter("comm").trim());
				} catch (NumberFormatException e) {
					comm = 0.0;
					errorMsgs.add("�����ж�Ʀr.");
				}
				
				Integer deptno = new Integer(req.getParameter("deptno").trim());

				MemberVO memberVO = new MemberVO();
//				memberVO.setEname(ename);
//				memberVO.setJob(job);
//				memberVO.setHiredate(hiredate);
//				memberVO.setSal(sal);
//				memberVO.setComm(comm);
//				memberVO.setDeptno(deptno);

				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					req.setAttribute("memberVO", memberVO); // �t����J�榡���~��memberVO����,�]�s�Jreq
					RequestDispatcher failureView = req
							.getRequestDispatcher("/member/addmember.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.�}�l�s�W���***************************************/
				MemberService memberSvc = new MemberService();
//				memberVO = memberSvc.addMember(memID,memEmail,mmemberw,memVerType,memLv,memExp,mmembert,memName,memGender,memBD,mmemberhone,memAvatar,memJoinDate,memLoginNum,memLocBorn,memLocLive,memInt,mmemberriv,memStatus);
				
				/***************************3.�s�W����,�ǳ����(Send the Success view)***********/
				String url = "/member/listAllmember.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // �s�W���\�����listAllmember.jsp
				successView.forward(req, res);				
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add(e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/addmember.jsp");
				failureView.forward(req, res);
			}
		}
		
		
		if ("delete".equals(action)) { // �Ӧ�listAllmember.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
			try {
				/***************************1.�����ШD�Ѽ�***************************************/
				Integer memID = new Integer(req.getParameter("memID"));
				
				/***************************2.�}�l�R�����***************************************/
				MemberService memberSvc = new MemberService();
				memberSvc.deleteMember(memID);
				
				/***************************3.�R������,�ǳ����(Send the Success view)***********/								
				String url = "/member/listAllmember.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// �R�����\��,���^�e�X�R�����ӷ�����
				successView.forward(req, res);
				
				/***************************��L�i�઺���~�B�z**********************************/
			} catch (Exception e) {
				errorMsgs.add("�R����ƥ���:"+e.getMessage());
				RequestDispatcher failureView = req
						.getRequestDispatcher("/member/listAllmember.jsp");
				failureView.forward(req, res);
			}
		}
	}
}
