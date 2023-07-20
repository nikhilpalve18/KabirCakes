<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register here</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/register.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<body>
	<section class="hero">
		<div class="navbar">
			<div class="nav-container">
				<div class="logo">
					<img src="./images/logo.png" alt="logo" loading="lazy" />
				</div>
				<div id="menuToggle">
					<input type="checkbox" /> <span id="span1"></span> <span
						id="span2"></span> <span id="span3"></span>
				</div>
				<div class="navbar-links">
					<ul>
						<li><a href="homeWithoutLogin.jsp">Home</a></li>
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
			<div class="title">Register Here</div>
			<div class="content">
				<form action="Register" method="post">
					<%
					String regStatus = (String) request.getAttribute("status");
					request.removeAttribute("status");
					if (regStatus != null) {
					%>
					<strong style="font-size: large"><%=regStatus%></strong>
					<%
					regStatus = null;
					}
					%>
					<%
					// to display whether the registeration is successful or not
					String registerMessage = (String) session.getAttribute("registerMessage");
					if (registerMessage != null) {
					%>
					<strong style="margin-top: 5px; font-size: large; color: green"><%=registerMessage%></strong>
					<%
					session.removeAttribute("registerMessage");
					}
					%>
					<div class="user-details">
						<div class="input-box">
							<span class="details">Full Name</span> <input type="text"
								name="uname" placeholder="Enter your name" required />
						</div>
						<div class="input-box">
							<span class="details">Security question</span> <select
								name="securityQuestion"
								style="padding: 10px; background: #edf2ff; border: none;">
								<option value="What is your best friends name">What is
									your best friends name</option>
								<option value="Which is your favourite car">Which is
									your favourite car</option>
								<option value="Which is your birth city">Which is your
									birth city</option>
							</select>
						</div>
						<div class="input-box">
							<span class="details">Phone Number</span> <input type="text"
								name="mobileNumber" placeholder="Enter your number" required />
						</div>
						<div class="input-box">
							<span class="details">Answer</span> <input type="text"
								name="answer" placeholder="Your Answer.." required />
						</div>
						<div class="input-box">
							<span class="details">Email</span> <input type="text"
								name="uemail" placeholder="Enter your email" required />
						</div>
						<div class="input-box">
							<span class="details">Password</span> <input type="password"
								name="pass" placeholder="password" required />
						</div>
					</div>
					<input type="submit" value="Register"
						style="background-color: #f5ce62; margin-left: 75%; margin-bottom: 1%; border: 2px solid var(- -primary-color); background-color: var(- -primary-color); cursor: pointer; padding: 1rem 2rem; width: 16%;">
					<a href="login.jsp"
						style="color: white; font-size: 145%; margin-left: 70%; margin-top: 2%;">Already
						have an account ?</a>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
