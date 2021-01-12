<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${root }/css/page.css" />
<ul class="pagination">
	<c:if test="${articlePage.startPage > 5}">
		<li><a href="${root }/article/list.do?pageNo=${articlePage.startPage - 5 }" class="prev"><i class="fas fa-angle-left"></i></a></li>
	</c:if>
	
	<c:forEach begin="${articlePage.startPage }" end="${articlePage.endPage }" var="pNo">
	<li><a  class="num" href="${root }/article/list.do?pageNo=${pNo }">${pNo }</a></li>
	</c:forEach>
	
	<c:if test="${articlePage.endPage < articlePage.totalPages }">
		<li><a href="${articlePage.endPage < articlePage.totalPages }" class="next"><i class="fas fa-angle-left"></i> </a></li>
	</c:if>
</ul>