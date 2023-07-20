<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/Home.css">
<link rel="stylesheet" href="./commonStyles/common-styles.css">
<script src="./commonStyles/common-scripts.js" defer></script>
<title>Insert title here</title>
</head>
<body>
	<div class="navbar">
		<div class="nav-container">
			<div class="logo">
				<img src="./images/logo.png" alt="logo" loading="lazy"
					style="height: 8rem; position: relative left:50px">
			</div>
			<div id="menuToggle">
				<input type="checkbox" /> <span id="span1"></span> <span id="span2"></span>
				<span id="span3"></span>
			</div>
			<div class="navbar-links">
				<ul>
					<li class="navLinks"><a href="addProducts.jsp">Add Products</a></li>
					<li class="navLinks"><a href="getProducts?msg=${email}&category=adminView">All Products</a></li>
					<li class="navLinks"><a href="getFeedback">Received Messages</a></li>
					<li class="navLinks"><a href="getOrders?status=processing">Orders Received</a></li>
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

</body>
</html>