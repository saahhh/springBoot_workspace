<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>���� ��ȸ</title>
	</head>
	<body>
		<!-- 
		
		<h3>����� ��ü ��ȸ</h3>
		<!-- ��������� �Է¹��� ���� action�� ���� ���� --		
		<form action="selectUser" method="post">
	
			<label for="user_id">����� ID : </label>
			<input type="text" name="user_id" required/>
	
			<button type="submit" onclick="location.href='searchResult.jsp'">��ȸ</button>
		</form>
		
		 -->
	
		<h3>����� �Ѹ� ��ȸ</h3>		
		<form action="selectUser" method="get">
	
			<label for="user_id">����� ID : </label>
			<input type="text" name="user_id" required/>
	
			<button type="submit" onclick="location.href='searchResult.jsp'">��ȸ</button>
			
		</form>
		
	</body>
</html>