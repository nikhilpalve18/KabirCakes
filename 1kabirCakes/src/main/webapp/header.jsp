<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="header.css" />
<title>kabirCakes</title>
</head>
<body>
	<%
	String email;
	String shortenEmail;
	if (session.getAttribute("email") == null) {
		email = (String) session.getAttribute("email");
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="container">
		<div class="navbar">
			<div id="kabirCakesLogo">
				<img src="./images/logo.png" style="height:70px; width:70px margin-right:300px" alt="kabirCakesLogo" />
			</div>

			<ul>
				<li class="navLinks" ><a href="#" style="color:#fba800;">Welcome ${email}</a></li>
				<li class="navLinks"><a href="#">Home</a></li>
				<li class="navLinks"><a href="getProducts?msg=${email}">Cakes</a></li>
				<li class="navLinks"><a href="#">Mini Bites</a></li>
				<li class="navLinks"><a href="#">About Us</a></li>
				<li class="navLinks"><a href="getCart?msg=${email}">MyCart</a></li>
				<li class="navLinks"><a href="#">Contact Us</a></li>
				<li>
					<form action="logout">
						<input type="submit" value="logout">
					</form>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
