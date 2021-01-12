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
table {
	border: 1px solid lightgray;
	border-collapse: collapse;
}

table th, td {
	border-top: 1px solid lightgray;
	border-bottom: 1px solid lightgray;
	border-collapse: collapse;
}
th {
	background: rgb(226, 226, 226);
	width:180px;
	text-align: center;
}

.con {
	border: none;
}

.con:focus {
	outline: none;
}

.btn {
margin-top: 5px;
margin-right: 10px;
width: 60px;
height: 35px;
font-size: 15px;
background: rgb(226, 226, 226);
text-align: center;

}
h4 {
text-align: center;
}
</style>
</head>
<body>
<u:navbar/>
<hr />

	<div class="container">
		<u:profile/>
		<div class="row" style="padding: 6% 3% 0% 4%">
		<div class="col-3 mb-2 pl-0"></div>
		<form action="${root }/changePwd.do" method="post">
		<h4>비밀번호 변경</h4>
		<table class="table mt-3">
		<tr>
		<th>현재 비밀번호</th>
		<td><input class="con" type="text" name="curPwd" />
				<c:if test="${errors.curPwd }">
					현재 비밀번호를 입력하세요.
				</c:if>
		</td>
		</tr>	
			<tr>
			<th>새 비밀번호</th>
			<td><input class="con" type="text" name="newPwd" />
				<c:if test="${errors.newPwd }">
					새 비밀번호를 입력하세요.
				</c:if>
			</td>
			</tr>
			
			</table>
			<input class="btn" type="submit" value="변경" />
		</form>
		</div>
		</div>
</body>
</html>
		
		
		
		
		
		
		
		
		
		
		
		
		