<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container mb-5">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="${root }/index.jsp">YURA</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
   	 <div class="navbar-nav">
        <a class="nav-link" href="${root }/index.jsp"><i class="fas fa-home"></i> Home <span class="sr-only">(current)</span></a>
     
        <a class="nav-link" href="${root }/article/list.do"><i class="fas fa-list"></i> 게시판</a>
   	</div>
  </div>
</nav>
</div>