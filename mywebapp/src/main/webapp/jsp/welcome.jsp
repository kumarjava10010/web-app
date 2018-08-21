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
	<form:form id="welcomeForm" modelAttribute="customer" method="post">

		<table border=0 width="500px" align="center"
			style="background-color: ffeeff;">

			<tr>
				<td style="font-weight: bold; font-size: 20pt;" align="center">Welcome
					<%-- <%=request.getSession().getAttribute("LoggedInUser") %></td> --%>
					${customer.firstname} <form:hidden path="acctNo" />
				</td>
			</tr>
			<tr>
				<td><a href="home.jsp">Home</a></td>
			</tr>

			<tr>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><a href="getCustomerDetails/${customer.acctNo}">Update
						profile</a></td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><a href="cash.jsp">Account Summary</a></td>
			</tr>
			<tr>
				<td align="right">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><a href="cash.jsp">Deposit/Withdraw</a></td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
			</tr>
			<tr>
				<td align="center"><a href="transaction">View Transaction</a></td>
			</tr>
			<tr>
				<td align="center">&nbsp;</td>
			</tr>

		</table>
	</form:form>
</body>
</html>


