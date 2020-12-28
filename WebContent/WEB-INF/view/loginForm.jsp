<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<form action="login.do" method="post">
			<p>
			아이디 <br />
			<input type="text" name="id" />
			</p>
			<p>
			비밀번호 <br />
			<input type="text" name="password" />
			</p>
			<input type="submit" value="로그인" />
		</form>
	</div>
</body>
</html>