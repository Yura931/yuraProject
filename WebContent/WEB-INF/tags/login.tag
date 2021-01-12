<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="${root }/css/login.css" />
<div class="inner_login">
	<div class="login_tistory">
		<form method="post" id="authForm" action="${root }/login.do">
			<input type="hidden" name="redirectUrl"
				value="https://blogpack.tistory.com/manage">
			<fieldset>
				<legend class="screen_out">로그인 정보 입력폼</legend>
				<div class="box_login">
					<div class="inp_text">
						<label for="loginId" class="screen_out">아이디</label> <input
							type="text" id="loginId" name="id" placeholder="ID">
						<c:if test="${errors.id }">
                		ID를 입력해주세요.
                	 	</c:if>
						<c:if test="${errors.infoNotMatch }">
                		잘못된 정보입니다.
                		</c:if>
					</div>
					<div class="inp_text">
						<label for="loginPw" class="screen_out">비밀번호</label> <input
							type="password" id="loginPw" name="password"
							placeholder="Password">
						<c:if test="${errors.password }">
                			PASSWORD를 입력해주세요.
                		</c:if>
						<c:if test="${errors.infoNotMatch }">
                			잘못된 정보입니다.
                		</c:if>
					</div>
				</div>
				<button type="submit" class="btn_login" value="button">로그인</button>
				<div class="login_append">
					<span class="txt_join"> <a href="${root }/join.do"
						class="link_find">회원가입</a>
					</span> <span class="txt_find"> <a href="${root }/findId.do"
						class="link_find">아이디</a> / <a href="${root }/findPwd.do"
						class="link_find">비밀번호 찾기</a>
					</span>
				</div>

			</fieldset>
		</form>

	</div>
</div>


