<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
margin-top: 10px;
width: 60px;
height: 35px;
font-size: 15px;
background: rgb(226, 226, 226);
text-align: center;
}

h3 {
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
	<div class="col-3 mb-2 pl-0"><h3>게시글 작성</h3></div>
       <form action="write.do" method="post">
            <table class="table mt-3"> 
                <tr>
                    <th>제목</th>
                    <td><input class="con" type="text" name="title"></td>
                </tr> 
                <tr>
                    <th>내용</th>
                    <td><textarea class="con" cols="100" rows="10" name="content"></textarea></td>
                </tr>
            </table>
                
            <input class="btn" type="submit" value="등록">
            <input class="btn" type="button" value="취소" onclick="javascript:history.back()">               
        </form>
        </div>	
	</div>
	

      
	

  
</body>
</html>
<%--
<div class="container">
	
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
 --%>