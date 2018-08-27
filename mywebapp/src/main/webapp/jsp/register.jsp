<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>

</head>

<body>
	<br>
	<form:form id="customerForm" modelAttribute="customerObject"
		action="customerSave" method="post">
		<table width="500px" border=0 align="center"
			style="background-color: ffeeff;">


			<tr>
				<td colspan=2 style="font-weight: bold; font-size: 20pt;"
					align="center">Customer Registration</td>

			</tr>
			<tr>
				<td colspan=2>&nbsp;</td>

			</tr>
			<tr>
				<td>Account Number</td>
				<td><form:input path="acctNo" name="acctNo" id="acctNo" /></td>
			</tr>

			<tr>
				<td>First Name</td>
				<td><form:input path="firstName" name="firstName"
						id="firstName" /></td>
				<td align="left"><form:errors path="firstName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><form:input path="lastName" name="lastName" id="lastName" /></td>
				<td align="left"><form:errors path="lastName" cssClass="error" /></td>

			</tr>
			<tr>

				<td>Login Name</td>

				<td><form:input path="username" name="username" id="username" /></td>
				<td align="left"><form:errors path="username" cssClass="error" /></td>

			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="password" name="password"
						id="password" /></td>
				<td align="left"><form:errors path="password" cssClass="error" /></td>

			</tr>
			<tr>
				<td>SSN</td>
				<td><form:input path="ssn" name="ssn" id="ssn" /></td>
				<td align="left"><form:errors path="ssn" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><form:input path="address" name="address" id="address" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><form:input path="city" name="city" id="city" /></td>
			</tr>
			<tr>
				<td>State</td>
				<td><form:input path="state" name="state" id="state" /></td>
			</tr>
			<tr>
				<td>Zip COde</td>
				<td><form:input path="zipCode" name="zipCode" id="zipCode" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="Save User"></td>
			</tr>

			<!-- <tr>
				<td></td>
				<td><a href="registerSuccess.jsp">Save</a></td>
			</tr> -->

		</table>
	</form:form>
</body>
</html>


