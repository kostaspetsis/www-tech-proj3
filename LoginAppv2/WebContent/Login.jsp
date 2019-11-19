<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginApp</title>
</head>
<body>
	<h1 style="background-color:#0000ff;">Login Page</h1>
	<form method="post" action="Login">
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
				<td><a href="Register.jsp"><input type="button" value="Register"></a></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
	
	<h1>JPA login</h1>
	<form method="post" action="Jpa_Login">
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
				<td><a href="Register.jsp"><input type="button" value="Register"></a></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</body>
</html>