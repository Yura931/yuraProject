<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	margin-top: 5px;
	margin-right: 10px;
	margin-left: 35%;
	width: 60px;
	height: 35px;
	font-size: 15px;
	background: rgb(226, 226, 226);
	text-align: center;
}
.chanPwd {
    position: absolute;
    left: 55%;
    top: 50%;
    margin: -145px 0 0 -160px;
}
.box_find {
    margin: 35px 0 0;
    border: 1px solid #ddd;
    border-radius: 3px;
    background-color: #fff;
    box-sizing: border-box;
}
table {
	border: 1px solid lightgray;
	border-collapse: collapse;
}

</style>
</head>
<body>
	<u:navbar />
<hr />
	<div class="container">
	<u:profile/>
	<div class="chanPwd">
		<div class="box-find">
		비밀번호가 변경되었습니다. 
		</div>
		<a class="btn" href="${root }/index.jsp">홈</a>		
	</div>
	</div>
	
</body>
</html>