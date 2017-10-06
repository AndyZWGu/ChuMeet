<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.member.model.*"%>
<%
	MemberVO guestVO = (MemberVO) session.getAttribute("guestVO");
	MemNFVO guestNFVO = (MemNFVO) session.getAttribute("guestNFVO");
%>
<html>

<!-- Head BEGIN -->
<!-- 共用Header -->
<c:import url="/front-end/head.jsp">
</c:import>
<!-- 共用Header -->
<!--  my styles  -->
<!--@@@@@@@@@@@@@@@@@@@@@@@@@@ 自己的CSS用連結寫到這邊 @@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!! 放在最後一行優先權越高 !!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<!--#################### 單頁CSS路徑統一放在/src/xxx/css/xxx.css ###########-->
<!--%%%%%%%%%%%%%%%%%% 第一行可以刪掉，那是activity(也就是敏道的活動頁)專用的CSS %%%%%-->
<link href="<%=request.getContextPath()%>/HTML/src/act/css/act.csss"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/HTML/src/member/css/guestMemHome.css"
	rel="stylesheet">

</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="chumeet">
	<c:import url="/front-end/userHeader.jsp">
	</c:import>

	<!-- Header Start -->
	<c:import url="/front-end/header.jsp">
	</c:import>

	<!-- Header END -->

	<!--主頁面要修改的都在這下面-->
	<div class="main">
		<div class="container">
			<div class="row profile">
				<div class="col-md-3 wow fadeInLeft" data-wow-delay=".05s"
					data-wow-duration=".1">
					<div class="profile-sidebar">
						<!-- SIDEBAR USERPIC -->
						<%-- base64 寫法 
          	<c:forEach items="${pictureList}" var="picture">
            	<div class="profile-userpic"> <img src="data:image/jpg;base64,${picture}" class="" alt=""> </div>
            </c:forEach>
            --%>
						<div class="profile-userpic">
							<img
								src="<%=request.getContextPath()%>/front-end/member/guestHome/avatar.do?memID=${guestVO.memID}"
								class="avatar" alt="">
						</div>
						<!-- END SIDEBAR USERPIC -->
						<!-- SIDEBAR USER TITLE -->
						<div class="profile-usertitle">
							<div class="profile-usertitle-name">${guestVO.memName}</div>
							<div class="profile-usertitle-level">剛加入的初心者</div>
						</div>
						<div class="row overvie">
							<div
								class="col-md-4 user-pad text-center glyphicon glyphicon-star-empty">
								<h5>跟隨</h5>
								<h4>9,527</h4>
							</div>
							<div
								class="col-md-4 user-pad text-center glyphicon glyphicon-user">
								<h5>好友數</h5>
								<h4>486</h4>
							</div>
							<div
								class="col-md-4 user-pad text-center glyphicon glyphicon-thumbs-up">
								<h5>評分數</h5>
								<h4>6,666</h4>
							</div>
						</div>
						<!-- END SIDEBAR USER TITLE -->
						<!-- SIDEBAR MENU -->
						<!--**************************隱私權判斷範圍(不開)**************************-->
						<c:if test="${account == null}">
							<div class="profile-usermenu text-center">
								<hr>
								<h4>您未登入會員</h4>
								<br>
								<h5>加入會員即可使用會員專屬互動功能</h5>
							</div>
						</c:if>
						<!--**************************隱私權判斷範圍(不開)**************************-->
						<c:if test="${account != null}">
						<div class="profile-usermenu">
							<div class="profile-userbuttons">
								<button type="button" class="btn btn-warning btn-sm">追隨</button>
								<button type="button" class="btn btn-success btn-sm">好友邀請</button>
								<button type="button" class="btn btn-info btn-sm">站內信</button>
								<br>
								<hr>
								<button type="button" class="btn btn-danger btn-sm">設為黑名單</button>
								<button type="button" class="btn btn-danger btn-sm">檢舉</button>
							</div>
						</div>
						</c:if>
						<!-- END MENU -->
					</div>
				</div>
				<!--**************************隱私權判斷範圍(不開)**************************-->
				<c:if test="${guestVO.memPriv==0 || guestVO.memPriv==1&&guestPriv==0}">
					<div class="col-md-9 wow fadeInRight" data-wow-delay=".05s"
						data-wow-duration=".1">
						<div class="row profile-content blog-item text-center">
							<h1>不公開的會員頁面</h1>
							<hr>
							<h4>您沒有該名會員好友,或是該會員已將頁面設為不公開！</h4>
						</div>
					</div>
				</c:if>
				<!--**************************隱私權判斷範圍(開或是好友)**************************-->
				<c:if test="${guestVO.memPriv==2 || guestVO.memPriv==1&&guestPriv==1}">
				<div class="col-md-9 wow fadeInRight" data-wow-delay=".05s"
					data-wow-duration=".1">
					<!--  statitics -->

					<!-- /.row -->
					<!--  statitics -->

					<div class="row profile-content blog-item">
						<h2>關於我</h2>
						<div class="introduction">${guestVO.memInt}</div>
						<hr class="colorgraph">
												<!--********************首頁********************-->
						<!-- BEGIN CONTENT -->
						<div class="col-md-12 col-sm-12">
							                                <ul class="nav nav-tabs">
                                    <li class="active"><a data-toggle="tab" href="#home">參加中的活動</a></li>
                                    <li><a data-toggle="tab" href="#act">參加的社團</a></li>
                                    <li><a data-toggle="tab" href="#club">追蹤</a></li>
                                </ul>

                                <div class="tab-content">
                                    <div id="act" class="tab-pane fade in active">
                                        <div class="container-fluid bg-3 text-center reward">
                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" alt="Image" class="img-responsive thumbnail">
                                                    <p>Lorem ipsum..</p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" alt="Image" class="img-responsive thumbnail">
                                                    <p>Lorem ipsum..</p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" alt="Image" class="img-responsive thumbnail">
                                                    <p>Lorem ipsum..</p>
                                                </div>
                                                <div class="row">
                                                	<a href="http://www.google.com"><input type="button" class="btn btn-primary" value="看更多"></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="club" class="tab-pane fade">
                                        <div class="container-fluid bg-3 text-center reward">
                                            <div class="row">
                                                <div class="col-sm-4">
                                                    <img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" alt="Image" class="img-responsive thumbnail">
                                                    <p>Lorem ipsum..</p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" alt="Image" class="img-responsive thumbnail">
                                                    <p>Lorem ipsum..</p>
                                                </div>
                                                <div class="col-sm-4">
                                                    <img src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}" alt="Image" class="img-responsive thumbnail">
                                                    <p>Lorem ipsum..</p>
                                                </div>
                                                <div class="row">
                                                	<a href="http://www.google.com"><input type="button" class="btn btn-primary" value="看更多"></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <hr class="colorgraph">
						</div>
						<!-- END CONTENT -->
						<!--********************首頁********************-->
						<hr class="colorgraph">
						<!--**************************留言板**************************-->
						<h2>留言板</h2>
						<div class="comments wow fadeInRight" data-wow-delay=".05s"
							data-wow-duration=".1">
							<div class="media">
								<a href="javascript:;" class="pull-left"> <img
									src="../src/member/img/avatar/default-avatar.png" alt=""
									class="media-object">
									<p>喵星人</p>
								</a>
								<div class="media-body">
									<h4 class="media-heading">
										歡迎留言<span>5天前 / <input type="button" value="回復"
											class="btn btn-success btn-sm"></span>
									</h4>
									<p>想回或想說甚麼都歡迎囉~</p>
									<!-- Nested media object -->
									<div class="media">
										<a href="javascript:;" class="pull-left"> <img
											src="../src/member/img/dog-wtf.jpg" alt=""
											class="media-object">
											<p>狗本大隊長</p>
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												ㄟㄟ <span>三小時前 / </span>
											</h4>
											<p>邀請你了!記得我好友喔~</p>
											<div class="col-sm-12 text-right">
												<input type="button" value="檢舉"
													class="btn btn-danger btn-xs">
											</div>
										</div>
									</div>
									<!--end media-->
									<div class="media">
										<a href="javascript:;" class="pull-left"> <img
											src="../src/member/img/god.jpg" alt="" class="media-object">
											<p>鸚鵡兄弟</p>
										</a>
										<div class="media-body">
											<h4 class="media-heading">
												跟你說 <span>一小時前o / </span>
											</h4>
											<p>鸚鵡seafood最厲害!讚!</p>
											<div class="col-sm-12 text-right">
												<input type="button" value="檢舉"
													class="btn btn-danger btn-xs">
											</div>
										</div>
									</div>
									<!--end media-->
								</div>
							</div>
							<!--end media-->
							<div class="media">
								<a href="javascript:;" class="pull-left"> <img
									src="../src/member/img/dog-wtf.jpg" alt="" class="media-object">
									<p>狗本大隊長</p>
								</a>
								<div class="media-body">
									<h4 class="media-heading">
										安安 <span>July 25,2017 / <input type="button" value="回復"
											class="btn btn-success btn-sm"></span>
									</h4>
									<p>路過到此一遊</p>
									<div class="col-sm-12 text-right">
										<input type="button" value="檢舉" class="btn btn-danger btn-xs">
									</div>
								</div>
							</div>
							<!--end media-->
						</div>
						<!--**************************留言版喔喔**************************-->
					</div>
				</div>
				</c:if>
				<!--**************************隱私權判斷範圍**************************-->
			</div>
		</div>
		<br> <br>
	</div>
	<!--主頁面要修改的都在這上面-->

	<!-- BEGIN FOOTER -->
	<c:import url="/front-end/footer.jsp">
	</c:import>
	<!-- END FOOTER -->

	<!-- 共用Js -->
	<c:import url="/front-end/publicJS.jsp">
	</c:import>
	<!-- 共用Js -->

</body>
<!-- END BODY -->

</html>