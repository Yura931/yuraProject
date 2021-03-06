<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
  src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
<style>
.btn {
    margin: 20px 0 0;
    width: 100%;
    height: 48px;
    border-radius: 3px;
    font-size: 16px;
    color: #fff;
    background-color: #000;
    text-align: center;
}
.inner_join {
    position: absolute;
    left: 55%;
    top: 60%;
    margin: -145px 0 0 -160px;
}
table {
	border: 1px solid lightgray;
	border-collapse: collapse;
}

.box_login {
    margin: 35px 0 0;
    border: 1px solid #ddd;
    border-radius: 3px;
    background-color: #fff;
    box-sizing: border-box;
}
</style>
</head>
<body>
<u:navbar/>

<div class="inner_join">
	<div class="box-login">
			${joinReq.name }님 회원가입 되셨습니다.
	</div>
		<a class="btn" href="${root }/login.do">로그인 하러가기</a>		
</div>
</body>
</html>