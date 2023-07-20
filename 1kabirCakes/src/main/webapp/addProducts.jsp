<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						>Add Products</a></li>
					<li class="navLinks"><a
						href="getProducts?msg=${email}&category=adminView">All
							Products</a></li>
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
		<div class="title">Add new Product</div>
		<div class="content">
			<form action="addProduct?msg=<%=0%>" method="post"
				enctype="multipart/form-data">
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
					out.println(registerMessage);
					session.removeAttribute("registerMessage");
				}
				%>
				<div class="user-details">
					<div class="input-box">
						<span class="details">Cake name</span> <input type="text"
							name="prodName" placeholder="Enter cake name" required />
					</div>	
					<div class="input-box">
						<span class="details">Category</span> <select  style="padding: 10px;width:100%; background: #edf2ff; border: none;" name="category"
							id="cakes">
							<option value="cakes">Cakes</option>
							<option value="minibites">Minibites</option>
						</select>
					</div>
					<div class="input-box">
						<span class="details">Product Description</span> <input
							type="message" name="prodDesc"
							placeholder="Enter product description" required />
					</div>

					<div class="input-box">
						<span class="details">Product price</span> <input type="number"
							name="prodPrice" placeholder="Product price" required />
					</div>
					<div class="">
						<span class="details">Image</span> <input type="file" name="image"
							required />
					</div>
				</div>
				<input type="submit" value="Add"
					style="background-color: #f5ce62; margin-left: 80%; margin-top: 1%; background-color: var(- -primary-color); cursor: pointer; padding: 1rem 2rem; width: 20%;">
			</form>
		</div>
	</div>
</body>
</html>