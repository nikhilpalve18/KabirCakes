<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.cart"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>my Cart</title>
<link rel="stylesheet" href="./commonStyles/common-styles.css" />
<link rel="stylesheet" href="./css/Home.css" />
<script src="./commonStyles/common-scripts.js" defer></script>
</head>
<style>
td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<%
	String email = null;
	if (session.getAttribute("email") == null) {
		email = (String) session.getAttribute("email");
		response.sendRedirect("login.jsp");
	}
	%>
	<section class="header-container">
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
		</div>
		<%
		String msg = request.getParameter("msg");
		if (msg != null) {
			if (msg.equals("NotPossible")) {
		%><h2 style="background-color: white">Cannot decrement!only one
			quantity!</h2>
		<%
		}
		if (msg.equals("cannotIncrease")) {
		%>
		<h2 style="background-color: white">Maximum 5 quantity can be
			ordered</h2>
		<%
		}
		}
		%>
		<div class="cartItems" style="background-color: white">
			<%
			List<cart> lst = (List<cart>) session.getAttribute("cartItems");
			int total = 0;
			for (cart c : lst) {
				total += c.getTotal();
			}
			if (!lst.isEmpty()) {
			%>
			<a href="AddressPayment.jsp"><button class="btn">CheckOut</button></a>
			<%
			}
			%>
			<a href="getProducts?msg=${email}&category=cakes" class="btn">Continue
				Shopping</a>

			<h2>
				Total Price:<%=total%></h2>
			<table style="width: 100%;">
				<tr style="text-align: center">
					<th>Sr.No</th>
					<th>Name</th>
					<th>Price</th>
					<th>Buy Now</th>
					<th>SubTotal</th>
					<th>Cancel</th>
				</tr>
				<%
				int srNo = 1;
				for (cart c : lst) {
				%>
				<tr>
					<td><%=srNo++%></td>
					<td><%=c.getProdName()%></td>
					<td><%=c.getPrice()%></td>
					<td><a
						href="getCart?msg=${email}&id=<%=c.getProdId()%>&quantity=dec"><img
							alt="" src="./images/minus.png"></a> <%=c.getQuantity()%> <a
						href="getCart?msg=${email}&id=<%=c.getProdId()%>&quantity=inc"><img
							alt="" src="./images/plus.png"></a></td>
					<td><%=c.getTotal()%></td>
					<td><a
						href="removeFromCart?msg=${email}&id=<%=c.getProdId()%>">Remove</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</section>


</body>
</html>