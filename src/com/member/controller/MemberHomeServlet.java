package com.member.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
public class MemberHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int friendsNum=0;
	int followNum=0;
	int memMBNum=0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberHomeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session.getAttribute("memVO") == null) {
			res.sendRedirect("ChuMeetWebsite/front-end/index.jsp");
		}
		
		/**************************************************************
		 ********************左邊Sidebar使用****************************
		 *************************************************************/
		MemberVO memVO = (MemberVO) session.getAttribute("memVO");
		System.out.println("當前會員編號"+memVO.getMemID()+"此程式在MemberHomeServlet.java");
		//好友列表,好友數,跟隨數,平價數...
		FriendsService friSvc = new FriendsService();
		 List<FriendsVO> friendsList = friSvc.getAllFriends(memVO.getMemID());
		 friendsNum=0;
		 followNum=0;
		  for (FriendsVO list : friendsList) {
			  if(list.getFriendType().contains("好友")){
				  friendsNum++;
				  followNum++;
			  }
//			  System.out.println("編號"+memVO.getMemID()+"的好友"+list.getFriendType());
		  }
		//會員名稱,稱號,跟隨,好友數,評分數,揪點,驗證,註冊時間
//		session.setAttribute("achName", achName);
		session.setAttribute("followNum", followNum);
		session.setAttribute("friNum", friendsNum);
//		session.setAttribute("memStar", memStar);
		if(memVO.getMemberType()==0){
			session.setAttribute("isMail", "未驗證");
			session.setAttribute("isPhone", "未驗證");
		}
		else if (memVO.getMemberType()==1){
			session.setAttribute("isMail", "驗證");
			session.setAttribute("isPhone", "未驗證");
		}
		else if (memVO.getMemberType()==2){
			session.setAttribute("isMail", "驗證");
			session.setAttribute("isPhone", "驗證");
		}
		MemMBService mbSvc = new MemMBService();
		String count = mbSvc.getCountByMemID(memVO.getMemID());
		session.setAttribute("memMBNum", count);
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		String[] memVOID = new String[2];
//		memVOID[0]=memVO.getMemID().toString();
//		map.put("memID",memVOID);
//		List<MemMBVO> memMBlist = mbSvc.getAllMB(map);
//		  for (MemMBVO list : memMBlist) {
//			  memMBNum++;
//			  System.out.println("留言數"+memMBNum+"為"+list.getMbContent());
//			  System.out.println(memMBlist.size());
//			  System.out.println(list.getMemMBID());
//		  }
//		session.setAttribute("memMBNum", memMBNum);
		session.setAttribute("memJoinDate", timestampToString(memVO.getMemJoinDate()).toString());
		/**************************************************************
		 ********************右邊Content使用****************************
		 *************************************************************/
		//找首頁動態
		MemNFService nfSvc = new MemNFService();
		Map<String, String[]> nfMap = new HashMap<String, String[]>();
		String[] NFMemID = new String[2];
		String[] nfStatus = new String[2];
		NFMemID[0]=memVO.getMemID().toString();
		nfStatus[0]="2";
		nfMap.put("memID",NFMemID);
		nfMap.put("nfStatus",nfStatus);
		List<MemNFVO> memNFList = nfSvc.getAllNF(nfMap);
		Integer memNFID = null;
				  for (MemNFVO list : memNFList) {
					  memNFID = list.getMemNFID();
			  }
		session.setAttribute("memHomeNFID", memNFID);
		System.out.println(session.getAttribute("memHomeNFID"));
		//找首頁動態下方的留言
		Map<String, String[]> mbMap = new HashMap<String, String[]>();
		String[] memNFIDs = new String[2];
		memNFIDs[0]= String.valueOf(memNFID);
		mbMap.put("memNFID",memNFIDs);
		List<MemMBVO> memMBList = mbSvc.getAllMB(mbMap);
		session.setAttribute("memMBList", memMBList);
		//找首頁動態下方留言者的姓名
		List<MemberVO> mbMemNameList = new ArrayList<MemberVO>();
		MemberService memSvc = new MemberService();
		for(MemMBVO list : memMBList){
			mbMemNameList.add(memSvc.getOneMember(list.getMemID()));
			System.out.println(list.getMemID());
		}
		session.setAttribute("mbMemNameList", mbMemNameList);
		/*******************轉址用****************************/
		String url = "/front-end/member/memberHome.jsp";
		RequestDispatcher successView = req.getRequestDispatcher(url);
		successView.forward(req, res);
		/****************************************************/
		
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
	
	
	
	/*******************額外工具****************************/
	//Timestamp轉String
	  public static String timestampToString(Timestamp timestamp){		  
		  if(timestamp==null){
			  return "null";
		  }else{
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//定义格式，不显示毫秒 
				 // Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间 
				  String str = df.format(timestamp); 
				  System.out.println(str); 
			        return str;
		  }
	  }


}
