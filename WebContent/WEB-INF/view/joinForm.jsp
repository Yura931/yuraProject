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
		<form action="join.do" method="post">
			<p> 아이디 <br />
			<input type="text" name="id" />
			</p>
			<p> 이름 <br />
			<input type="text" name="name" />
			</p>
			<p> 비밀번호 <br />
			<input type="text" name="password"/>
			</p>
			<p> 비밀번호 확인 <br />
			<input type="text" name="confirmPassword"/>
			</p>
			<p> email <br />
			<input type="text" name="email" />
			</p>
			<p> 생일 <br /> 
			<input type="date" name="birth" />
			</p>
			<input type="submit" value="회원가입"/>
		</form>
	</div>

</body>
</html>