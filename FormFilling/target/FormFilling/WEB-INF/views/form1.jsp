<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
<body>
	<h2>User Information</h2>
	<form:form method="POST" action="/FormFilling/formPage1"
		modelAttribute="user">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="email">email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="phone">phone</form:label></td>
				<td><form:input path="phone" /></td>
				<td><form:errors path="phone" cssClass="error" /></td>
			</tr>
			<tr>
				<td>gender :</td>
				<td><form:radiobutton path="gender" value="Male" />Male <form:radiobutton
						path="gender" value="Female" />Female</td>
				<td><form:errors path="gender" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:select path="country">
						<form:option value="NONE">Select</form:option>
						<form:option value="US">United States</form:option>
						<form:option value="India">India</form:option>
						<form:option value="china">china</form:option>
                        <form:option value="UK">UK</form:option>
					</form:select></td>
				<td><form:errors path="country" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="next" /></td>
				<td colspan="2"><input type="reset" value="cancel" /></td>
			</tr>
		</table>
	</form:form>
</body>

</html>