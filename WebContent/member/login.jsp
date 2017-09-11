<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <fmt:requestEncoding value="Big5" /> --%>
<%
	//request.setCharacterEncoding("Big5");
%>
<html>

<!-- Head BEGIN -->

<head>
<meta charset="utf-8">
<title>ChuMeet!</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="chumeet_icon.ico">

<!-- Fonts START -->
<!--  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css">-->
<!--  <link href="http://fonts.googleapis.com/earlyaccess/notosanstc.css" rel="stylesheet" type="text/css">-->

<!-- Fonts END -->
<!-- 全站統一CSS 不要亂動，動了要跟全組說 -->

<!-- Global styles START -->
<link
	href="<%=request.getContextPath()%>/assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/pages/css/base.css"
	rel="stylesheet">
<!-- Global styles END -->

<!-- Page level plugin styles START -->
<link
	href="<%=request.getContextPath()%>/assets/plugins/owl.carousel/assets/owl.carousel.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/plugins/fancybox/source/jquery.fancybox.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/assets/pages/css/animate.css"
	rel="stylesheet">
<!-- Page level plugin styles END -->

<!-- Theme styles START -->
<link
	href="<%=request.getContextPath()%>/assets/pages/css/components.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/corporate/css/style.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/corporate/css/style-responsive.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/assets/corporate/css/themes/red.css"
	rel="stylesheet" id="style-color">
<!-- Theme styles END -->

<!--  my styles  -->
<!--@@@@@@@@@@@@@@@@@@@@@@@@@@ 自己的CSS用連結寫到這邊 @@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!! 放在最後一行優先權越高 !!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<!--#################### 單頁CSS路徑統一放在/src/xxx/css/xxx.css ###########-->
<!--%%%%%%%%%%%%%%%%%% 第一行可以刪掉，那是activity(也就是敏道的活動頁)專用的CSS %%%%%-->
<link href="<%=request.getContextPath()%>/src/member/css/login.css"
	rel="stylesheet">
	
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="chumeet">
	<c:import url="/userHeader.jsp">
	</c:import>

	<!-- Header Start -->
	<c:import url="/header.jsp">
	</c:import>

	<!-- Header END -->

	<!--主頁面要修改的都在這下面-->
	<div class="main">

		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">

					<form class="form-horizontal" method="post"
						ACTION="<%=request.getContextPath()%>/member/memberLogin.do">
						<span class="heading">登入</span>
						<div class="form-group">
							<input type="email" class="form-control" id="inputEmail3"
								placeholder="註冊時信箱" name="memEmail" value="${param.memEmail}">
							<i class="fa fa-user"></i>
						</div>
						<div class="form-group help">

							<input type="password" class="form-control" id="inputPassword3"
								placeholder="密碼" name="memPw" value="${param.memPw}"> <i
								class="fa fa-lock"></i>
								<a href="memForget.html" class="fa fa-question-circle"></a>
						</div>
						<div class="form-group">
						<%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<font color='red'> <c:forEach var="message"
									items="${errorMsgs}">
									<h5>${message}</h5>
								</c:forEach>
							</font>
						</c:if>
							<!-- <button type="submit" class="btn btn-default">登入(假)</button> -->
							<!-- <a href="memHome.html" class="btn btn-default">登入(假)</a> -->
								<!-- 						<div class="g-recaptcha"
								data-sitekey="6Lcm6y8UAAAAAGNzeX0Yxst8zgh1ntogvV4U1er_"></div> -->
							<input type="submit" value="登入" class="btn btn-default">
							<input type="hidden" name="action" value="login"> 
						</div>

					</form>
				</div>
			</div>
		</div>


	</div>

	<!-- BEGIN FOOTER -->
	<c:import url="/footer.jsp">
	</c:import>
	<!-- END FOOTER -->

	<!-- Load javascripts at bottom, this will reduce page load time -->
	<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
	<!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>
    <![endif]-->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery.wow.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery.smooth-scroll.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/assets/corporate/scripts/back-to-top-outer.js"
		type="text/javascript"></script>
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
	<!--@@@@@@@@@@@@@@@@@@@@@@@@@ 頁面專屬JS，JS擺在最後有益身心健康，可以刪改 @@@@@@@@@@@@@@@@@@@@@@@@-->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/fancybox/source/jquery.fancybox.pack.js"
		type="text/javascript"></script>
	<!-- pop up -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/owl.carousel/owl.carousel.min.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/assets/corporate/scripts/layout.js"
		type="text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/assets/pages/scripts/bs-carousel.js"
		type="text/javascript"></script>
	<script type="text/javascript">
		//	下面這部分可以增加，別刪感恩
		jQuery(document).ready(function() {
			Layout.init();
			Layout.initOWL();
			Layout.initFixHeaderWithPreHeader(); /* Switch On Header Fixing (only if you have pre-header) */
			Layout.initNavScrolling();
		});
	</script>

	<script
		src="<%=request.getContextPath()%>/assets/plugins/components/wow.min.js"
		type="text/javascript"></script>

	<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->

</html>