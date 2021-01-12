<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border: 1px solid lightgray;
	border-collapse: collapse;
}

table th, td {
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
	border-collapse: collapse;
}

.row {
	padding: 0% 5% 0% 30%;
}

.pwd {
	display: inline-block;
	color: #e66767;
	margin-top: 15px;
	transition: .3s linear;
	font-size: 15px;
	float: center;
	padding-left: 3%;
}

.del {
	display: inline-block;
	color: #e66767;
	margin-top: 15px;
	transition: .3s linear;
	float: right;
	font-size: 15px;
	padding-right: 35%;
}

.pwd:hover {
	color: #c0c0c0;
}

.del:hover {
	color: #c0c0c0;
}

form {
	width: 500px;
}

h3 {
	text-align: center;
}
</style>
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
</head>
<body>
	<u:navbar />
	<hr />

	<div class="container">
		<u:profile />
		<h3>정보</h3>
		<div class="row">
			<div class="col-3"></div>

			<form>
				<table class="table col-8 mt-3">
					<tr>
						<th scope="row" class="table-active">아이디</th>
						<td>${sessionScope.user.id }</td>
					</tr>
					<tr>
						<th scope="row" class="table-active">이름</th>
						<td>${sessionScope.user.name }</td>
					</tr>
					<tr>
						<th scope="row" class="table-active">이메일</th>
						<td>${sessionScope.user.email }</td>
					</tr>
					<tr>
						<th scope="row" class="table-active">생일</th>
						<td>${sessionScope.user.birth }</td>
					</tr>
					<tr>
						<th scope="row" class="table-active">가입일</th>
						<td>${sessionScope.user.regdate }</td>
					</tr>
				</table>
				<a class="pwd" href="${root }/changePwd.do">비밀번호 변경</a> <a
					class="del" href="${root }/deleteMember.do">탈퇴</a>
			</form>
		</div>
	</div>




</body>
</html>