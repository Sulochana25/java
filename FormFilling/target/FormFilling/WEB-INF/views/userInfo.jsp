<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>

<body>
	<h2>Submitted user Information</h2>
	<table>
		<tr>
			<td>Name</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>email</td>
			<td>${user.email}</td>
		</tr>
		<tr>
			<td>phone</td>
			<td>${user.phone}</td>
		</tr>
		<tr>
			<td>Gender</td>
			<td>${user.gender}</td>
		</tr>
		<tr>
			<td>country</td>
			<td>${user.country}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${user.address}</td>
		</tr>
		<tr>
			<td>languages</td>
			<td>
				<c:forEach items="${user.languages}" var="lang">
						[<c:out value="${lang}" />]
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>password</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>photo :</td>
			<td>
				 ${user.photo.originalFilename}
            </td>
		</tr>
		<tr>
			<td>Resume:</td>
			<td>${user.resume.originalFilename}</td>
		</tr>
	</table>
</body>

</html>