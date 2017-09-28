<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.member.model.*"%>
<%@ page import="java.util.*"%>
<%
MemberVO memVO = (MemberVO) session.getAttribute("memVO");

String achName = (String)session.getAttribute("achName");
Integer followNum = (Integer)session.getAttribute("followNum");
Integer friNum = (Integer)session.getAttribute("friNum");
Integer memStar = (Integer)session.getAttribute("memStar");

String isMail = (String)session.getAttribute("isMail");
String isPhone = (String)session.getAttribute("isPhone");
String memMBNum = (String)session.getAttribute("memMBNum");

%>
                <div class="col-md-3 wow fadeInLeft" data-wow-delay=".05s" data-wow-duration=".1">
                    <div class="profile-sidebar">
                        <!-- SIDEBAR USERPIC -->
                        <div class="profile-userpic">
                        	<div class="user-avatar"> 
                        		<img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" class="" alt="">
                        	</div> 
                        </div>
                        <!-- END SIDEBAR USERPIC -->
                        <!-- SIDEBAR USER TITLE -->
                        <div class="profile-usertitle">
                            <div class="profile-usertitle-name"> ${memVO.memName} </div>
                            <div class="profile-usertitle-level"> ${achName} </div>
                        </div>
                        <div class="row overvie">
                            <div class="col-md-4 user-pad text-center glyphicon glyphicon-star-empty">
                                <h5>跟隨</h5>
                                <h4>${followNum}</h4>
                            </div>
                            <div class="col-md-4 user-pad text-center glyphicon glyphicon-user">
                                <h5>好友數</h5>
                                <h4>${friNum}</h4>
                            </div>
                            <div class="col-md-4 user-pad text-center glyphicon glyphicon-thumbs-up">
                                <h5>評分數</h5>
                                <h4>${memStar}</h4>
                            </div>
                        </div>
                        <!-- END SIDEBAR USER TITLE -->
                        <!-- SIDEBAR MENU -->
                        <div class="profile-usermenu">
                            <div class="row text-center pt">
                                <hr> 持有Pt點數:
                                <p>${memVO.memPt}</p>
                                <hr>
                            </div>
                            <ul class="nav">
                                <li class="active">
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberHome.do?memID=${memVO.memID}"> <i class="fa fa-home" aria-hidden="true"></i> 首頁 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberCalendar.do?memID=${memVO.memID}"> <i class="fa fa-calendar" aria-hidden="true"></i> 行事曆 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberMail.do?memID=${memVO.memID}"> <i class="fa fa-envelope-o" aria-hidden="true"></i> 收件夾 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberNF.do?memID=${memVO.memID}"> <i class="fa fa-comments-o" aria-hidden="true"></i> 我的動態 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberCommunity.do?memID=${memVO.memID}"> <i class="fa fa-users" aria-hidden="true"></i> 社群管理 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberLv.do?memID=${memVO.memID}"> <i class="fa fa-level-up" aria-hidden="true"></i> 等級/積分 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberAch.do?memID=${memVO.memID}"> <i class="fa fa-trophy" aria-hidden="true"></i> 成就 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberReward.do?memID=${memVO.memID}"> <i class="fa fa-gift" aria-hidden="true"></i> 獎賞 </a>
                                </li>
                                <li> <a href="<%=request.getContextPath()%>/front-end/member/memberStar.do?memID=${memVO.memID}"><i class="fa fa-thumbs-o-up" aria-hidden="true"></i> 評價 </a> </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberInfo.do?memID=${memVO.memID}"> <i class="fa fa-pencil-square-o" aria-hidden="true"></i> 基本資訊 </a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/front-end/member/memberSetting.do?memID=${memVO.memID}"> <i class="fa fa-cog" aria-hidden="true"></i>個人頁面設定 </a>
                                </li>
                            </ul>
                            <div class="row text-center">
                            <hr>
                            	<h4>個人紀錄</h4>                            
                            	<p>上站次數：<strong>${memVO.memLoginNum}</strong></p>
                            	<p>郵箱認證：<strong>${isMail}</strong></p>
                            	<p>手機認證：<strong>${isPhone}</strong></p>
                            	<p>留言篇數：<strong>${memMBNum}</strong></p>
                            	<p>註冊加入日期：<strong>${memJoinDate}</strong></p>
                            </div>
                        </div>
                        <!-- END MENU -->
                    </div>
                </div>