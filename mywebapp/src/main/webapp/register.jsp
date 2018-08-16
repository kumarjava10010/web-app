<html>
<head>
<script src="valid.js" type="text/javascript"></script>
</head>

<body>
	<br>
	<form method="post" onsubmit="registerSuccess.jsp">
		<table width="350px" border=0 align="center"
			style="background-color: ffeeff;">


			<tr>
				<td colspan=2 style="font-weight: bold; font-size: 20pt;"
					align="center">User Registeration</td>

			</tr>
			<tr>
				<td colspan=2>&nbsp;</td>

			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname"></td>
			</tr>
			<tr>

				<td>Login Name</td>

				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword" value=""></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email""></td>
			</tr>
			<tr>
				<td>SSN</td>
				<td><input type="text" name="ssn"></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><textarea name="address" rows=5 cols=25></textarea></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city""></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state"></td>
			</tr>
			<tr>
				<td>Zip COde</td>
				<td><input type="text" name="zip"></td>
			</tr>
			<!-- <tr>
				<td></td>
				<td><input type="submit" name="Submit" value="Save User"></td>
			</tr> -->
			
			<tr>
				<td></td>
				<td><a href="registerSuccess.jsp">Save</a></td>
			</tr>
			
		</table>
	</form>
</body>
</html>


