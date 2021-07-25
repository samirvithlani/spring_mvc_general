<%@page import="com.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.table, th, td {
	border: 1px solid black;
}
</style>

</head>
<body>
<%EmployeeBean employeeBean = (EmployeeBean)session.getAttribute("employeeBean"); 
%>
<h1>Logged in employee <%=employeeBean.getEmployeeName() %></h1>
	<table class="table">
		<tr>
			<th>EMPLOYEE Id</th>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE AGE</th>
			<th>EMPLOYEE Email</th>
		</tr>
		

		<c:forEach var="list" items="${emplist}">
			<tr>
				<td>${list.eId }</td>
				<td>${list.employeeName }</td>
				<td>${list.eAge }</td>
				<td>${list.eEmail }</td>
				<td><a href="./deleteemployee/${list.eId }">DELETE</a></td>
				<td><a href="./editemployee/${list.eId }">UPDATE</a></td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>