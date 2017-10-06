<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.member.model.*"%>
<%@ page import="java.util.*"%>
<%
	List<MemMBVO> memMBList = (List) request.getAttribute("memMBList");
	List<MemberVO> mbMemNameList = (List) request.getAttribute("mbMemNameList");
%>

<div class="col-md-9 wow bounce" data-wow-delay=".05s"
	data-wow-duration=".1">

	<div class="row profile-content blog-item">
		<h2>關於我</h2>
		<div class="introduction">${memVO.memInt}</div>
		<hr class="colorgraph">
		<!--********************首頁********************-->
		<!-- BEGIN CONTENT -->
		<div class="col-md-12 col-sm-12">
			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab" href="#home">參加中的活動</a></li>
				<li><a data-toggle="tab" href="#act">參加的社團</a></li>
			</ul>

			<div class="tab-content">
				<div id="act" class="tab-pane fade in active">
					<div class="container-fluid bg-3 text-center reward">
						<div class="row">
							<div class="col-sm-4">
								<img
									src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}"
									alt="Image" class="img-responsive thumbnail">
								<p>Lorem ipsum..</p>
							</div>
							<div class="col-sm-4">
								<img
									src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}"
									alt="Image" class="img-responsive thumbnail">
								<p>Lorem ipsum..</p>
							</div>
							<div class="col-sm-4">
								<img
									src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}"
									alt="Image" class="img-responsive thumbnail">
								<p>Lorem ipsum..</p>
							</div>
							<div class="row">
								<a href="http://www.google.com"><input type="button"
									class="btn btn-primary" value="看更多"></a>
							</div>
						</div>
					</div>
				</div>
				<div id="club" class="tab-pane fade">
					<div class="container-fluid bg-3 text-center reward">
						<div class="row">
							<div class="col-sm-4">
								<img
									src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}"
									alt="Image" class="img-responsive thumbnail">
								<p>Lorem ipsum..</p>
							</div>
							<div class="col-sm-4">
								<img
									src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}"
									alt="Image" class="img-responsive thumbnail">
								<p>Lorem ipsum..</p>
							</div>
							<div class="col-sm-4">
								<img
									src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memVO.memID}"
									alt="Image" class="img-responsive thumbnail">
								<p>Lorem ipsum..</p>
							</div>
							<div class="row">
								<a href="http://www.google.com"><input type="button"
									class="btn btn-primary" value="看更多"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
			<hr class="colorgraph">
		</div>
		<!-- END CONTENT -->
		<!--********************首頁********************-->
		<!--**************************留言板**************************-->
		<h2>留言板</h2>
		<div class="comments wow fadeInRight" data-wow-delay=".05s"
			data-wow-duration=".1">
			<c:forEach items="${memMBList}" var="memMBList"  varStatus="status">
				<div class="media">
					<c:if test="${mbMemNameList[status.index].memID != memVO.memID}">
						<a
							href="<%=request.getContextPath()%>/front-end/member/guestHome.do?memID=${memMBList.memID}"
							class="pull-left"> <img
							src="<%=request.getContextPath()%>/front-end/member/guestHome/avatar.do?memID=${memMBList.memID}"
							alt="" class="media-object">
							<p>${mbMemNameList[status.index].memName}</p>
						</a>
					</c:if>
					<c:if test="${mbMemNameList[status.index].memID == memVO.memID}">
						<a
							href="<%=request.getContextPath()%>/front-end/member/memberHome.do?memID=${memMBList.memID}"
							class="pull-left"> <img
							src="<%=request.getContextPath()%>/front-end/member/memberHome/avatar.do?memID=${memMBList.memID}"
							alt="" class="media-object">
							<p>${mbMemNameList[status.index].memName}</p>
						</a>
					</c:if>
					<div class="media-body">
						<p>${memMBList.mbContent}</p>
						<span><fmt:formatDate value="${memMBList.mbDate}" pattern="yyyy/MM/dd hh:mm" /></span>
						<div class="col-sm-12 text-right">
							<c:if test="${mbMemNameList[status.index].memID != memVO.memID}">
								<input type="button" value="檢舉" class="btn btn-danger btn-xs">
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>
			<!--**************************留言功能**************************-->
			<div class="post-comment padding-top-40">
				<h3>留言</h3>
				<form role="form" method="post" action="<%=request.getContextPath()%>/front-end/member/memberHome.do">
					<div class="form-group">
						<h4>內容</h4>
						<textarea class="form-control" rows="2" name="comment"></textarea>
					</div>
					<p>
						<button class="btn btn-primary" type="submit">提交</button>
						<input type="hidden" name="action" value="comment">
					</p>
				</form>
			</div>
		</div>
		<!--**************************留言版**************************-->
	</div>
</div>