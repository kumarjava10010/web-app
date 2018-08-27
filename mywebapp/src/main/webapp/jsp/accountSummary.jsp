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
	<form:form id="accountSummaryForm" modelAttribute="acctInfo"
		method="post">
		<table width="500px" border=0 align="center"
			style="background-color: ffeeff;">


			<tr>
				<td colspan=2 style="font-weight: bold; font-size: 20pt;"
					align="center">Account Summary</td>

			</tr>
			<tr>
				<td colspan=2>&nbsp;</td>

			</tr>
			<tr>
				<td>Account Number</td>
				<td>${acctInfo.acctNumber}</td>
			</tr>

			<tr>
				<td>Account Type</td>
				<td>${acctInfo.acctType}</td>
			</tr>
			<tr>
				<td>Balance</td>
				<td>${acctInfo.balance}</td>
			</tr>
			<tr>
				<td>Last Updated By</td>
				<td>${acctInfo.lastupdatedby}</td>
			</tr>
			<tr>
				<td>Last Updated Date</td>
				<td>${acctInfo.lastupdateddate}</td>
			</tr>


		</table>
	</form:form>
</body>
</html>


