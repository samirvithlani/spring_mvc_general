<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>EMPLOYEE NAME</th>
			<th>EMPLOYEE AGE</th>
		</tr>
		<tr>
			<c:forEach var="list" items="${emplist}">

				<td>${list.employeeName }</td>
				<td>${list.eAge }</td>
				<td><a href="./deleteemployee/ename=${list.employeeName }">DELETE</a></td>

			</c:forEach>
		</tr>

	</table>
</body>
</html>