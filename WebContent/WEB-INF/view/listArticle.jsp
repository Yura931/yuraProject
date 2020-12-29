<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="article" items="${articlePage.content }">
		<tr>
			<td>${article.article_no }</td>
			<td>${article.writer.id }</td>
			<td><a href="${root }/article/read.do?no=${article.article_no }">${article.title }</a></td>
			<td>${article.regdate }</td>
			<td>${article.read_cnt }</td>
		</tr>	
	</c:forEach>
	</tbody>	
</table>
<a href="write.do">글 작성</a>

</body>
</html>