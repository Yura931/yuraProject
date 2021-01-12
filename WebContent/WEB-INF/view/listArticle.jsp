<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<style>
a {
	color: #333;
}
body, input, td, th {
    font-size: 15px;
    line-height: 1.5;
    -webkit-font-smoothing: antialiased;
}    

h {
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
<u:navbar/>
<hr />


<c:if test="${not empty sessionScope.user }">
	
<div class="container">	
<u:profile/>
	<div class="row" style="padding: 0% 3% 0% 4%">	
	<div class="col-3"><h3>게시판</h3></div>	
	<table id="table col-10" class="table mt-3">
	<thead class="thead-light">
	<tr>
		<th scope="col">번호</th>
		<th scope="col">작성자</th>
		<th scope="col">제목</th>
		<th scope="col">작성일</th>
		<th scope="col">조회수</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="article" items="${articlePage.content }">
		<tr>
			<th scope="row">${article.article_no }</th>
			<td>${article.writer.id }</td>
			<td>
			<a href="${root }/article/read.do?no=${article.article_no }&pageNo=${articlePage.currentPage }">
			<c:out value="${article.title }"/> 
			</a>
			</td>
			<td>${article.regdate }</td>
			<td>${article.read_cnt }</td>
		</tr>	
	</c:forEach>
	</tbody>
	<tr>
		<td>
		<a href="write.do">글 작성</a>
		</td>
	</tr>	
</table>
</div>	
</div>
	
<div class="page">
<nav aria-label="Page navigation example" style="padding: 0% 0% 0% 45%" > 
  <ul class="pagination">
    	<c:if test="${articlePage.startPage > 5 }">
    		<li class="page-item">
      			<a class="page-link" href="${articlePage.startPage > 5}" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
      			</a>
    		</li>
    	</c:if>
    
    	<c:forEach begin="${articlePage.startPage }" end="${articlePage.endPage }" var="pNo">
    		<li class="page-item"><a class="page-link" href="${root }/article/list.do?pageNo=${pNo }">${pNo }</a></li>
    	</c:forEach>
   
   		<c:if test="${articlePage.endPage < articlePage.totalPages }">
    		<li class="page-item">
      			<a class="page-link" href="${articlePage.endPage < articlePage.totalPages }" aria-label="Next">
        			<span aria-hidden="true">&raquo;</span>
     		    </a>
   		    </li>
   		</c:if>
  </ul>
</nav>
</div>
</c:if>

	
<c:if test="${empty sessionScope.user }"> 
<div class="conatiner">
<div class="row" style="padding: 0% 25% 0% 25%">
<table id="table" class="table mt-5">
	<thead class="thead-light">
	<tr>
		<th scope="col">번호</th>
		<th scope="col">작성자</th>
		<th scope="col">제목</th>
		<th scope="col">작성일</th>
		<th scope="col">조회수</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="article" items="${articlePage.content }">
		<tr>
			<th scope="row">${article.article_no }</th>
			<td>${article.writer.id }</td>
			<td>
			<a href="${root }/article/read.do?no=${article.article_no }&pageNo=${articlePage.currentPage }">
			<c:out value="${article.title }"/> 
			</a>
			</td>
			<td>${article.regdate }</td>
			<td>${article.read_cnt }</td>
		</tr>	
	</c:forEach>
	</tbody>
</table>
</div>
</div>
<div class="page">
<nav aria-label="Page navigation example" style="padding: 0% 0% 0% 45%" > 
  <ul class="pagination">
    	<c:if test="${articlePage.startPage > 5 }">
    		<li class="page-item">
      			<a class="page-link" href="${articlePage.startPage > 5}" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
      			</a>
    		</li>
    	</c:if>
    
    	<c:forEach begin="${articlePage.startPage }" end="${articlePage.endPage }" var="pNo">
    		<li class="page-item"><a class="page-link" href="${root }/article/list.do?pageNo=${pNo }">${pNo }</a></li>
    	</c:forEach>
   
   		<c:if test="${articlePage.endPage < articlePage.totalPages }">
    		<li class="page-item">
      			<a class="page-link" href="${articlePage.endPage < articlePage.totalPages }" aria-label="Next">
        			<span aria-hidden="true">&raquo;</span>
     		    </a>
   		    </li>
   		</c:if>
  </ul>
</nav>
</div>
</c:if>



		
	



</body>
</html>