<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.member.model.*"%>
<%@ page import="java.util.*"%>
<%
			List<MemberVO> memSearchList = (List)request.getAttribute("memSearchList");
			 pageContext.setAttribute("memSearchList",memSearchList);
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
	<link href="<%=request.getContextPath()%>/HTML/src/member/css/memSerach.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.9.0/sweetalert2.min.css" rel="stylesheet">

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
            <div class="row">
                <div class=" col-sm-12 col-md-12 text-center">
                    <h1>搜尋會員</h1>
                </div>
                <!-- BEGIN CONTENT -->
                <div class="col-md-4 wow fadeInLeft" data-wow-delay=".05s" data-wow-duration=".1">
                    <div class="content-page">
                        <form action="#" class="content-search-view2">
                            <div class="input-group">
                                <h2>縮小範圍</h2>
                            </div>
                            <div class="input-group">
                                <h6>排序</h6>
                                <select class="form-control" id="asc">
                      <option>追蹤數排序</option>
                      <option>好友數排序</option>
                      <option>評價數排序</option>
                      <option>加入日期排序</option>
                      <option>登入次數排序</option>
                    </select>
                            </div>
                            <h6>查詢時間</h6>
                            <div class="input-daterange input-group" id="datepicker">
                                <input type="text" class="input-sm form-control" name="start" placeholder="起始日" />
                                <span class="input-group-addon">to</span>
                                <input type="text" class="input-sm form-control" name="end" placeholder="結束日" />
                            </div>
                            <div class="input-group">
                                <h6>追蹤數：</h6>
                                <input type="text" class="form-control" id="num" placeholder="數量">
                            </div>
                            <div class="input-group">
                                <h6>好友數：</h6>
                                <input type="text" class="form-control" id="num" placeholder="數量">
                            </div>
                            <div class="input-group">
                                <h6>評價數：</h6>
                                <input type="text" class="form-control" id="num" placeholder="數量">
                            </div>
                            <div class="input-group">
                                <h6>登入次數：</h6>
                                <input type="text" class="form-control" id="num" placeholder="數量">
                            </div>
                            <div class="input-group">
                                <h6>出生地：</h6>
                                <select class="form-control" id="born">
                            <option>未選擇</option>
                            <option>台北</option>
                            <option>台中</option>
                            <option>高雄</option>
                            <option>花蓮</option>
                            <option>台東</option>
                          </select>
                            </div>
                            <div class="input-group">
                                <h6>居住地：</h6>
                                <select class="form-control" id="live">
                            <option>未選擇</option>
                            <option>台北</option>
                            <option>台中</option>
                            <option>高雄</option>
                            <option>花蓮</option>
                            <option>台東</option>
                          </select>
                            </div>
                            <div class="input-group">
                                <h6>送出查詢</h6>
                                <input id="register" type="submit" value="確定" class="btn btn-primary">
                            </div>
                        </form>
                    </div>
                </div>
                <!-- END CONTENT -->
                <!--Result-->
                <div class="col-md-8 wow fadeInRight" data-wow-delay=".05s" data-wow-duration=".1">
                    <div class="content-page">
                        <form action="#" class="content-search-view2">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="尋找會員">
                                <span class="input-group-btn">
                          <button type="submit" class="btn btn-primary">搜尋</button>
                        </span>
                            </div>
                        </form>
                        <%@ include file="pageMessage.file" %> 
                        <c:forEach items="${memSearchList}" var="memSearch" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
    						  	<div class="search-result-item col-sm-12 col-md-12">
    						  	<div class="col-sm-3 col-md-3">
                                	<img src="<%=request.getContextPath()%>/front-end/member/memberSearch/avatar.do?memID=${memSearch.memID}" class="thumbnail" alt="Cinque Terre" width="100" height="100">
                                </div>
                                <div class="col-sm-9 col-md-9">
                                	<h4><a href="<%=request.getContextPath()%>/front-end/member/guestHome.do?memID=${memSearch.memID}">${memSearch.memName}</a></h4>
                                	<p>${memSearch.memInt}</p>
                                </div>
                            </div>
						</c:forEach>
                    </div>
                </div>
            </div>
            <!--Result-->
            <!--分頁-->
            <%@ include file="pagination.file" %>
<!--             <div class="row">

                <div class=" col-xs-offset-5 col-md-6 col-sm-6">
                    <ul class="pagination pull-center">
                        <li><a href="javascript:;">«</a></li>
                        <li><a href="javascript:;">1</a></li>
                        <li><span>2</span></li>
                        <li><a href="javascript:;">3</a></li>
                        <li><a href="javascript:;">4</a></li>
                        <li><a href="javascript:;">5</a></li>
                        <li><a href="javascript:;">»</a></li>
                    </ul>
                </div>
            </div> -->
            <!--分頁-->
        </div>
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