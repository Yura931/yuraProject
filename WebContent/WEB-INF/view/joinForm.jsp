<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${root }/css/join.css" />
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


<div class="inner_join">
	 <div class="login_tistory">
    <h2>회원가입</h2>
    <form action="${root }/join.do" method="post">  	
        <table>
            <tr>     
                <th>아이디</th>
                <td><input type="text" class="form-control" name="id" >
                <c:if test="${errors.id }">
                	<small>ID를 입력하세요.</small>
                </c:if>      
                <c:if test="${errors.duplicated }">
            		<small>이미 사용중인 아이디입니다.</small>
          		</c:if>  
                </td>
            </tr>
            
             <tr>
                <th>이름</th>
                <td><input type="text" class="form-control" name="name" >
                <c:if test="${errors.name }">
            		<small>
              			이름을 입력하세요. 
            		</small>  
            	</c:if>                
            	</td>
                   
            </tr>
            <tr>
                <th>패스워드</th>
                <td><input type="password" class="form-control" name="password">
                	 <c:if test="${errors.password }">
            			<small class="form-text text-muted">
              				암호를 입력하세요.
            			</small>
          			</c:if>
                </td>      
            </tr>
             
            <tr>
                <th>패스워드확인</th>
                <td><input type="password" class="form-control" name="confirmPassword">
                	<c:if test="${errors.confirmPassword }">
                		<small class="form-text text-muted">
                			확인을 입력하세요.
                		</small>
                	</c:if>
                	<c:if test="${errors.notMatch }">
                		<small class="form-text text-muted">
                			암호와 확인이 일치하지 않습니다.
                		</small>
                	</c:if>
                </td>        
            </tr>
             
            <tr>
                <th>이메일</th>
                <td><input type="text" class="form-control" name="email">
                	<c:if test="${errors.email }">
                		<small class="form-text text-muted">
                			이메일을 입력하세요.
                		</small>       
                	</c:if>
                </td>       
            </tr>
             
             <tr>
                <th>생일</th>
                <td><input type="date" class="form-control" name="birth">
               	    <c:if test="${errors.birth }">
                		<small class="form-text text-muted">
                			생일을 입력하세요.
                		</small>       
                	</c:if>
                </td>       
            </tr>
                   
            <tr>
                <td colspan="2">
                <input type="submit" class="btn_login" value="회원가입">
                <input type="button" class="btn_reset" value="취소" onclick="javascript:history.back()">
                </td>
            </tr>                                                            
        </table>
    </form>
    </div>
  </div>  

</body>
</html>