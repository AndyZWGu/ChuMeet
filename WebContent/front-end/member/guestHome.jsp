<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.member.model.*"%>
<%
	MemberVO guestVO = (MemberVO) session.getAttribute("guestVO");
	String account = (String)session.getAttribute("account");
	Integer guestPriv = (Integer)session.getAttribute("guestPriv");
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
	href="<%=request.getContextPath()%>/HTML/src/member/css/memHome.css"
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
						<h1>本頁面不公開</h1>
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
						<!--********************活動********************-->
						<h2>活動足跡</h2>
						<!-- BEGIN SIDEBAR & CONTENT -->
						<!-- BEGIN CONTENT -->
						<div class="col-md-12 col-sm-12">
							<div class="content-page">
								<div class="row">

									<!--      1st card          -->
									<div class="ec wow fadeInLeft" data-wow-delay=".05s"
										data-wow-duration=".1">
										<div class="row">
											<div class="col-md-4 col-sm-4">
												<a href="actItem.html"><img alt="Person Of Interest"
													class="img-responsive img-rounded"
													src="../src/act/img/eventSamples/POI.jpg"></a>
											</div>

											<div class="col-md-8 col-sm-8">
												<h2>
													<a href="actItem.html">一起看Person Of Interest</a>
												</h2>
												<ul class="event-info">
													<li><i class="fa fa-calendar"></i> 2017/7/30起
														每周五晚上8:00-9:00</li>
													<li><i class="fa fa-map-marker"></i><a href="#">線上</a></li>
													<li><i class="fa fa-users"></i>222</li>
													<li><i class="fa fa-user"></i><a href="#">breadcan</a></li>

												</ul>
												<div class="ecContent">
													<p>《疑犯追蹤》（Person of
														Interest），是美國CBS電視台製作的犯罪電視影集，由強納森·諾蘭（Jonathan
														Nolan）與J·J·亞柏拉罕（J. J.
														Abrams）共同打造出劇情架構，全五季共103集。哈洛·芬奇為政府開發了一套稱作「機器」（The
														Machine），可偵測恐怖攻擊的大規模監控電腦系統。它可預測「有計畫或謀略策劃的犯罪」，諸如911事件之類的大型恐怖攻擊災難，並提供情報讓有關當局防範未然。</p>
												</div>
												<div class="row">
													<span class="col-sm-4"> <a class="more"
														href="actItem.html">詳細資訊 <i class="icon-angle-right"></i></a></span>


													<span class="col-sm-8 ecbtn">
														<button type="button" class="btn btn-primary mybtns">
															<i class="fa fa-star" aria-hidden="true"></i> 已追蹤
														</button>
														<button type="button" class="btn btn-success mybtns">
															<i class="fa fa-check-circle" aria-hidden="true"></i> 已參加
														</button>
													</span>
												</div>
												<div class="blog-tags">
													<li><a href="#"><i class="fa fa-tags"></i>線上</a></li>
													<li><a href="#"><i class="fa fa-tag"></i>專業</a></li>
													<li><a href="#"><i class="fa fa-tag"></i>技術宅</a></li>
													<li><a href="#"><i class="fa fa-tag"></i>帥</a></li>
												</div>
											</div>
										</div>
									</div>
									<!--  end of 1st card         -->
									<!--  end of 1st card         -->
									<hr class="event-post-sep">


									<!--      2st card          -->
									<div class="ec wow fadeInLeft" data-wow-delay=".2s"
										data-wow-duration=".3">
										<div class="row">
											<div class="col-md-4 col-sm-4">
												<a href="#"><img alt="Chulee合唱團"
													class="img-responsive img-rounded"
													src="../src/act/img/eventSamples/glee.jpg"></a>
											</div>

											<div class="col-md-8 col-sm-8">
												<h2>
													<a href="../event-item.html">Chulee合唱團</a>
												</h2>
												<ul class="event-info">
													<li><i class="fa fa-calendar"></i> 2017/7/30起
														每周三晚上8:00-9:00</li>
													<li><i class="fa fa-map-marker"></i><a href="#">桃園市中壢區</a></li>
													<li><i class="fa fa-users"></i>17</li>
													<li><i class="fa fa-user"></i><a href="#">breadcan</a></li>

												</ul>
												<div class="ecContent">
													<p>Chulee合唱團是一個美國電視音樂劇兼青春喜劇，由《整形春秋》的創作人萊恩·墨菲等創作，2009年起開始在福斯電視網播放，故事圍繞著學校裡的"New
														Directions" Glee
														Club及其團員而展開。本劇獲得專業評論普遍的正面評價。本劇於2015年3月20日全劇終，共六季。</p>
												</div>

												<div class="row">
													<span class="col-sm-4"> <a class="more"
														href="../event-item.html">詳細資訊 <i
															class="icon-angle-right"></i></a></span> <span
														class="col-sm-8 ecbtn">
														<button type="button" class="btn btn-default mybtns">
															<i class="fa fa-star-o" aria-hidden="true"></i> 追蹤活動
														</button>
														<button type="button" class="btn btn-default mybtns">
															<i class="fa fa-check-circle-o" aria-hidden="true"></i>
															我要參加
														</button>
													</span>
												</div>
												<div class="blog-tags">
													<li><a href="#"><i class="fa fa-tags"></i>唱歌</a></li>
													<li><a href="#"><i class="fa fa-tag"></i>專業</a></li>
												</div>
											</div>
										</div>
									</div>
									<!--  end of 2st card         -->
									<!--      3nd card          -->
									<div class="ec wow fadeInLeft" data-wow-delay=".2s"
										data-wow-duration=".3">
										<div class="row">
											<div class="col-md-4 col-sm-4">
												<a href="#"><img alt="sample"
													class="img-responsive img-rounded"
													src="../src/act/img/eventSamples/Cap-Commandos.jpg"></a>
											</div>

											<div class="col-md-8 col-sm-8">
												<h2>
													<a href="../event-item.html">Howling Commandos</a>
												</h2>
												<ul class="event-info">
													<li><i class="fa fa-calendar"></i> 2017/7/30 20:46</li>
													<li><i class="fa fa-map-marker"></i><a href="#">桃園市中壢區</a></li>
													<li><i class="fa fa-users"></i>87</li>
													<li><i class="fa fa-user"></i><a href="#">breadcan</a></li>
												</ul>
												<div class="ecContent">
													<p>inline test failed sammmple</p>
												</div>
												<div class="row">
													<span class="col-sm-4"> <a class="more"
														href="../event-item.html">詳細資訊 <i
															class="icon-angle-right"></i></a></span> <span
														class="col-sm-8 ecbtn">
														<button type="button" class="btn btn-primary mybtns">
															<i class="fa fa-star" aria-hidden="true"></i> 已追蹤
														</button>
														<button type="button" class="btn btn-info mybtns">
															<i class="fa fa-check-circle-o" aria-hidden="true"></i>
															我要參加
														</button>
													</span>
												</div>
												<div class="blog-tags">
													<li><a href="#"><i class="fa fa-tags"></i>影視</a></li>
													<li><a href="#"><i class="fa fa-tag"></i>帥哥</a></li>
													<li><a href="#"><i class="fa fa-tag"></i>二戰</a></li>
												</div>
											</div>
										</div>
									</div>
									<!--  ============== end of 3nd card  ==============   -->



								</div>
							</div>
						</div>
						<!-- END CONTENT -->
						<!-- END SIDEBAR & CONTENT -->
						<!--********************活動********************-->
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