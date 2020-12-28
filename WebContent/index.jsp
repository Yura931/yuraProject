<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${empty sessionScope.user }">
<a href="${root }/join.do">회원가입</a>
<br />
<a href="${root }/login.do">로그인</a>
</c:if>

<c:if test="${not empty sessionScope.user }">
	<a href="${root }/logout.do">로그아웃</a> 
	<br />
	<a href="${root }/changePwd.do">암호변경</a>
	<br />
	<a href="${root }/delete.do">회원탈퇴</a>
</c:if>
</body>
</html>