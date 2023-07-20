<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.product"%>	
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./commonStyles/common-styles.css">
<script src="../commonStyles/common-scripts.js" defer></script>
<link rel="stylesheet" href="./css/register.css" />
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
					<li class="navLinks"><a href="addProducts.jsp"
						style="color: #fba800;">Add Products</a></li>
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

	<div class="container">
		<div class="title">Edit Product</div>
		<div class="content">
					<%
					List<product> lst = (List<product>) session.getAttribute("editProductData");
					for (product p : lst) {
					%>
			<form action="addProduct?msg=<%=p.getProdId()%>" method="post" enctype="multipart/form-data">
				<div class="user-details">
					<div class="input-box">
						<span class="details">Cake name</span> <input type="text"
							name="prodName" value="<%=p.getProdName()%>" required />
					</div>
					<div class="input-box">
						<span class="details">Category</span> <select name="category"
							id="cakes">
							<option value="cakes">Cakes</option>
							<option value="minibites">Minibites</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Description</span> <input
							type="message" name="prodDesc"
							value="<%=p.getProdDesc()%>" required />
					</div>

					<div class="input-box">
						<span class="details">Price</span> <input type="number"
							name="prodPrice" value="<%=p.getProdPrice() %>" required />
					</div>
					<div class="">
						<span class="details">Image</span> <input type="file" name="image"
							required />
					</div>
					<%} %>
				</div>
				<input type="submit" value="editandsave"
					style="background-color: #f5ce62; margin-left: 80%; margin-top: 2%; width: 16%;">
			</form>
		</div>
	</div>
</body>
</html>