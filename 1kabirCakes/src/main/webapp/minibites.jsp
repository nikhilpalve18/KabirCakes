<%@ page import="java.util.List"%>
<%@ page import="model.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Products-Cakes</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/minibites.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<body>
	<section class="header-container">
		<img class="header-img" src="./images/mini-bites-header.jpg"
			alt="Cakes-header-img" loading="lazy" />
		<div class="header">
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
							<li><a href="home.jsp">Home</a></li>
							<li class="navLinks"><a
								href="getProducts?msg=${email}&category=cakes">Cakes</a></li>
							<li class="navLinks"><a
								href="getProducts?msg=${email}&category=minibites">Mini
									Bites</a></li>
							<li class="navLinks"><a href="About-Us.jsp">About Us</a></li>
							<li class="navLinks"><a href="getCart?msg=${email}">MyCart</a></li>
							<li class="navLinks"><a href="Contact-Us.jsp">Contact Us</a></li>
							<li>
							<%
							String email = (String)session.getAttribute("email");
							if(email != null){%>
								<form action="logout">
									<button class="btn"border-radius:10px;">
										<span>LogOut</span></a>
									</button>
								</form>			
							<%						
							}
							%>
								
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="tag-line">
				<h2>Our Delicious Cakes</h2>
				<h3>Life is too short to say no the cakes</h3>
			</div>
			<div class="search">
				<form action="search?category=minibites" method="post">
					<label> <input type="text" name="searchText"
						placeholder="Search" />
					</label>
				</form>
			</div>
		</div>
	</section>

	<section class="products-container">
		<%
		List<product> lst = (List<product>) session.getAttribute("Allproducts");
		int srNo = 0;
		for (product p : lst) {
			srNo++;
			System.out.println("Hello Nikhil " + srNo);
		%>
		<div class="product product-<%=srNo%>">
			<div class="product__image">
				<span class="product__price"><%=p.getProdPrice()%></span> <img
					src="./images/<%=p.getImageFileName()%>" loading="lazy" />
			</div>
			<div class="product-text">
				<h1 class="product__title"><%=p.getProdName()%></h1>
				<hr />
				<p><%=p.getProdDesc()%></p>
				<a class="product-btn btn"
					href="addToCart?prodId=<%=p.getProdId()%>&prodDesc=<%=p.getProdDesc()%>">AddtoCart</a>
			</div>
		</div>
		<%
		}
		%>
	</section>

	<section class="footer">
		<img src="./images/footer image.jpg" alt="footer image" loading="lazy" />
		<div class="footer-tag-line">
			<h3>An Occasion is just incomplete without a cake</h3>
			<h2>So order your cake now!!</h2>
			<!--
			<a href="../Order-Now/Order-Now.html" class="product-btn btn"> <span>Buy
					Now</span>
			</a>
			-->
		</div>
	</section>
</body>
</html>
