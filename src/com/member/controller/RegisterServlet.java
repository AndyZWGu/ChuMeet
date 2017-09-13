package com.member.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.member.model.MemberService;
import com.member.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		if ("register".equals(action)) { // 來自login.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String memEmail = req.getParameter("memEmail");
				String memPw = req.getParameter("memPw");
				String memName = req.getParameter("memName");
				Integer memPhone = Integer.parseInt(req.getParameter("memPhone"));
				String memLocBorn = req.getParameter("memLocBorn");
				String memLocLive = req.getParameter("memLocLive");
				String memBD = req.getParameter("memBD");
				Integer memGender = Integer.parseInt(req.getParameter("memGender"));
				String memInt = req.getParameter("memInt");

				if (memEmail == null || (memEmail.trim()).length() == 0) {
					errorMsgs.add("請輸入會員帳號");
				}
				if (memPw == null || (memPw.trim()).length() == 0) {
					errorMsgs.add("請輸入會員密碼");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("register.jsp");
					failureView.forward(req, res);
					return;
				}
				
				String formatMemEmail = null;
				String formatMemPw = null;
				try {
					formatMemEmail = new String();
					formatMemPw = new String();
				} catch (Exception e) {
					errorMsgs.add("輸入格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("register.jsp");
					failureView.forward(req, res);
					return;//
				}
				
				/***************************2.開始查詢資料*****************************************/
				MemberService memSvc = new MemberService();
				MemberVO memVO = memSvc.getMemberByMemEmail(memEmail);
				if (memVO != null) {
					errorMsgs.add("帳號已被使用,請重新輸入新的帳號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("register.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				//測試用
//				req.setAttribute("memVO", memVO); 
//				String url = "/member/memHome.jsp"; 
//				RequestDispatcher successView = req.getRequestDispatcher(url); 
//				successView.forward(req, res);
				//正式註冊一筆新資料
				//時間用
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Date date = new Date();
				java.sql.Date nowDate = (java.sql.Date) date;
				java.sql.Date memBDDate = (java.sql.Date)dateFormat.parse(memBD);
				System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43 (確切是抓當前時間)
				//大頭照用
				//Servlet3.0新增part介面方面檔案上傳
				byte[] memAvatar = null;
				Collection<Part> filePart = req.getParts();
				System.out.println("FilePart's Size="+filePart.size());
				for(Part part:filePart){
					if(getFileNameFromPart(part)!=null&&part.getContentType()!=null){
						//寫入功能
						String fileName=getFileNameFromPart(part);//創出的名字
						//額外測試 InputStream 與 byte[] (幫將來model的VO預作準備)
						InputStream in = part.getInputStream();//位元組串流
						memAvatar = new byte[in.available()];//長度
						in.read(memAvatar);//串流寫入byte[]
						in.close();
					}
				}
				//註冊呼叫Service調用Dao
				memSvc.addMember( 
						memEmail, 
						memPw, 
						0, 
						1,
						0, 
						50, 
						memName, 
						memGender, 
						memBDDate, 
						memPhone, 
						memAvatar, 
						nowDate, 
						1, 
						memLocBorn, 
						memLocLive, 
						memInt, 
						2, 
						1);
				res.sendRedirect("../index.jsp");

				/***************************其他可能的錯誤處理*************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				req.setAttribute("errorMsgs", errorMsgs);
				RequestDispatcher failureView = req
						.getRequestDispatcher("login.jsp");
				failureView.forward(req, res);
			}
		}else{
			RequestDispatcher failureView = req
					.getRequestDispatcher("front-end/member/login.jsp");
			failureView.forward(req, res);
		}
		
	}
	
	// 取出上傳的檔案名稱 (因為API未提供method,所以必須自行撰寫)
	public String getFileNameFromPart(Part part) {
		String header = part.getHeader("content-disposition");
		System.out.println("header=" + header); // 測試用
		String filename = new File(header.substring(header.lastIndexOf("=") + 2, header.length() - 1)).getName();
		System.out.println("filename=" + filename); // 測試用
		if (filename.length() == 0) {
			return null;
		}
		return filename;
	}

}
