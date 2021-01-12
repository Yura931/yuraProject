<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
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
	width:100px;
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

</style>
</head>
<body>
<u:navbar/>
<hr />

<div class="container">
	<u:profile/>
	<div class="row" style="padding: 0% 3% 0% 4%">
	<div class="col-3 mb-2 pl-0"></div>
     <table class="table mt-3"> 
     <tr>
	<th>작성자</th>
	<td>${articleData.article.writer.id }</td>	
	</tr>
	<tr>
		<th>번호</th>
		<td>
			<input class="con" type="text" value="${articleData.article.article_no }" readonly/>
		</td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td>
			<input class="con" type="text" value="${articleData.article.title }" readonly/>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea class="con" name="body" id="" cols="100" rows="10" readonly>${articleData.article.content }</textarea>
		</td>
	</tr>
	</table>
	
	<br />

<a class="btn" href="${root }/article/list.do">목록</a>

	<c:if test="${user.id == articleData.article.writer.id }">
		<a class="btn" href="${root }/article/modify.do?no=${articleData.article.article_no }">수정</a>
		<a class="btn" href="${root }/article/delete.do?no=${articleData.article.article_no }">삭제</a>
	</c:if>
</div>
</div>

</body>
</html>




