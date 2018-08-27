<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<style>
A:hover {
	text-decoration: none;
	font-family: arial;
	font-size: 14px;
	color: #000000;
	BORDER: none;
}

A {
	text-decoration: underline;
	font-family: arial;
	font-size: 14px;
	color: #000000;
	BORDER: none;
}
</style>
</head>
<body>
	<br>
	<br>
	<br>
	<form:form id="welcomeForm" modelAttribute="customer" action = "customerAction" method="post">

		<table border=0 width="500px" align="center"
			style="background-color: ffeeff;">

			<tr>
				<td style="font-weight: bold; font-size: 20pt;" align="center">Welcome
					<%-- <%=request.getSession().getAttribute("LoggedInUser") %></td> --%>
					${customer.firstName} <form:hidden path="acctNo" />
				</td>
			</tr>
			<tr>
				<!-- <td><a href="home.jsp">Home</a></td> -->
				<td align="center"><input type="submit" name="home"
					value="Home" /></td>
			</tr>

			<tr>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="updateProfile"
					value="Update profile" /></td>

			</tr>
			<tr>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>

				<td align="center"><input type="submit" name="accountSummary"
					value="Account Summary" /></td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="deposit"
					value="Deposit/Withdraw" /></td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" name="transaction"
					value="View Transaction" /></td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
			</tr>

		</table>
	</form:form>
</body>
</html>


