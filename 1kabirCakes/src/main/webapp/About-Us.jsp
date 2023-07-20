<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Kabir Cakes</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/About-Us.css" />
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
					<%String email = (String) session.getAttribute("email");
					if(email != null){	
					%>
					<li class="navLinks"><a href="#" style="color: #fba800;">Welcome
							${email}</a></li>
					<%}%>
					<% 
					if(email != null){ %>										
					<li class="navLinks"><a href="home.jsp">Home</a></li>
					<%}%>
					<li class="navLinks"><a
						href="getProducts?msg=${email}&category=cakes">Cakes</a></li>
					<li class="navLinks"><a
						href="getProducts?msg=${email}&category=minibites">Mini Bites</a></li>
					<li class="navLinks"><a href="About-Us.jsp">About Us</a></li>
					<% 
					if(email != null){ %>					
					<li class="navLinks"><a href="getCart?msg=${email}">MyCart</a></li>
					<%}%>
					<li class="navLinks"><a href="#">Contact Us</a></li>
					<li>
						<%
				
					if (email != null) {
					%>
						<form action="logout">
							<button class="btn"border-radius:10px;">
								<span>LogOut</span></a>
							</button>
						</form> <%
					}
					%>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<section class="about-us-overview">
		<div class="about-us-heading">
			<h3>A Little About Us</h3>
		</div>
		<hr />
		<div class="para-1">
			<p>" We are not just a bakery, we are not just bakers. In fact,
				we are just like you, a bunch of food lovers fascinated with sweet
				indulgence, who dreamt of creating an appetizing fairy land of
				divine delicacies that relishes the utmost desires. "</p>
		</div>
		<div class="img-text">
			<div class="text">
				<h5>We Make</h5>
				<h4>Fine Pie For Fine Folkes</h4>
			</div>
			<div class="image">
				<img src="./images/about us cake.jpg" alt="cake" loading="lazy" />
			</div>
		</div>
		<div class="para-2">
			<p>All of our pies are handmade using high quality ingredients
				with offerings that change with the seasons.</p>
		</div>
	</section>
	<section class="story">
		<h2>Our Story</h2>
		<hr />
		<p>
			After being introduced in 2011, Mary and Megan came up with the dream
			of Emporium Pies. Before the year had come to a close, their dream
			was rapidly beginning to take shape in the form of selling pies
			outside of an old house in the Bishop Arts District of Oak Cliff. <br />
			<br /> With a little help from talented friends along the way, a
			supportive community surrounding each store, and an endless supply of
			hungry and happy customers, Emporium Pies has grown up a lot.
			However, it always has been and always will be about one thing: fine
			pies for fine folk.
		</p>
	</section>
	<section class="hire">
		<h4>Come work with us</h4>
		<p>If you are interested in applying for a position, please submit
			your resume with a brief cover letter to the specific department on
			our jobs page. If we are not currently hiring, we will keep your
			information on file should a position become available.</p>
	</section>
	<section class="footer-container">
		<div class="logo-social-media">
			<div class="footer-logo">
				<img src="./images/logo.png" alt="logo" loading="lazy" />
			</div>
			<div class="social-media-icons-footer">
				<h4 style="display: inline">Connect Us:</h4>
				<img src="./images/instagram.png" alt="insta logo" loading="lazy" />
				<img src="./images/facebook.png" alt="insta logo" loading="lazy" />
				<img src="./images/whatsapp.png" alt="insta logo" loading="lazy" />
			</div>
		</div>
		<div class="newsLetter">
			<h4>Subscibe to our Newsletter</h4>
			<div class="news-letter-input">
				<input type="text" placeholder="Enter your Email" />
			</div>
		</div>

		<div class="pages-link">
			<h4>Pages</h4>
			<a href="home.jsp"><p>Home</p></a> <a href="cakes.jsp"><p>Cakes</p></a>
			<a href="minibites.jsp"><p>Mini-Bites</p></a> <a href="About-Us.jsp"><p>About
					Us</p></a> <a href="cart"><p>My Cart</p></a> <a href="Contact-Us.jsp"><p>Contact-Us</p></a>
		</div>
	</section>
</body>
</html>
