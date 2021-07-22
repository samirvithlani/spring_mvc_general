<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="employeeBean" action="insertemployee">
		<table>
			<tr>
				<td>EMPLOYEE NAME</td>
				<td><form:input path="employeeName" /></td>
			</tr>
			<tr>
				<td>EMPLOYEE AGE</td>
				<td><form:input path="eAge" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>

	</form:form>
</body>
</html>