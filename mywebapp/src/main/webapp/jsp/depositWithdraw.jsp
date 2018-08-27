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
	<form:form id="depostForm" modelAttribute="acctInfo"
		action="depositWithdraw" method="post">

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
				<td>${acctInfo.acctNumber} <form:hidden path="acctNumber" /></td>
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

		<table width="500px" border=0 align="center"
			style="background-color: ffeeff;">


			<tr>
				<td colspan=2 style="font-weight: bold; font-size: 20pt;"
					align="center">Deposit/ Withdraw</td>

			</tr>
			<tr>
				<td colspan=2>&nbsp;</td>

			</tr>
			<tr>
				<td>Transaction Amount</td>
				<td><form:input path="transactionAmount"
						name="transactionAmount" id="transactionAmount" /></td>
			</tr>

			<tr>
				<td>Transaction Type</td>
				<td><form:select path="transactionType">
						<form:option value="NONE" label="--- Select ---" />
						<form:option value="deposit" label="Deposit" />
						<form:option value="withdraw" label="Withdraw" />
					</form:select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" name="Submit" value="Complete"></td>
			</tr>

			<!-- <tr>
				<td></td>
				<td><a href="registerSuccess.jsp">Save</a></td>
			</tr> -->

		</table>
	</form:form>
</body>
</html>


