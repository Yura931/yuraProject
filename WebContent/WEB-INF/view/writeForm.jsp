<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<form action="write.do" method="post">
		<p>
		제목 <br />
		<input type="text" name="title"/>
		</p>
		
		<p>
		내용 <br />
		<textarea name="content" id="" cols="30" rows="10"></textarea>
		</p>
		
		<input type="submit" value="작성" />
	</form>
</div>
</body>
</html>