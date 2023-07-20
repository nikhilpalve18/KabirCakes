<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login here</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/login.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<body>
	<section class="hero">
		<div class="navbar">
			<div class="nav-container">
				<div class="logo">
					<img src="./images/logo.png" alt="logo" loading="lazy"
						style="height: 8rem; position: relative left:50px">
				</div>
				<div id="menuToggle">
					<input type="checkbox" /> <span id="span1"></span> <span
						id="span2"></span> <span id="span3"></span>
				</div>
				<div class="navbar-links">
					<ul>
						<li class="navLinks"><a href="homeWithoutLogin.jsp">Home</a></li>
						<li class="navLinks"><a
							href="getProducts?msg=${email}&category=cakes">Cakes</a></li>
						<li class="navLinks"><a
							href="getProducts?msg=${email}&category=minibites">Mini Bites</a></li>
						<li class="navLinks"><a href="About-Us.jsp">About Us</a></li>
						<li class="navLinks"><a href="Contact-Us.jsp">Contact Us</a></li>
					</ul>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="title" style="color: white;">Login Here..</div>
			<div class="content">
				<form action="login" method="post">
					<%
					String msg = (String) session.getAttribute("message");
					if (msg != null) {
						out.println(msg);
						session.removeAttribute("message");
					}

					msg = (String) session.getAttribute("resetpassmsg");
					if (msg != null) {
						out.println(msg);
						session.removeAttribute("resetpassmsg");
					}
					%>
					<div class="user-details">
						<div class="input-box">
							<span class="details" style="color: white;">Email</span> <input
								name="email" type="text" placeholder="Enter your email" required />
						</div>
						<div class="input-box">
							<span class="details" style="color: white;">Password</span> <input
								name="pass" type="password" placeholder="password" required />
						</div>
						<div class="Forgot Password" style="margin-left: 79.2%;">
							<a href="forgotpassword.jsp" style="color: rgb(199, 214, 225);">Forgot
								Password ?</a>
							<a href="register.jsp" style="color: rgb(199, 214, 225);">Sign up ?</a>
						</div>
						<input type="submit" value="Login"
							style="background-color: #f5ce62; margin-left: 80%; margin-top: 1%; background-color: var(- -primary-color); cursor: pointer; padding: 1rem 2rem; width: 20%;">
					</div>
				</form>
			</div>
		</div>
	</section>
</body>
</html>

