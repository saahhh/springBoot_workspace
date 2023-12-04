<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>유저 조회</title>
	</head>
	<body>
		<!-- 
		
		<h3>사용자 전체 조회</h3>
		<!-- 사용자한테 입력받은 폼은 action을 통해 전달 --		
		<form action="selectUser" method="post">
	
			<label for="user_id">사용자 ID : </label>
			<input type="text" name="user_id" required/>
	
			<button type="submit" onclick="location.href='searchResult.jsp'">조회</button>
		</form>
		
		 -->
	
		<h3>사용자 한명 조회</h3>		
		<form action="selectUser" method="get">
	
			<label for="user_id">사용자 ID : </label>
			<input type="text" name="user_id" required/>
	
			<button type="submit" onclick="location.href='searchResult.jsp'">조회</button>
			
		</form>
		
	</body>
</html>