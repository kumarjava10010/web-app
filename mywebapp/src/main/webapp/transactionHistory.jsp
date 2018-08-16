<%@  page language="java" import="java.util.ArrayList"%>
<%@ page import="com.bank.persistance.model.TransactionHistory"%>

<html>
<head>
</head>
<body>

	<br>
	<br>
	Welcome
				<%-- <%=request.getSession().getAttribute("LoggedInUser") %></td> --%>
				<%=request.getAttribute("LoggedInUser") %>
	
	<br>
	<table width="700px" align="center" style="border: 1px solid #000000;">
		<tr>
			<td colspan=8 align="center" style="background-color: ffeeff"><b>Transaction
					Report</b></td>
		</tr>
		<tr style="background-color: efefef;">
			<td><b>SNo</b></td>
			<td><b>Transaction ID</b></td>
			<td><b>Balance</b></td>
			<td><b>Acct Number</b></td>
		</tr>

		<%
			ArrayList transactionList = (ArrayList) request.getAttribute("tranHistoryList");
			for (int i = 0; i < transactionList.size(); i++) {
				TransactionHistory transaction = (TransactionHistory) transactionList.get(i);
		%>
		<tr>
			<td><%=transaction.transactionId%></td>
			<td><%=transaction.acctNo%></td>
			<td><%=transaction.newBalance%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>
