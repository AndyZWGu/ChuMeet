<%@ page contentType="text/html; charset=Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.member.model.*"%>
<%
MemberVO memVO = (MemberVO) request.getAttribute("memVO"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>
<fmt:formatDate value="${memVO.memBD}" pattern="yyyy-MM-dd HH:mm:ss" />
<html>
<head>
<title>�|�����	Demo.jsp</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='600'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>���u��� - ListOneEmp.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='600'>
	<tr>
		<th>�|���s��</th>
		<th>�|���H�c</th>
		<th>�|���K�X</th>
		<th>�|�����Һ���</th>
		<th>�|������</th>
		<th>�|���g��</th>
		<th>�|�����I</th>
		<th>�|���W��</th>
		<th>�|���ʧO</th>
		<th>�|���ͤ�</th>
		<th>�|�����</th>
		<th>�|���j�Y��</th>
		<th>�|���[�J���}���</th>
		<th>�|���n�J����</th>
		<th>�|���X�ͦa</th>
		<th>�|���~��a</th>
		<th>�|���ۧڤ���</th>
		<th>�|�����</th>
		<th>�|���n��</th>
		<th>�|�����p�v�]�w</th>
		<th>�|�����Ҫ��A</th>
		
	</tr>
	<tr align='center' valign='middle'>
		<td>${memVO.memID}</td>
		<td>${memVO.memEmail}</td>
		<td>${memVO.memPw}</td>
		<td>${memVO.memberType}</td>
		<td>${memVO.memLv}</td>
		<td>${memVO.memExp}</td>
		<td>${memVO.memPt}</td>
		<td>${memVO.memName}</td>
		<td>${memVO.memGender}</td>
		<td>${memVO.memBD}</td>
		<td>${memVO.memPhone}</td>
		<td>${memVO.memAvatar}</td>
		<td>${memVO.memJoinDate}</td>
		<td>${memVO.memLoginNum}</td>
		<td>${memVO.memLocBorn}</td>
		<td>${memVO.memLocLive}</td>
		<td>${memVO.memInt}</td>
		<td>${memVO.memLong}</td>
		<td>${memVO.memLat}</td>
		<td>${memVO.memPriv}</td>
		<td>${memVO.memStatus}</td>
	</tr>
</table>

</body>
</html>