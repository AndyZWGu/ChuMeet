<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<!-- Head BEGIN -->
	<!-- 共用Header -->
  <c:import url="/front-end/head.jsp">
</c:import>
<title>ChuMeet! 註冊頁面</title>
	<!-- 共用Header -->
<!--  my styles  -->
<!--@@@@@@@@@@@@@@@@@@@@@@@@@@ 自己的CSS用連結寫到這邊 @@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!--!!!!!!!!!!!!!!!!!!!!!!!!!! 放在最後一行優先權越高 !!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<!--#################### 單頁CSS路徑統一放在/src/xxx/css/xxx.css ###########-->
<!--%%%%%%%%%%%%%%%%%% 第一行可以刪掉，那是activity(也就是敏道的活動頁)專用的CSS %%%%%-->
<link href="<%=request.getContextPath()%>/HTML/src/member/css/register.css"
	rel="stylesheet">
	
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	
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
                <div class=" col-xs-offset-0 col-md-12 col-sm-12">
                    <div class="panel panel-primary" style="margin:20px;">
                        <div class="panel-heading">
                            <h3 class="panel-title">加入揪咪</h3>
                        </div>
                        <div class="panel-body">
                            <form method="post" action="<%=request.getContextPath()%>/front-end/member/memberRegister.do" enctype="multipart/form-data">
                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="Email">帳號*</label>
                                    <input type="email" class="form-control input-sm" id="Email" name="memEmail" placeholder="填寫註冊信箱">
                                </div>
                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="Name">暱稱*</label>
                                    <input type="text" class="form-control input-sm" id="Name" name="memName" placeholder="作為使用者名稱">
                                </div>
                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="Pw">密碼*</label>
                                    <input type="password" class="form-control input-sm" id="Pw" name="memPw" placeholder="密碼">
                                </div>

                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="Phone">手機</label>
                                    <input type="text" class="form-control input-sm" id="Phone" name="memPhone" placeholder="手機">
                                </div>

                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="Pw2">確認密碼*</label>
                                    <input type="password" class="form-control input-sm" id="Pw2" name="memPw2" placeholder="確認密碼">
                                </div>

                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="LocBorn">出生地</label>
                                    <input type="text" class="form-control input-sm" id="LocBorn" name="memLocBorn" placeholder="出生地">
                                </div>

                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="photo">大頭照*</label>
                                    <input type="file" id="photo" name="memAvatar">
                                    <p class="help-block">請上傳一張照片作為您的個人大頭照</p>
                                </div>

                                <div class="form-group col-md-6 col-sm-6">
                                    <label for="LocLive">居住地</label>
                                    <input type="text" class="form-control input-sm" id="LocLive" name="memLocLive" placeholder="居住地">
                                </div>
                                <div class="form-group  col-md-6 col-sm-6">
                                    <label for="BD">生日</label>
                                    <input type="date" class="form-control input-sm" id="BD" name="memBD" placeholder="生日">
                                </div>
                                <div class="form-group  col-xs-offset-6 col-md-6 col-sm-6">
                                    <label for="memGender">性別</label>
                                    <hr>
                                    <label class="radio-inline">
                                  <input type="radio" name="memGender" value="1" checked> 男生<br>
                                </label>
                                    <label class="radio-inline">
                                  <input type="radio" name="memGender" value="0"> 女生<br>
                                </label>
                                </div>
                                <div class="form-group col-md-12 col-sm-12">
                                    <label for="memInt">自我介紹</label>
                                    <textarea class="form-control input-sm" id="memInt" name="memInt" rows="8"></textarea>
                                </div>
                                <div class="form-group col-md-12 col-sm-12 text-center">
                                	<input type="submit" value="註冊" class="btn btn-primary">
									<input type="hidden" name="action" value="register"> 
                                    <div class="form-group col-md-12 col-sm-12 text-center"><a href="#">已經有帳號?</a></div>

                                </div>
                                <div class="form-group col-md-12 col-sm-12 text-right"><input type="button" value="傳說小按鈕" class="btn btn-danger btn-sm" id="lenged"></div>
                            </form>
                        <%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<font color='red'> <c:forEach var="message"
									items="${errorMsgs}">
									<h5>${message}</h5>
								</c:forEach>
							</font>
						</c:if>
                        </div>
                    </div>
                    <!--=============================================================================================-->
                </div>
            </div>
        </div>


	</div>
	<!-- BEGIN FOOTER -->
	<c:import url="/front-end/footer.jsp">
	</c:import>
	<!-- END FOOTER -->

	<!-- 共用Js -->
 <c:import url="/front-end/publicJS.jsp">
</c:import>
  	<!-- 共用Js -->
  	        <!-- 傳說小按鈕 -->
        <script type="text/javascript">
            function magic() {
                document.getElementById('Email').value = 'ChuMeetMaster@gmail.com';
                document.getElementById('Name').value = '揪咪大師';
                document.getElementById('Pw').value = 'ChuMeet';
                document.getElementById('Pw2').value = 'ChuMeet';
                document.getElementById('Phone').value = '3345678';
                document.getElementById('LocBorn').value = '台南';
                document.getElementById('LocLive').value = '台北';
                document.getElementById('BD').value = '2017-09-05';
                document.getElementById('memInt').value = '馬克·艾略特·祖克柏（英語：Mark Elliot Zuckerberg，1984年5月14日－）出生於美國紐約州白原市，是知名的社群網站Facebook的創始人、董事長兼執行長，同時也是一名軟體設計師。Facebook是由他和哈佛大學的同學達斯汀·莫斯科維茲、愛德華多·薩維林、克里斯·休斯於2004年共同創立，被譽爲Facebook教主[5][6]。2010年12月，祖克柏被《時代雜誌》評選為「2010年年度風雲人物」[7]。2014年10月24日，他以352億美元成功打入富比士全球富豪榜2014的世界第10大富豪，成為歷史上最年輕打入世界前10大的億萬富豪。2016年5月27日，他以516億美元成功打入富比士全球富豪榜2016的世界第5大富豪，成為歷史上最年輕打入世界前5大的億萬富豪。祖克柏持有400萬股Facebook公司的A股，另有4.223億股B股。B股控股權為前者十倍；兩者合共佔Facebook控股權54%';
            }

            function init() {
                var btn = document.getElementById("lenged");
                btn.addEventListener("click", magic, false);
            }
            window.onload = init;
        </script>
  	
</body>
<!-- END BODY -->

</html>