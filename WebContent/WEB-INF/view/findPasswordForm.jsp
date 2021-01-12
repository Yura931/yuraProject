<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${root }/css/findPwd.css" />
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
	<div class="inner_findPwd">
    <div class="findPwd_tistory">
        <form method="post" id="authForm" action="${root }/findPwd.do">
            <input type="hidden" name="redirectUrl" value="https://blogpack.tistory.com/manage">
            <fieldset>
             <legend class="screen_out">로그인 정보 입력폼</legend>        
            <div class="box_find">
                <div class="inp_text">
                <label for="findName" class="screen_out">ID</label>
                <input type="text" id="findName" name="id" placeholder="ID"   >
                </div>
                <div class="inp_text">
                <label for="findEmail" class="screen_out">name</label>
                <input type="name" id="findEmail" name="name" placeholder="name" >
                </div>
                <div class="inp_text">
                <label for="findEmail" class="screen_out">email</label>
                <input type="email" id="findEmail" name="email" placeholder="email" >
                </div>
            </div>
            <button type="submit" class="btn_find" value="button">비밀번호 찾기</button>
            </fieldset>
              </form>   
    </div>
</div>
</body>
</html>