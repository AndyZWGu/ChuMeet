<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <fmt:requestEncoding value="Big5" /> --%>
<%
	//request.setCharacterEncoding("Big5");
%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="com.member.model.*"%>
<%
/* MemberVO memVO = (MemberVO) request.getAttribute("memVO"); //EmpServlet.java(Concroller), 存入req的empVO物件 */
MemberVO memVO = (MemberVO) session.getAttribute("memVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<html>

<!-- Head BEGIN -->
	<!-- 共用Header -->
  <c:import url="/head.jsp">
</c:import>
	<!-- 共用Header -->
<!--  my styles  -->
<!--@@@@@@@@@@@@@@@@@@@@@@@@@@ 自己的CSS用連結寫到這邊 @@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!! 放在最後一行優先權越高 !!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<!--#################### 單頁CSS路徑統一放在/src/xxx/css/xxx.css ###########-->
<!--%%%%%%%%%%%%%%%%%% 第一行可以刪掉，那是activity(也就是敏道的活動頁)專用的CSS %%%%%-->
	<link href="<%=request.getContextPath()%>/src/member/css/memHome.css" rel="stylesheet">
	
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
      <div class="row profile">
        <div class="col-md-3">
          <div class="profile-sidebar">
            <!-- SIDEBAR USERPIC -->
            <div class="profile-userpic"> <img src="../src/member/img/avatar/default-avatar.png" class="" alt=""> </div>
            <!-- END SIDEBAR USERPIC -->
            <!-- SIDEBAR USER TITLE -->
            <div class="profile-usertitle">
              <div class="profile-usertitle-name"> ${memVO.memName} </div>
              <div class="profile-usertitle-level"> 剛加入的初心者 </div>
            </div>
            <div class="row overvie">
              <div class="col-md-4 user-pad text-center glyphicon glyphicon-star-empty">
                <h5>跟隨</h5>
                <h4>9,527</h4>
              </div>
              <div class="col-md-4 user-pad text-center glyphicon glyphicon-user">
                <h5>好友數</h5>
                <h4>486</h4>
              </div>
              <div class="col-md-4 user-pad text-center glyphicon glyphicon-thumbs-up">
                <h5>評分數</h5>
                <h4>6,666</h4>
              </div>
            </div>
            <!-- END SIDEBAR USER TITLE -->
            <!-- SIDEBAR MENU -->
            <div class="profile-usermenu">
              <div class="row text-center pt">
                <hr> 持有Pt點數:
                <p>${memVO.memPt}</p>
              </div>
              <ul class="nav">
                <li class="active"> <a href="memHome.html"> <i class="glyphicon glyphicon-home"></i> 首頁 </a> </li>
                <li> <a href="memNF.html"> <i class="glyphicon glyphicon-tint"></i> 我的動態 </a> </li>
                <li> <a href="memLevel.html"> <i class="glyphicon glyphicon-road"></i> 等級/積分 </a> </li>
                <li> <a href="memInfo.html"> <i class="glyphicon glyphicon-user"></i> 基本資訊 </a> </li>
                <li> <a href="memAch.html"> <i class="glyphicon glyphicon-flag"></i> 成就 </a> </li>
                <li> <a href="memOpinion.html"><i class="glyphicon glyphicon-thumbs-up"></i> 評價 </a> </li>
                <li> <a href="memSetting.html"> <i class="glyphicon glyphicon-cog"></i> 個人頁面設定 </a> </li>
              </ul>
            </div>
            <!-- END MENU -->
          </div>
        </div>
        <div class="col-md-9">
          <!--  statitics -->
          <div class="row">
            <div class="col-lg-3">
              <div class="panel panel-info">
                <div class="panel-heading">
                  <div class="row">
                    <div class="col-xs-6">
                      <i class="fa fa-envelope-o fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                      <p class="announcement-heading">3件</p>
                      <p class="announcement-text"></p>
                      <!--	<p class="announcement-text">Users</p> -->
                    </div>
                  </div>
                </div>
                <a href="#">
                  <div class="panel-footer announcement-bottom">
                    <div class="row">
                      <div class="col-xs-6">
                        <button type="button" class="btn btn-info btn-sm"> 收件夾 </button>
                      </div>
                      <div class="col-xs-6 text-right">
                        <!-- <i class="fa fa-arrow-circle-right"></i> -->
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="panel panel-danger">
                <div class="panel-heading">
                  <div class="row">
                    <div class="col-xs-6">
                      <i class="fa fa-diamond fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                      <p class="announcement-heading">今日+45點</p>
                      <p class="announcement-text"></p>
                      <!-- <p class="announcement-text"> Items</p> -->
                    </div>
                  </div>
                </div>
                <a href="#">
                  <div class="panel-footer announcement-bottom">
                    <div class="row">
                      <div class="col-xs-6">
                        <button type="button" class="btn btn-primary btn-sm"> 使用揪點 </button>
                      </div>
                      <div class="col-xs-6 text-right">
                        <!-- <i class="fa fa-arrow-circle-right"></i> -->
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="panel panel-warning">
                <div class="panel-heading">
                  <div class="row">
                    <div class="col-xs-6">
                      <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                      <p class="announcement-heading">未讀6</p>
                      <p class="announcement-text"></p>
                    </div>
                  </div>
                </div>
                <a href="#">
                  <div class="panel-footer announcement-bottom">
                    <div class="row">
                      <div class="col-xs-6">
                        <button type="button" class="btn btn-warning btn-sm"> 管理社群 </button>
                      </div>
                      <div class="col-xs-6 text-right">
                        <!-- <i class="fa fa-arrow-circle-right"></i> -->
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
            <div class="col-lg-3">
              <div class="panel panel-success">
                <div class="panel-heading">
                  <div class="row">
                    <div class="col-xs-6">
                      <i class="fa fa-comments fa-5x"></i>
                    </div>
                    <div class="col-xs-6 text-right">
                      <p class="announcement-heading">未讀2</p>
                      <p class="announcement-text"></p>
                    </div>
                  </div>
                </div>
                <a href="#">
                  <div class="panel-footer announcement-bottom">
                    <div class="row">
                      <div class="col-xs-6">
                        <button type="button" class="btn btn-success btn-sm"> 聊天 </button>
                      </div>
                      <div class="col-xs-6 text-right">
                        <!-- <i class="fa fa-arrow-circle-right"></i> -->
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
          </div>
          <!-- /.row -->
          <!--  statitics -->

          <div class="row profile-content">
            <center>
              <br>
              <br>
              <div class="row introduction"> ${memVO.memInt} </div>
              <br>
              <hr class="colorgraph">
              <h3>參加的活動</h3>
              <br>
              <div class="tags">義賣跳蚤市場</div>
              <br>
              <div class="tags">卡通頻道 老皮繪畫野餐</div>
              <br>
              <div class="tags">台北秋季國際美容化妝品展</div>
              <br>
              <div class="tags">【觀光工廠】老樹根魔法木工坊DIY體驗</div>
              <br>
              <div class="tags">再..再西一口就好..【西門夜說粉絲見面會】</div>
              <br>
              <div class="tags">BANG!BANG!RUNNING BANG!科學麵吃完剩什麼？統一超商春季商品展</div>
              <br>
            </center>
            <hr class="colorgraph">
            <!--留言板-->
            <article class="row mb-right">
              <div class="col-md-10 col-sm-10">
                <div class="panel panel-default mb">
                  <header class="text-left">
                    <div class="mb-title"><i class=""></i> 鸚鵡兄弟～參戰！</div>
                  </header>
                  <div class="mb-content">
                    <p> 不是……不要誤會，我不是針對你，我是說在座的各位……都是垃圾。</p>
                    <p class="text-right">
                      <time>2017-08-19 08:14</time>
                      <button type="button" class="btn btn-danger btn-sm">檢舉</button>
                    </p>
                  </div>
                </div>
              </div>
              <div class="col-md-2 col-sm-2">
                <figure class="thumbnail"> <img class="" src="../src/member/img/god.jpg" />
                  <figcaption class="text-center">斷水流大鸚鵡</figcaption>
                </figure>
              </div>
            </article>
            <article class="row mb-right">
              <div class="col-md-10 col-sm-10">
                <div class="panel panel-default mb">
                  <header class="text-left">
                    <div class="mb-title"><i class=""></i> 等等！</div>
                  </header>
                  <div class="mb-content">
                    <p> 靠！沒有這樣玩的拉！！！</p>
                    <p class="text-right">
                      <time>2017-08-19 08:12</time>
                      <button type="button" class="btn btn-danger btn-sm">檢舉</button>
                    </p>
                  </div>
                </div>
              </div>
              <div class="col-md-2 col-sm-2">
                <figure class="thumbnail"> <img class="" src="../src/member/img/dog-wtf.jpg" />
                  <figcaption class="text-center">狗本大隊長</figcaption>
                </figure>
              </div>
            </article>
            <article class="row mb-left">
              <div class="col-md-2 col-sm-2">
                <figure class="thumbnail"> <img class="" src="../src/member/img/avatar/default-avatar.png" />
                  <figcaption class="text-center">喵星人</figcaption>
                </figure>
              </div>
              <div class="col-md-10 col-sm-10">
                <div class="panel panel-default mb">
                  <header class="text-left">
                    <div class="mb-title"><i class=""></i> 好啊來戰啊！</div>
                  </header>
                  <div class="mb-content">
                    <p> 開戰前先按個檢舉再說～ </p>
                    <p class="text-right">
                      <time>2017-08-19 08:10</time>
                    </p>
                  </div>
                </div>
              </div>
            </article>
            <article class="row mb-right">
              <div class="col-md-10 col-sm-10">
                <div class="panel panel-default mb">
                  <header class="text-left">
                    <div class="mb-title"><i class=""></i> 我一定要說句公道話</div>
                  </header>
                  <div class="mb-content">
                    <p> 狗狗才是最棒的！！！ 不服來辯！！！ </p>
                    <p class="text-right">
                      <time>2017-08-19 07:39</time>
                      <button type="button" class="btn btn-danger btn-sm">檢舉</button>
                    </p>
                  </div>
                </div>
              </div>
              <div class="col-md-2 col-sm-2">
                <figure class="thumbnail"> <img class="" src="../src/member/img/dog-wtf.jpg" />
                  <figcaption class="text-center">狗本大隊長</figcaption>
                </figure>
              </div>
            </article>
            <!--留言功能-->
            <hr class="colorgraph">
            <article class="row mb-input">
              <div class="col-md-12 col-sm-12">
                <div class="panel panel-default mb">
                  <div class="form-group">
                    <label for="title">標題:</label>
                    <br>
                    <input type="text">
                    <br>
                    <label for="comment">內容:</label>
                    <textarea class="form-control" id="comment">
                </textarea>
                    <div class="mb-submit">
                      <button type="button" class="btn btn-danger btn-sm">留言</button>
                    </div>
                  </div>
                </div>
              </div>
            </article>
            <!--留言版喔喔-->
          </div>
        </div>
      </div>
    </div>
    <br>
    <br>
  </div>
  
	<!-- BEGIN FOOTER -->
	<c:import url="/footer.jsp">
	</c:import>
	<!-- END FOOTER -->

	<!-- 共用Js -->
 <c:import url="/publicJS.jsp">
</c:import>
  	<!-- 共用Js -->
  	
  	<!-- 自己加的Js -->
		<script
		src="<%=request.getContextPath()%>/assets/plugins/components/wow.min.js"
		type="text/javascript"></script>
		<!-- 共用Js -->
</body>
<!-- END BODY -->

</html>