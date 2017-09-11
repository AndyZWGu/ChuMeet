<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <fmt:requestEncoding value="Big5" /> --%>  
<%//request.setCharacterEncoding("Big5");%>
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
  <link href="<%=request.getContextPath()%>/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/pages/css/base.css" rel="stylesheet">
  <!-- Global styles END -->

  <!-- Page level plugin styles START -->
  <link href="<%=request.getContextPath()%>/assets/plugins/owl.carousel/assets/owl.carousel.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/pages/css/animate.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="<%=request.getContextPath()%>/assets/pages/css/components.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/corporate/css/style.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/corporate/css/style-responsive.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/corporate/css/themes/red.css" rel="stylesheet" id="style-color">
  <!-- Theme styles END -->

  <!--  my styles  -->
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@ 自己的CSS用連結寫到這邊 @@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <!--!!!!!!!!!!!!!!!!!!!!!!!!!! 放在最後一行優先權越高 !!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
  <!--#################### 單頁CSS路徑統一放在/src/xxx/css/xxx.css ###########-->
  <!--%%%%%%%%%%%%%%%%%% 第一行可以刪掉，那是activity(也就是敏道的活動頁)專用的CSS %%%%%-->
  <link href="<%=request.getContextPath()%>/src/index/index-byAGu.css" rel="stylesheet">
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
  <div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover"
    data-interval="5000">

    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
      <li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
      <li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
      <li data-target="#bootstrap-touch-slider" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper For Slides -->
    <div class="carousel-inner" role="listbox">

      <!-- Third Slide -->
      <div class="item active">

        <!-- Slide Background -->
        <img src="src/index/img/1920x500_4.jpg" alt="Bootstrap Touch Slider" class="slide-image" />
        <div class="bs-slider-overlay"></div>
        <div class="container">
          <div class="row">
            <!-- Slide Text Layer -->
            <div class="slide-text slide_style_left">
              <h1 data-animation="animated zoomInRight">找朋友？</h1>
              <p data-animation="animated fadeInLeft">廣大社群朋友愉快玩！來看看大家的動態吧！</p>
              <a href="member/memNF.html" target="" class="btn btn-primary" data-animation="animated fadeInLeft">來去看看</a>              </div>
          </div>
        </div>
      </div>
      <!-- End of Slide -->

      <!-- Second Slide -->
      <div class="item">

        <!-- Slide Background -->
        <img src="src/index/img/1920x500_1.jpg" alt="Bootstrap Touch Slider" class="slide-image" />
        <div class="bs-slider-overlay"></div>
        <!-- Slide Text Layer -->
        <div class="slide-text slide_style_center">
          <h1 data-animation="animated zoomInRight">找活動？</h1>
          <p data-animation="animated fadeInLeft">全台大小活動輕鬆搜，快一步掌握玩樂情報，好康不錯過！</p>
          <a href="act/act.html" target="" class="btn btn-default" data-animation="animated fadeInLeft">來去參加</a> <a href="act/actStart.html"
            target="_blank" class="btn btn-primary" data-animation="animated fadeInRight">建立活動</a> </div>
      </div>
      <!-- End of Slide -->

      <!-- Third Slide -->
      <div class="item">

        <!-- Slide Background -->
        <img src="src/index/img/1920x500_3.jpg" alt="Bootstrap Touch Slider" class="slide-image" />
        <div class="bs-slider-overlay"></div>
        <!-- Slide Text Layer -->
        <div class="slide-text slide_style_right">
          <h1 data-animation="animated flipInX">玩社團？</h1>
          <p data-animation="animated lightSpeedIn">各地社團輕鬆找！搶先參加熱門團體活動！</p>
          <a href="club/club_ALL.html" target="" class="btn btn-default" data-animation="animated fadeInUp">來去尋找</a> <a href="club/clubStart.html"
            target="_blank" class="btn btn-primary" data-animation="animated fadeInDown">創立社團</a> </div>
      </div>
      <!-- End of Slide -->

      <div class="item">

        <!-- Slide Background -->
        <img src="src/index/img/1920x500_2.jpg" alt="Bootstrap Touch Slider" class="slide-image" />
        <div class="bs-slider-overlay"></div>
        <!-- Slide Text Layer -->
        <div class="slide-text slide_style_center">
          <h1 data-animation="animated flipInX">加入我們！</h1>
          <p data-animation="animated lightSpeedIn">在我們提供的平台上，找到您志同道合的好朋友吧！</p>
          <a href="member/login.html" target="" class="btn btn-default" data-animation="animated fadeInLeft">登入</a> <a href="member/register.html"
            target="_blank" class="btn btn-primary" data-animation="animated fadeInRight">註冊</a> </div>
      </div>

    </div>
    <!-- End of Wrapper For Slides -->

    <!-- Left Control -->
    <a class="left carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="prev"> <span class="fa fa-angle-left" aria-hidden="true"></span> <span class="sr-only">Previous</span> </a>

    <!-- Right Control -->
    <a class="right carousel-control" href="#bootstrap-touch-slider" role="button" data-slide="next"> <span class="fa fa-angle-right" aria-hidden="true"></span> <span class="sr-only">Next</span> </a>    </div>
  <!-- End  bootstrap-touch-slider Slider -->
  <!--================================================================-->
  <hr class="colorgraph">
  <div class="container popular">
    <div class="row">
      <h2 class="text-center">人氣排行榜</h2>
      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
        <div class="hot-act"> <img src="src/index/500x314-exactly.jpg" alt="" class="img-responsive">
          <div class="caption">
            <h4 class="pull-right">免費</h4>
            <h4><a href="#">♥義賣跳蚤市場▲塔羅占卜▲vintage▲手作甜點..一起幫助流浪兔!Holiday ya二手市集</a></h4>
            <p>《Holiday ya二手市集》 台灣第一個以社會企業模式打造的市集！ 再生x愛兔x歡樂 愛心義賣跳蚤市場x交換書/CD x創意市集x手作甜點x古著</p>
          </div>
          <div class="ratings">
            <p> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span>              <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star-empty"></span> (379 reviews)
              </p>
          </div>
          <div class="space-ten"></div>
          <div class="btn-ground text-center">
            <button type="button" class="btn btn-primary"><i class="fa fa-star-o fa-lg"></i> 追蹤</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#product_view"><i class="fa fa-search fa-lg"></i> 活動詳情</button>
          </div>
          <div class="space-ten"></div>
        </div>
      </div>
      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
        <div class="hot-act"> <img src="src/index/500x314-music.jpg" alt="" class="img-responsive">
          <div class="caption">
            <h4 class="pull-right">門票$200</h4>
            <h4><a href="#">臺中爵士音樂節 2017 Jazz Green Land 綺響花園 市民廣場/草悟道</a></h4>
            <p>「萬種風情」是臺中這一座魅力城市的代名詞，飲食文化、山海風景、人文藝術…處處皆不經意流瀉臺中市民對這塊土地的情感，而邁入第十五個</p>
          </div>
          <div class="ratings">
            <p> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span>              <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star-empty"></span> (871 reviews)
              </p>
          </div>
          <div class="space-ten"></div>
          <div class="btn-ground text-center">
            <button type="button" class="btn btn-primary"><i class="fa fa-star-o fa-lg"></i> 追蹤</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#product_view"><i class="fa fa-search fa-lg"></i> 活動詳情</button>
          </div>
          <div class="space-ten"></div>
        </div>
      </div>
      <div class="col-lg-4 col-md-4 col-sm-6 col-xs-6">
        <div class="hot-act"> <img src="src/index/fisu.jpg" alt="" class="img-responsive">
          <div class="caption">
            <h4 class="pull-right">依場次</h4>
            <h4><a href="#">世界大學運動會2017</a></h4>
            <p>2017夏季世界大學運動會將在臺北市舉辦，這將是臺灣有史以來最大及層級最高的國際運動賽會。我一直期望臺北是一個健康、活力的城市。</p>
          </div>
          <div class="ratings">
            <p> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span>              <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> (5826 reviews)
              </p>
          </div>
          <div class="space-ten"></div>
          <div class="btn-ground text-center">
            <button type="button" class="btn btn-primary"><i class="fa fa-star fa-lg"></i> 追蹤</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#product_view"><i class="fa fa-search fa-lg"></i> 活動詳情</button>
          </div>
          <div class="space-ten"></div>
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade product_view" id="product_view">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header"> <a href="#" data-dismiss="modal" class="class pull-right"><span class="glyphicon glyphicon-remove"></span></a>
          <h3 class="modal-title">世界大學運動會2017</h3>
        </div>
        <div class="modal-body">
          <div class="row">
            <div class="col-md-6 product_img"><img src="src/index/世大運線上直播賽程表.png" class=""> <img src="src/index/世大運選手篇-A版.jpg" class=""></div>
            <div class="col-md-6 product_content">
              <h4>活動號: <span>51526</span></h4>
              <div class="rating"> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span>                <span class="glyphicon glyphicon-star"></span> <span class="glyphicon glyphicon-star"></span> (5826 reviews)
                </div>
              <p>世界大學運動會（英语：Universiade），簡稱世大運、大运会，是一項專供大學生運動員參加的國際綜合性體育活動，主辦組織為國際大學運動總會。 現在世界大學運動會分為夏季世界大學運動會及冬季世界大學運動會，皆為每兩年舉行一次。</p>
              <div class="row">
                <div class="col-sm-12 col-md-12">
                  <h3>費用</h3>
                  <h4 class="cost bg-info"> 依場次 </h4>
                </div>
                <div class="col-sm-12 col-md-12">
                  <h3>時間</h3>
                  <h4 class="cost bg-info"> <a href="https://tickets.2017.taipei/info/pricenote">官網查詢</a> </h4>
                </div>
                <div class="col-sm-12 col-md-12">
                  <h3>地點</h3>
                  <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2594.7838022108976!2d121.19048833563365!3d24.96718203315507!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x1b5e6ee66e9fec49!2z6LOH562W5pyD5Lit5aOiIFRpYmFNZSDlnIvpmpvkurrmiY3nmbzlsZXkuK3lv4M!5e0!3m2!1szh-TW!2stw!4v1503981681223"
                    width="400" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
              </div>
              <div class="space-ten"></div>
              <div class="btn-ground text-center">
                <button type="button" class="btn btn-primary"><span class="fa fa-user-plus fa-lg"></span>報名參加</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--================================================================-->
  <hr class="colorgraph">
  <div class="container">
    <div class="row text-center">
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail animated swing"> <a href="#"> <img src="src/act/POI/POI01.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>運動</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI02.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>桌遊</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI03.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>職場</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI04.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>手作</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI05.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>學習</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI06.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>餐聚</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI07.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>藝文活動</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI08.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>藝術</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI09.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>健康</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI10.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>電影</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI11.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>音樂</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"><img src="src/act/POI/POI12.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>電動遊戲</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"><img src="src/act/POI/POI13.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>線上活動</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI14.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>戶外</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI15.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>寵物</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI16.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>唱歌</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI17.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>兒童</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI18.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>展覽</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI19.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>攝影</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI20.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>專業</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI21.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>讀書會</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI22.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>購物</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI23.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>時尚</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI24.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>文化交流</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI25.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>宗教</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI26.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>冒險</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI27.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>社交</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI28.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>慈善活動</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI29.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>研討會</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"><a href="#"> <img src="src/act/POI/POI30.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>戲劇表演</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI31.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>ACG</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI32.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>演唱會</h3>
        </div>
        </a> </div>
      </div>
      <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
        <div class="thumbnail"> <a href="#"> <img src="src/act/POI/POI33.png" alt="Thumbnail Image 1" class="">
        <div>
          <h3>其他</h3>
        </div>
        </a> </div>
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
  <script src="<%=request.getContextPath()%>/assets/plugins/jquery.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/assets/plugins/jquery.wow.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/assets/plugins/jquery.smooth-scroll.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/assets/corporate/scripts/back-to-top-outer.js" type="text/javascript"></script>
  <!-- END CORE PLUGINS -->

  <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@ 頁面專屬JS，JS擺在最後有益身心健康，可以刪改 @@@@@@@@@@@@@@@@@@@@@@@@-->
  <script src="<%=request.getContextPath()%>/assets/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script>
  <!-- pop up -->
  <script src="<%=request.getContextPath()%>/assets/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/assets/corporate/scripts/layout.js" type="text/javascript"></script>
  <script src="<%=request.getContextPath()%>/assets/pages/scripts/bs-carousel.js" type="text/javascript"></script>
  <script type="text/javascript">
    //	下面這部分可以增加，別刪感恩
    jQuery(document).ready(function () {
      Layout.init();
      Layout.initOWL();
      Layout.initFixHeaderWithPreHeader(); /* Switch On Header Fixing (only if you have pre-header) */
      Layout.initNavScrolling();
    });
  </script>
  <script src="<%=request.getContextPath()%>/assets/plugins/components/wow.min.js" type="text/javascript"></script>

  <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->

</html>