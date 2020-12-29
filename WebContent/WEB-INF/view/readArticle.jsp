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
<div class="container">
	제목 <br />
	<input type="text" value="${articleData.article.title }" readonly/>
	<br />
	<textarea name="body" id="" cols="30" rows="10" readonly>${articleData.article.content }</textarea>
	
</div>

<a href="${root }/article/list.do">목록</a>

	<c:if test="${user.id == articleData.article.writer.id }">
		<a href="${root }/article/modify.do?no=${articleData.article.article_no }">수정</a>
		<a href="${root }/article/delete.do?no=${articleData.article.article_no }">삭제</a>
	</c:if>

<form action="${root }/reply/reply.do" method="post">
	<input type="number" value="${articleData.article.article_no }" name="no" hidden/>
	<input type="number" value="${param.pageNo }" name="pageNo" hidden />
	<input type="text" name="body" />
	<input type="submit" value="등록" />
</form>

	<table>
<c:forEach var="replyList" items="${replyList.reply }">
		<tr>
			<td>${replyList.replyId }</td>
			<td>${replyList.memberId }</td>
			<td>${replyList.body }</td>
			<td>${replyList.regData }</td>
		</tr>
</c:forEach>
	</table>
	
<div class="mt-5 pagenation-container d-flex justify-content-center">
          <nav aria-label="Page navigation example">
            <ul class="pagination">
              <c:if test="${replyList.startPage > 5}">
                <li class="page-item"><a class="page-link" href="${root }/reply/reply.do?pageNo=${articlePage.startPage - 5 }">Previous</a></li>
              </c:if>
              
              <c:forEach begin="${replyList.startPage }" end="${replyList.endPage }" var="pNo">
                <li class="page-item"><a class="page-link" href="${root }/reply/reply.do?pageNo=${pNo}">${pNo }</a></li>
              
              </c:forEach>
              <c:if test="${replyList.endPage < replyList.totalPages }">
                <li class="page-item"><a class="page-link" href="${root }/reply/reply.do?pageNo=${articlePage.startPage + 5 }">Next</a></li>
              </c:if>
            </ul>
          </nav>
        </div>
		

</body>
</html>




