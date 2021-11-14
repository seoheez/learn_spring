<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	# 컨텍스트 루트 경로가 변경될 경우 처리 방법.
	1. 컨텍스트 루트 경로를 변수로 지정함.
	2. <c:url> 태그를 사용
 --%>
<c:set var="path" value="<%= request.getContextPath() %>" scope="application"/> <!-- 요청 정보를 통해서 contextpath를 읽어들여서 path라는 이름의 이엘변수에 저장한다. -->
<!DOCTYPE html>																	<!-- 컨텍스트루트가 변경되어도 신경쓰지 않아도 됨. -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>요청 파라미터값 테스트!!</h3>
<%-- 1번방식
	<form action="${path}/request/join" method="post"></form>
--%>		
<%-- 2번방식--%>
	<form action="<c:url value='/request/join'/>" method="post"> <!-- value엔 컨텍스트 경로를 제외한 절대경로. 패스변수도 지정하지 않아도 됨. -->
		<fieldset> <!-- 양식을 구축하기 위한 마크업 -->
			<legend>회원가입 양식</legend>
			<p>
				- ID: <input type="text" name="userId" size="10"><br> <!-- name은 서버로 들어가면 파라미터 변수의 이름 -->
				- PW: <input type="password" name="userPw" size="10"><br>
				- NAME: <input type="text" name="userName" size="10"><br>
				- HOBBY:
				<input type="checkbox" name="hobby" value="soccer">축구&nbsp;>
				<input type="checkbox" name="hobby" value="book">독서&nbsp;>
				<input type="checkbox" name="hobby" value="music">음악&nbsp;>
				<br>
				<input type="submit" value="회원가입">
			</p>
		</fieldset>
	</form>
</body>
</html>