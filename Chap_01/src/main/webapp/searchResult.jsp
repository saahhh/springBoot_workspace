<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.kh.model.vo.DTO" %>
<%@ page import="java.util.List" %>
<%
	List<DTO> userList = (List<DTO>) request.getAttribute("userList");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>searchResult �˻����</title>
	</head>
	<body>
		<h3>��ȸ ���</h3>
		<table border="1">
			<thead>
				<tr>
					<th>����� ��ȣ</th>
					<th>����� ���̵�</th>
					<th>����� �̸�</th>
					<th>����� ����</th>
				</tr>
			</thead>
			<tbody>
				<%
					//��ȸ�� ����� ������ ��ü ���
					for(DTO user : userList){
				%>
				<tr>
					<td><%=user.getUser_number() %></td>
					<td><%=user.getUser_id() %></td>
					<td><%=user.getUser_name() %></td>
					<td><%=user.getUser_age() %></td>
				</tr>
				<% 
					}
				%>
			</tbody>
		
		</table>
		
		<button type="submit" onclick="location.href='index.jsp'">���ư���</button>	
	
	</body>
</html>