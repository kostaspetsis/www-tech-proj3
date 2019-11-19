<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginApp-Register</title>
</head>
<body>
	<h1 style="background-color:#ff5500;">Registration Page</h1>
	<form method="post" action="Register">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" placeholder="Username" autofocus="on"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" placeholder="Password" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register Account"></td>
			</tr>
		</table>
	</form>
	
	<h1>JPA Register</h1>
	<form method="post" action="Jpa_Register">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" placeholder="Username" autofocus="on"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" placeholder="Password" ></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register Account"></td>
			</tr>
		</table>
	</form>
</body>
</html>