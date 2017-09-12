<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- <fmt:requestEncoding value="Big5" /> --%>  
<%//request.setCharacterEncoding("Big5");%>
<html>

<!-- Head BEGIN -->

<head>
	<!-- 共用Header -->
<c:import url="/head.jsp">
</c:import>
	<!-- 共用Header -->
  <!--  my styles  -->
  <!--@@@@@@@@@@@@@@@@@@@@@@@@@@ 自己的CSS用連結寫到這邊 @@@@@@@@@@@@@@@@@@@@@@@@@@@-->
  <!--!!!!!!!!!!!!!!!!!!!!!!!!!! 放在最後一行優先權越高 !!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
  <!--#################### 單頁CSS路徑統一放在/src/xxx/css/xxx.css ###########-->
  <!--%%%%%%%%%%%%%%%%%% 第一行可以刪掉，那是activity(也就是敏道的活動頁)專用的CSS %%%%%-->
  
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

  
  
  
  <!-- BEGIN FOOTER -->
<c:import url="/footer.jsp">
</c:import>
  <!-- END FOOTER -->

	<!-- 共用Js -->
 <c:import url="/publicJS.jsp">
</c:import>
  	<!-- 共用Js -->
  	
</body>
<!-- END BODY -->

</html>