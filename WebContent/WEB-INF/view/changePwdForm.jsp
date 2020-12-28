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
	<div class="container">
		<form action="${root }/changePwd.do" method="post">
			<p>
				현재 비밀번호 <br />
				<input type="text" name="curPwd" />
				<c:if test="${errors.curPwd }">
					현재 비밀번호를 입력하세요.
				</c:if>
			</p>
			<p>
				새 비밀번호 <br />
				<input type="text" name="newPwd" />
				<c:if test="${errors.newPwd }">
					새 비밀번호를 입력하세요.
				</c:if>
			</p>
			<input type="submit" value="변경" />
		</form>
	</div>
</body>
</html>