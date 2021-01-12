<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<link rel="stylesheet" href="${root }/css/profile.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
		<div class="container">
		<div class="profile-card">
			<div class="card-header">
				<div class="pic">
					<img src="${root }/image/profile.png"/>
				</div>
			</div>
			<div class="card-footer">
				<div class="name">${sessionScope.user.name }</div>
				<div class="name">(${sessionScope.user.id })</div>
				<div class="modify">
					<a href="${root }/info.do" class="infoModify">정보</a> 
					<a href="${root }/logout.do" class="logout">로그아웃</a>
				</div>
			</div>
		</div>
		</div>
		
		

	
		
	
