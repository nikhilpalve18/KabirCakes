<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<meta charset="ISO-8859-1">

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>kabir Cakes</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/Contact-Us.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<body>
	<div class="navbar">
		<div class="nav-container">
			<div class="logo">
				<img src="./images/logo.png" alt="logo" loading="lazy" />
			</div>
			<div id="menuToggle">
				<input type="checkbox" /> <span id="span1"></span> <span id="span2"></span>
				<span id="span3"></span>
			</div>
			<div class="navbar-links">
				<ul>
					<li class="navLinks"><a href="#" style="color: #fba800;">Welcome
							${email}</a></li>
					<li class="navLinks"><a href="#">Home</a></li>
					<li class="navLinks"><a
						href="getProducts?msg=${email}&category=cakes">Cakes</a></li>
					<li class="navLinks"><a
						href="getProducts?msg=${email}&category=minibites">Mini Bites</a></li>
					<li class="navLinks"><a href="About-Us.jsp">About Us</a></li>
					<li class="navLinks"><a href="getCart?msg=${email}">MyCart</a></li>
					<li class="navLinks"><a href="#">Contact Us</a></li>
					<li>
						<form action="logout">
							<button class="btn"border-radius:10px;">
								<span>LogOut</span></a>
							</button>
						</form>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<section class="contact" id="contact">
		<div class="heading">
			<h2>Contact Us</h2>
		</div>
		<div class="Contact-container">
			<div class="contactInfo">
				<div class="box">
					<div class="icon">
						<img src="./svgs/Phone.svg" alt="contact info" loading="lazy" />
					</div>
					<div class="text">
						<p>9765597034</p>
						<p>kabircakes@gmail.com</p>
					</div>
				</div>
				<div class="box">
					<div class="icon">
						<img src="./svgs/location.svg" alt="address" loading="lazy" />
					</div>
					<div class="text">
						<p>Aishwarya Nagari,
						<p>Shriram Chowk,</p>
						<p>Ahmednagar.414003</p>
						</p>
					</div>
				</div>
				<div class="box">
					<div class="icon">
						<img src="./svgs/clock.svg" alt="timing" loading="lazy" />
					</div>
					<div class="text">
						<p>Mon to Fri: 8am to 6pm</p>
						<p>Sat to Sun: 8am to 1pm</p>
					</div>
				</div>
			</div>
			<div class="contactForm">
				<%
				String msg = (String) session.getAttribute("message");
				if (msg != null) {
					out.println(msg);
					session.removeAttribute("message");
				}
				%>
				<form action="contactUs" method="post">
					<h2>Send Message</h2>
					<div class="inputBox">
						<input type="text" name="fullName" required="required" /> <span>Full
							Name</span>
					</div>
					<div class="inputBox">
						<input type="text" name="email" required="required" /> <span>Email</span>
					</div>
					<div class="inputBox">
						<textarea required="required" name="message"></textarea>
						<span>Type your Message....</span>
					</div>
					<a href="#" class="product-btn btn"><button style="border:none; background-color: orange">Send</button></a>
				</form>
			</div>
		</div>
	</section>
</body>
</html>
