<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
</style>
</head>
<body>
	<form:form method="post" modelAttribute="employeeBean"
		action="../updateemployee">
		<form:hidden path="eId" value ="${employeeBean.eId }"/>
		<table class="table">
			<tr>
				<td>EMPLOYEE NAME</td>
				<td><form:input path="employeeName"
						value="${employeeBean.employeeName }" /></td>
			</tr>
			<tr>
				<td>EMPLOYEE AGE</td>
				<td><form:input path="eAge" value="${employeeBean.eAge }" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>

	</form:form>
</body>
</html>