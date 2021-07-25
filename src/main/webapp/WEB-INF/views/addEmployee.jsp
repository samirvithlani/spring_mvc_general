<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.table, th, td {
	border: 1px solid black;
}

.error {
	color: red
}
</style>
</head>
<body>
	<form:form method="post" modelAttribute="employeeBean"
		action="insertemployee">
		<table class="table">
			<tr>
				<td>EMPLOYEE NAME</td>
				<td><form:input path="employeeName" /> <form:errors
						path="employeeName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>EMPLOYEE AGE</td>
				<td><form:input path="eAge" /> <form:errors path="eAge"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>EMPLOYEE PASSWORD</td>
				<td><form:input path="ePassword" /> <form:errors path="ePassword"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td>EMPLOYEE EMAIL</td>
				<td><form:input path="eEmail" /> <form:errors path="eEmail"
						cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>

	</form:form>
</body>
</html>