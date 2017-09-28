package com.member.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.model.*;

/**
 * Servlet implementation class LoginServlet
 */
public class GuestHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestHomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer memID = Integer.parseInt(req.getParameter("memID"));
//		System.out.println(memID);
		HttpSession session = req.getSession();
		if (session.getAttribute("guestVO") != null) {
			session.removeAttribute("guestVO");
		}
		MemberService memSvc = new MemberService();
		MemberVO guestVO = (MemberVO)memSvc.getOneMember(memID);
		session.setAttribute("guestVO", guestVO);
		
		MemNFVO memNFVO = (MemNFVO) session.getAttribute("memNFVO");
		AchVO achVO = (AchVO) session.getAttribute("achVO");
		MemAchVO memAchVO = (MemAchVO) session.getAttribute("memAchVO");
		// ActStarVO actStar = (ActStarVO) session.getAttribute("actStarVO");
		MemMailVO memMailVO = (MemMailVO) session.getAttribute("memMailVO");
		RewardVO rewardVO = (RewardVO) session.getAttribute("rewardVO");
		MemRewardVO memRewardVO = (MemRewardVO) session.getAttribute("memRewardVO");
		
		MemPOIVO memPOIVO = (MemPOIVO) session.getAttribute("memPOIVO");
		session.setAttribute("memNFVO", memNFVO);
		session.setAttribute("achVO", achVO);
		session.setAttribute("memAchVO", memAchVO);
		session.setAttribute("memMailVO", memMailVO);
		session.setAttribute("rewardVO", rewardVO);
		session.setAttribute("memRewardVO", memRewardVO);
		
		session.setAttribute("memPOIVO", memPOIVO);
		
		
		String url = "/front-end/member/guestHome.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		//複合查詢

		// 拿照片
		// base64用
		// List<String> list = new ArrayList<String>();
		// List<byte[]> list = new ArrayList<byte[]>();
		// MemberService memSvc = new MemberService();
		// list = memSvc.getAvatar(memVO.getMemID());
		// req.setAttribute("pictureList", list);
		// 基本作法
		//放在另外一隻透過doGet加參數獲取圖片

		
		
		// req.setCharacterEncoding("UTF-8");
		// String action = req.getParameter("action");
		// String action = "login";

		// if ("login".equals(action)) { // 來自login.jsp的請求
		//
		// List<String> errorMsgs = new LinkedList<String>();
		// // Store this set in the request scope, in case we need to
		// // send the ErrorPage view.
		// req.setAttribute("errorMsgs", errorMsgs);
		//
		// try {
		// /***************************1.接收請求參數 -
		// 輸入格式的錯誤處理**********************/
		// String memEmail = req.getParameter("memEmail");
		// String memPw = req.getParameter("memPw");
		//// String memEmail = "adm@gmail";
		//// String memPw = "Master";
		// if (memEmail == null || (memEmail.trim()).length() == 0) {
		// errorMsgs.add("請輸入會員帳號");
		// }
		// if (memPw == null || (memPw.trim()).length() == 0) {
		// errorMsgs.add("請輸入會員密碼");
		// }
		// // Send the use back to the form, if there were errors
		// if (!errorMsgs.isEmpty()) {
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/member/login.jsp");
		// failureView.forward(req, res);
		// return;//程式中斷
		// }
		//
		// String formatMemEmail = null;
		// String formatMemPw = null;
		// try {
		// formatMemEmail = new String();
		// formatMemPw = new String();
		// } catch (Exception e) {
		// errorMsgs.add("輸入格式不正確");
		// }
		// // Send the use back to the form, if there were errors
		// if (!errorMsgs.isEmpty()) {
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/emp/select_page2.jsp");
		// failureView.forward(req, res);
		// return;//程式中斷
		// }
		//
		// /***************************2.開始查詢資料*****************************************/
		// MemberService memSvc = new MemberService();
		// MemberVO memVO = memSvc.getMemberByMemEmail(memEmail);
		// if (memVO == null) {
		// errorMsgs.add("查無帳號或密碼,請重新登入");
		// }
		// MemberVO memVO2 = memSvc.getMemberByMemPw(memPw);
		// if (memVO2 == null) {
		// errorMsgs.clear();
		// errorMsgs.add("您輸入的密碼有誤,請確認");
		// }
		// // Send the use back to the form, if there were errors
		// if (!errorMsgs.isEmpty()) {
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/member/login.jsp");
		// failureView.forward(req, res);
		// return;//程式中斷
		// }
		//
		// /***************************3.查詢完成,準備轉交(Send the Success
		// view)*************/
		// req.setAttribute("memVO", memVO); // 資料庫取出的empVO物件,存入req
		// String url = "/member/memHome.jsp";
		// RequestDispatcher successView = req.getRequestDispatcher(url); //
		// 成功轉交 listOneEmp.jsp
		// successView.forward(req, res);
		//
		// /***************************其他可能的錯誤處理*************************************/
		// } catch (Exception e) {
		// errorMsgs.add("無法取得資料:" + e.getMessage());
		// req.setAttribute("errorMsgs", errorMsgs);
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/member/login.jsp");
		// failureView.forward(req, res);
		// }
		// }else{
		// RequestDispatcher failureView = req
		// .getRequestDispatcher("/member/login.jsp");
		// failureView.forward(req, res);
		// }

		/**************************************************************
		 * *******************我的動態*******************************
		 *************************************************************/
		// if ("memNF".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************我的等級積分*******************************
		 *************************************************************/
		// if ("memLevel".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************我的基本資訊*******************************
		 *************************************************************/
		// if ("memInfo".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************我的成就*******************************
		 *************************************************************/
		// if ("memAch".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************我的評價*******************************
		 *************************************************************/
		// if ("memOpinion".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************我的個人頁面設定*******************************
		 *************************************************************/
		// if ("memSeeting".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************會員動態*******************************
		 *************************************************************/
		// if ("memLevel".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		/**************************************************************
		 * *******************會員動態*******************************
		 *************************************************************/
		// if ("memLevel".equals(action)) { // 來自memHome.jsp的請求
		//
		// }
		// doPost
	}

}
