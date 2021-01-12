<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<style>
.con {
	width: 860px;
	height: 600px;
	display: inline-block;
	padding-left: 8%;
	padding-top: 10px;
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
	<div class="loginForm mb-3">
		<c:if test="${empty sessionScope.user }">
			<u:login />
		</c:if>
	</div>
</div>

<div class="container">
	
<c:if test="${not empty sessionScope.user }">
	<u:profile/>
	<img class="con" src="${root }/image/공사중.jpg" alt="" />
</c:if>

</div>
	




</body>
</html>